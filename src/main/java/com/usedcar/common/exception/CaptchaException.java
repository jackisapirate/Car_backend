package com.usedcar.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Kunlong Wang
 * @create 2021-11-23 12:14
 */
public class CaptchaException extends AuthenticationException {

    public CaptchaException(String msg) {
        super(msg);
    }
}
