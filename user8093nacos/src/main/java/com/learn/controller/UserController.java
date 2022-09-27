package com.learn.controller;

import com.learn.pojo.UserInfo;
import com.learn.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * UserController
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/findUserById")
    public UserInfo findUserById(@RequestParam("id") Integer id) {
//        //模拟访问超时
//        try {
//            Thread.sleep(10000000);
//        }catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("当前是8093，目前请求到这里了"+new Date());
        return userInfoService.findUserById(id);
    }
}
