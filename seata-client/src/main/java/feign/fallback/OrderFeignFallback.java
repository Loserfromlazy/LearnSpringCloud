package feign.fallback;

import feign.OrderFeign;
import feign.UserFeign;
import feign.hystrix.FallbackFactory;

/**
 * <p>
 * UserFeignFallback
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/26
 */
public class OrderFeignFallback implements FallbackFactory<OrderFeign> {
    @Override
    public OrderFeign create(Throwable cause) {
        return new OrderFeign();
    }
}
