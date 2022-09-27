package feign;

import feign.fallback.OrderFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * UserFeign
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/26
 */
@FeignClient(name = "seata-order",
        path = "/xxx",
        fallbackFactory = OrderFeignFallback.class)
public class OrderFeign {
}
