package com.yytxdy.fim.sso.vo;


import com.yytxdy.fim.sso.exceptions.BaseException;
import com.yytxdy.fim.sso.utils.ErrorCodes;

import java.util.HashMap;

public class Result extends HashMap<String, Object> {
    public Result() {
        put("code", "200");
        put("msg", "success");
    }

    public static Result ok() {
        return new Result();
    }

    public static Result error(String code, String msg) {
        return new Result().put("code", code).put("msg", msg);
    }

    public static Result error(String msg) {
        return new Result().put("code", ErrorCodes.UNKNOWN).put("msg", msg);
    }

    public static Result error(BaseException e) {
        return new Result().put("code", e.getCode()).put("msg", e.getMsg());
    }

    public static Result error() {
        return error(ErrorCodes.UNKNOWN, ErrorCodes.UNKNOWN);
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
