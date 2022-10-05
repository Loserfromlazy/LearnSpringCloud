package com.learn.controller;

import com.learn.entity.Result;
import com.learn.service.UserService;
import com.learn.service.UserTCCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * UserController
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/27
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
//    UserService userService;
    UserTCCService userService;
    @GetMapping("/addPoints")
    public Result<Boolean> addPoints(@RequestParam("id") Integer id, @RequestParam("points") Integer points) {
        return userService.addPoints(id, points);
    }
}
