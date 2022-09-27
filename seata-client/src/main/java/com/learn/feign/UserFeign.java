package com.learn.feign;

import com.learn.entity.Result;
import com.learn.feign.fallback.UserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * UserFeign
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/26
 */
@FeignClient(name = "seata-user",
        path = "/user",
        fallbackFactory = UserFeignFallback.class)
public interface UserFeign {
    @GetMapping("/addPoints")
    Result<Boolean> addPoints(@RequestParam("id") Integer id, @RequestParam("points") Integer points);
}
