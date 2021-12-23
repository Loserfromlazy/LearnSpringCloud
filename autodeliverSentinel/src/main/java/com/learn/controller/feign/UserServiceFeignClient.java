package com.learn.controller.feign;

import com.learn.pojo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * UserServiceFeignClient
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/17
 */
@FeignClient(name = "user", path = "/user")
public interface UserServiceFeignClient {

    @GetMapping("/findUserById")
    UserInfo findUserById(@RequestParam("id") Integer id);
}
