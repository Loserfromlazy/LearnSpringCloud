package com.learn.controller.feign;

import com.learn.pojo.UserInfo;
import org.springframework.stereotype.Component;

/**
 * <p>
 * UserServiceFeignFallback
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/17
 */
@Component
public class UserServiceFeignFallback implements UserServiceFeignClient{
    @Override
    public UserInfo findUserById(Integer id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setOpen(-7);
        return userInfo;
    }
}
