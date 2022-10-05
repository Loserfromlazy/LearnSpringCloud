package com.learn.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.entity.Order;
import com.learn.entity.Result;
import com.learn.mapper.OrderMapper;
import com.learn.service.OrderTCCService;
import com.learn.utils.ResultUtils;
import io.seata.rm.tcc.api.BusinessActionContext;
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
public class OrderTCCServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderTCCService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Result<Boolean> addOrder(Order order) {
        order.setCreateTime(new Date());
        int notUse = 0;
        //0为不可用，事务未提交 1为可用，事务已经提交
        order.setStatus(notUse);//预检查
        try {
            orderMapper.insert(order);
        } catch (Exception e) {
            log.error("插入订单失败，错误信息{}", e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.resultInit(0, e.getMessage(), false);
        }
        log.info("新增订单成功");
        return ResultUtils.successBuild(true);
    }

    @Override
    public boolean commitOrder(BusinessActionContext context) {
        Object orderJson = context.getActionContext("order");
        Order order = JSON.parseObject(orderJson.toString(), Order.class);
        Order orderSelect = orderMapper.selectById(order.getId());
        if (orderSelect!=null){
            //二阶段提交
            orderSelect.setStatus(1);
            orderMapper.updateById(orderSelect);
        }
        log.info("提交成功，xid={}",context.getXid());
        //这里需要返回true，如果为false会不断的去重试，可以在配置中心配置重试策略
        return true;
    }

    @Override
    public boolean rollbackOrder(BusinessActionContext context) {
        Object orderJson = context.getActionContext("order");
        Order order = JSON.parseObject(orderJson.toString(), Order.class);
        if (order!=null){
            //二阶段回滚，删除订单
            orderMapper.deleteById(order.getId());
        }
        log.info("回滚成功，xid={}",context.getXid());
        //这里需要返回true，如果为false会不断的去重试，可以在配置中心配置重试策略
        return true;
    }
}
