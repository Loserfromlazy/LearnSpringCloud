package feign.fallback;

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
public class UserFeignFallback implements FallbackFactory<UserFeign> {
    @Override
    public UserFeign create(Throwable cause) {
        return new UserFeign();
    }
}
