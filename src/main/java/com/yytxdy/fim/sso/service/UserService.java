package com.yytxdy.fim.sso.service;

import com.yytxdy.fim.sso.entity.User;
import com.yytxdy.fim.sso.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void save(User user) {
        userMapper.save(user);
    }
}
