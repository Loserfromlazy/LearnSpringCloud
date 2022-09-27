package com.learn.feign;

import com.learn.entity.Result;
import com.learn.feign.fallback.WarehouseFeignFallback;
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
@FeignClient(name = "seata-warehouse",
        path = "/warehouse",
        fallbackFactory = WarehouseFeignFallback.class)
public interface WarehouseFeign {

    @GetMapping("reduceGoods")
    Result<Boolean> reduceGoods(@RequestParam("id") Integer id, @RequestParam("nums") Integer nums);
}
