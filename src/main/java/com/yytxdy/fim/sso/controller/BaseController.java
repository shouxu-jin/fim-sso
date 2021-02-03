package com.yytxdy.fim.sso.controller;

import com.yytxdy.fim.sso.exceptions.BaseException;
import com.yytxdy.fim.sso.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler({RuntimeException.class})
    public Result exceptionHandler(Exception e) {
        logger.error(getClass().getName(), e);
        if (e instanceof BaseException) {
            return Result.error((BaseException) e);
        }
        return Result.error(e.getMessage());
    }
}
