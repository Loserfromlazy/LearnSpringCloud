package com.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.entity.Result;
import com.learn.entity.User;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * UserService
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/27
 */
public interface UserService extends IService<User> {

    Result<Boolean> addPoints(Integer id,Integer points);
}
