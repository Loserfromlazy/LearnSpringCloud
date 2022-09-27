package com.learn.feign.fallback;

import com.learn.entity.Result;
import com.learn.feign.WarehouseFeign;
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
public class WarehouseFeignFallback implements FallbackFactory<WarehouseFeign> {

    @Override
    public WarehouseFeign create(Throwable cause) {
        return new WarehouseFeign() {
            @Override
            public Result<Boolean> reduceGoods(Integer id, Integer nums) {
                return ResultUtils.resultInit(0, cause.getMessage(), false);
            }
        };
    }
}
