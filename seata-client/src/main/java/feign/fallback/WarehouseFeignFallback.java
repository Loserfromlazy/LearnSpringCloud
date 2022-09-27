package feign.fallback;

import feign.WarehouseFeign;
import feign.hystrix.FallbackFactory;

/**
 * <p>
 * UserFeignFallback
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/26
 */
public class WarehouseFeignFallback implements FallbackFactory<WarehouseFeign> {
    @Override
    public WarehouseFeign create(Throwable cause) {
        return new WarehouseFeign();
    }
}
