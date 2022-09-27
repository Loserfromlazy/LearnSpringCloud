package com.learn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.entity.Result;
import com.learn.entity.User;
import com.learn.mapper.UserMapper;
import com.learn.service.UserService;
import com.learn.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * OrderServiceImpl
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/27
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Result<Boolean> addPoints(Integer id, Integer points) {
        User userSelect = userMapper.selectById(id);
        User user = new User();
        user.setId(id);
        int nowPoint = userSelect.getPoint() + points;
        user.setPoint(nowPoint);
        int updateById = userMapper.updateById(user);
        if (updateById<0){
            ResultUtils.resultInit(0,"更新积分失败",false);
        }
        return ResultUtils.successBuild(true);
    }
}
