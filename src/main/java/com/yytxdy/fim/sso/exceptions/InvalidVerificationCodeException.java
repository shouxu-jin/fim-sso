package com.yytxdy.fim.sso.exceptions;

import com.yytxdy.fim.sso.utils.ErrorCodes;

public class InvalidVerificationCodeException extends BaseException {
    public InvalidVerificationCodeException(String verificationCode) {
        super(ErrorCodes.INVALID_VERIFICATION_CODE, "无效的验证码: " + verificationCode);
    }
}
