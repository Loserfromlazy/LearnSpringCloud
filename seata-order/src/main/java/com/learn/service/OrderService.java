package com.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.entity.Order;
import com.learn.entity.Result;

/**
 * <p>
 * OderService
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/27
 */
public interface OrderService extends IService<Order> {

    Result<Boolean> addOrder(Order order);
}
