package com.learn.controller.feign;

import com.learn.pojo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * UserServiceFeignClient
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/17
 */
//FeignClient表明当前类是一个FeignClient客户端；value指定要请求的服务名称，本项目中指的是user微服务
@FeignClient(name = "user")
@RequestMapping("/user")
public interface UserServiceFeignClient {

    @GetMapping("/findUserById")
    UserInfo findUserById(@RequestParam("id") Integer id);
}
