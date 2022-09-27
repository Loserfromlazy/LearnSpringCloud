package com.learn.service.Impl;

import com.learn.mapper.UserInfoMapper;
import com.learn.pojo.UserInfo;
import com.learn.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * UserInfoServiceImpl
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/14
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findUserById(Integer id) {
        return userInfoMapper.selectById(id);
    }
}
