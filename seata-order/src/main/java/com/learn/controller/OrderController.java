package com.learn.controller;

import com.learn.entity.Order;
import com.learn.entity.Result;
import com.learn.service.OrderService;
import com.learn.service.OrderTCCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * OrderController
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/26
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
//    OrderService orderService;
    OrderTCCService orderService;
    @PostMapping("/addOrder")
    public Result<Boolean> addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }
}
