package com.usedcar.controller;

import com.usedcar.common.lang.Result;
import com.usedcar.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kunlong Wang
 * @create 2021-11-21 16:34
 *
 *
 * This is a test Controller
 * This is a test Controller
 * This is a test Controller
 */
@RestController
public class TestController {
    @Autowired
    SysUserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/test")
    public Object test() {
        System.out.println("This is a test Controller");
        return Result.succ(userService.list());
    }

    @PreAuthorize("hasAuthority('sys:user:list')")
    @GetMapping("/test/pass")
    public Result pass() {

        String password = bCryptPasswordEncoder.encode("root");

        boolean matches = bCryptPasswordEncoder.matches("root", password);

        return Result.succ(password);
    }
}
