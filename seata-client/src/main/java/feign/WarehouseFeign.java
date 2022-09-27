package feign;

import feign.fallback.WarehouseFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * UserFeign
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/26
 */
@FeignClient(name = "seata-warehouse",
        path = "/xxx",
        fallbackFactory = WarehouseFeignFallback.class)
public class WarehouseFeign {
}
