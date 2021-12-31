package com.learn.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.learn.controller.feign.UserServiceFeignClient;
import com.learn.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/autoDeliver")
public class AutoDeliverFeignController {

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;


    @GetMapping("/findOpenStatusByUid")
    @SentinelResource(value = "findOpenStatusByUid",
            blockHandlerClass = SentinelFallback.class,
            blockHandler = "handleException",
            fallbackClass = SentinelFallback.class,
            fallback = "handleError")
    public Integer findOpenStatusByUid(@RequestParam("uid") Integer uid) {
//        测试慢比例调用
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        测试异常熔断
//        int i = 1/0;
        System.out.println("请求到这了");
        UserInfo userById = userServiceFeignClient.findUserById(uid);
        return userById.getOpen();
    }



}
