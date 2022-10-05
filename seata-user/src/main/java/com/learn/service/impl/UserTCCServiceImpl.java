package com.learn.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.entity.Order;
import com.learn.entity.Result;
import com.learn.entity.User;
import com.learn.mapper.UserMapper;
import com.learn.service.UserService;
import com.learn.service.UserTCCService;
import com.learn.utils.ResultUtils;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

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
public class UserTCCServiceImpl extends ServiceImpl<UserMapper, User> implements UserTCCService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Result<Boolean> addPoints(Integer id, Integer points) {
        User userSelect = userMapper.selectById(id);
        User user = new User();
        user.setId(id);
        //设置中间积分
        user.setSeataPoint(points);
        int updateById = userMapper.updateById(user);
        if (updateById<0){
            ResultUtils.resultInit(0,"更新积分失败",false);
        }
        log.info("更新积分成功");
        return ResultUtils.successBuild(true);
    }

    @Override
    public boolean commitPoints(BusinessActionContext context) {
        User userSelect = userMapper.selectById((Serializable) context.getActionContext("id"));
        if (userSelect!=null){
            int pointResult = userSelect.getPoint() + userSelect.getSeataPoint();
            userSelect.setPoint(pointResult);
            userSelect.setSeataPoint(0);
            userMapper.updateById(userSelect);
        }
        log.info("提交成功，xid={}",context.getXid());
        return true;
    }

    @Override
    public boolean rollbackPoints(BusinessActionContext context) {
        Object userId = context.getActionContext("id");
        User userSelect = userMapper.selectById((Serializable) userId);
        if (userSelect!=null){
            userSelect.setSeataPoint(0);
            userMapper.updateById(userSelect);
        }
        log.info("回滚成功，xid={}",context.getXid());
        return true;
    }
}
