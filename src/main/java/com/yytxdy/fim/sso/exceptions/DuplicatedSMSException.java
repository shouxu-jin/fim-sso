package com.yytxdy.fim.sso.exceptions;

import com.yytxdy.fim.sso.utils.ErrorCodes;

public class DuplicatedSMSException extends BaseException {
    public DuplicatedSMSException() {
        super(ErrorCodes.DUPLICATED_SMS, "请勿重复发送验证码");
    }
}
