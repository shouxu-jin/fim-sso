package com.yytxdy.fim.sso.controller;

import com.yytxdy.fim.sso.entity.User;
import com.yytxdy.fim.sso.exceptions.DuplicatedSMSException;
import com.yytxdy.fim.sso.exceptions.InvalidVerificationCodeException;
import com.yytxdy.fim.sso.service.SMSService;
import com.yytxdy.fim.sso.service.UserService;
import com.yytxdy.fim.sso.service.VerificationCodeGenerator;
import com.yytxdy.fim.sso.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sso")
public class SsoController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;
    @Autowired
    private SMSService smsService;
    @Autowired
    private VerificationCodeGenerator verificationCodeGenerator;

    @RequestMapping("/login")
    public Result login(@RequestParam String telephone, @RequestParam String verificationCode) {
        String verificationCodeInRedis = (String) redisTemplate.boundValueOps(telephone + "-verification").get();
        if (!StringUtils.equals(verificationCode, verificationCodeInRedis)) {
            throw new InvalidVerificationCodeException(verificationCode);
        }
        User user = new User();
        user.setTelephone(telephone);
        userService.save(user);
        String token = UUID.randomUUID().toString();
        redisTemplate.boundValueOps(telephone).set(token, 30, TimeUnit.DAYS);
        return Result.ok().put("token", token);
    }

    @RequestMapping("/sendVerificationCode")
    public Result sendVerificationCode(@RequestParam String telephone) {
        String verificationCode = verificationCodeGenerator.generate();
        if (null != redisTemplate.boundValueOps(telephone + "-verification-done").get()) {
            return Result.error(new DuplicatedSMSException());
        }
        redisTemplate.boundValueOps(telephone + "-verification").set(verificationCode, 30, TimeUnit.MINUTES);
        smsService.send("您的验证码是: " + verificationCode);
        redisTemplate.boundValueOps(telephone + "-verification-done").set(true, 1, TimeUnit.MINUTES);
        return Result.ok();
    }
}
