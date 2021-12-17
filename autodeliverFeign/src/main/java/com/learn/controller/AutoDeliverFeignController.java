package com.learn.controller;

import com.learn.controller.feign.UserServiceFeignClient;
import com.learn.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * AutoDeliverFeignController
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/17
 */
@RestController
@RequestMapping("/autoDeliverFeign")
public class AutoDeliverFeignController {

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;

    @GetMapping("/findOpenStatusByUid")
    public Integer findOpenStatusByUid(@RequestParam("uid") Integer uid){
        //表面上是调用本地方法，实际上feign帮我们拼接url访问远程方法
        UserInfo userById = userServiceFeignClient.findUserById(uid);
        return userById.getOpen();
    }
}
