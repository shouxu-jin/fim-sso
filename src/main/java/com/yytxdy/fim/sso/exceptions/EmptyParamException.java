package com.yytxdy.fim.sso.exceptions;

import com.yytxdy.fim.sso.utils.ErrorCodes;

public class EmptyParamException extends BaseException {
    public EmptyParamException(String msg) {
        super(msg);
        setCode(ErrorCodes.EMPTY_PARAM);
    }
}
