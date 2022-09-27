package com.learn.feign;

import com.learn.entity.Order;
import com.learn.entity.Result;
import com.learn.feign.fallback.OrderFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * UserFeign
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/26
 */
@FeignClient(name = "seata-order",
        path = "/order",
        fallbackFactory = OrderFeignFallback.class)
public interface OrderFeign {

    @GetMapping("/addOrder")
    Result<Boolean> addOrder(Order order);
}
