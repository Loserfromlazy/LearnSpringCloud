package com.learn.feign.fallback;

import com.learn.entity.Result;
import com.learn.feign.UserFeign;
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
public class UserFeignFallback implements FallbackFactory<UserFeign> {

    @Override
    public UserFeign create(Throwable cause) {
        return new UserFeign() {
            @Override
            public Result<Boolean> addPoints(Integer id, Integer points) {
//                throw new RuntimeException("进入到addPoints的降级方法，抛出异常，便于seata回滚");
                return ResultUtils.resultInit(0,cause.getMessage(),false);
            }
        };
    }
}
