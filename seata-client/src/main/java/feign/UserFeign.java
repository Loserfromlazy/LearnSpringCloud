package feign;

import feign.fallback.UserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * UserFeign
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/26
 */
@FeignClient(name = "seata-user",
        path = "/xxx",
        fallbackFactory = UserFeignFallback.class)
public class UserFeign {
}
