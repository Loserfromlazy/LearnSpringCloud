package com.learn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.entity.Order;
import com.learn.entity.Result;
import com.learn.mapper.OrderMapper;
import com.learn.service.OrderService;
import com.learn.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;

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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Result<Boolean> addOrder(Order order) {
        order.setCreateTime(new Date());
        try {
            orderMapper.insert(order);
        } catch (Exception e) {
            log.error("插入订单失败，错误信息{}", e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.resultInit(0, e.getMessage(), false);
        }
        return ResultUtils.successBuild(true);
    }
}
