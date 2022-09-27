package com.learn.controller;

import com.learn.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String register(){
        System.out.println(new Date()+"注册成功");
        validateID();
        return "注册成功";
    }

    @GetMapping("/register1")
    public String register1(){
        System.out.println(new Date()+"注册成功1");
        userService.validateID();
        return "注册成功1";
    }

    @GetMapping("/register2")
    public String register2(){
        System.out.println(new Date()+"注册成功2");
        userService.validateID();
        return "注册成功2";
    }

    @GetMapping("/validateID")
    public String validateID(){
        System.out.println("验证身份成功");
        return "验证身份成功";
    }
}
