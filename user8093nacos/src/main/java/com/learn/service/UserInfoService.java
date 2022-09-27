package com.learn.service;

import com.learn.pojo.UserInfo;

/**
 * <p>
 * UserInfoService
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/14
 */
public interface UserInfoService {
    UserInfo findUserById(Integer id);
}
