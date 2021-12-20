package com.usedcar.security;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.usedcar.common.exception.CaptchaException;
import com.usedcar.common.lang.Const;
import com.usedcar.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Kunlong Wang
 * @create 2021-11-23 11:22
 */
@Component
public class CaptchaFilter extends OncePerRequestFilter {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    LoginFailureHandler loginFailureHandler;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String url = httpServletRequest.getRequestURI();
        if("/login".equals(url) && httpServletRequest.getMethod().equals("POST")){
            // Verify the verification code only for login requests and POST requests
            try{
                validate(httpServletRequest);

            } catch(CaptchaException e){
                loginFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }

    private void validate(HttpServletRequest httpServletRequest){

        String code = httpServletRequest.getParameter("code");
        String key = httpServletRequest.getParameter("token");
        if(StringUtils.isBlank(code) || StringUtils.isBlank(key)){
            throw new CaptchaException("Verification code error");
        }

        if(!code.equals(redisUtil.hget(Const.CAPTCHA_KEY, key))){
            throw new CaptchaException("Verification code error");
        }
        // Verification code used once,so should delete redis verification code
        redisUtil.hdel(Const.CAPTCHA_KEY, key);
    }
}
