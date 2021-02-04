package com.yytxdy.fim.sso.service;

import org.springframework.stereotype.Service;

@Service
public class VerificationCodeGenerator {
    public String generate() {
        int verificationCode = (int) ((Math.random() * 9 + 1) * 100000);
        return String.valueOf(verificationCode);
    }
}