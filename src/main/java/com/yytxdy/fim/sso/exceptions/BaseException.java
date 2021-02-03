package com.yytxdy.fim.sso.exceptions;

import com.yytxdy.fim.sso.utils.ErrorCodes;

public class BaseException extends RuntimeException {
    private String code;
    private String msg;

    public BaseException(String msg) {
        super(msg);
        this.msg = msg;
        this.code = ErrorCodes.UNKNOWN;
    }

    public BaseException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
