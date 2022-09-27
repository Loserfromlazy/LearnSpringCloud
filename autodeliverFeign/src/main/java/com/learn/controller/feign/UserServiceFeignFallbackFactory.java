package com.learn.controller.feign;

import com.learn.pojo.UserInfo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * <p>
 * UserServiceFeignFallbackFactory
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/17
 */
@Component
public class UserServiceFeignFallbackFactory implements FallbackFactory<UserServiceFeignClient> {

    @Override
    public UserServiceFeignClient create(Throwable throwable) {
        return new UserServiceFeignClient() {
            @Override
            public UserInfo findUserById(Integer id) {
                System.out.println(throwable.getMessage());
                UserInfo userInfo = new UserInfo();
                userInfo.setOpen(-7);
                return userInfo;
            }
        };
    }
}
