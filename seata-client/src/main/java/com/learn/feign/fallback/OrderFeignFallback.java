package com.learn.feign.fallback;

import com.learn.entity.Order;
import com.learn.entity.Result;
import com.learn.feign.OrderFeign;
import com.learn.utils.ResultUtils;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 * UserFeignFallback
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/26
 */
@Slf4j
@Component
public class OrderFeignFallback implements FallbackFactory<OrderFeign> {

    @Override
    public OrderFeign create(Throwable cause) {
        return new OrderFeign() {
            @Override
            public Result<Boolean> addOrder(Order order) {
//                throw new RuntimeException("进入到addOrder的降级方法，抛出异常，便于seata回滚");
                return ResultUtils.resultInit(0,cause.getMessage(),false);
            }
        };
    }
}
