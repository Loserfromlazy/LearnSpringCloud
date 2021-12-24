package com.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * UserController
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/register")
    public String register(){
        System.out.println("注册成功");
        return "注册成功";
    }

    @GetMapping("/validateID")
    public String validateID(){
        System.out.println("验证身份成功");
        return "验证身份成功";
    }
}
