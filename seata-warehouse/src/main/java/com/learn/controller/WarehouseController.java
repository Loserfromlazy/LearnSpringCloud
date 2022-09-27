package com.learn.controller;

import com.learn.entity.Result;
import com.learn.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * UserController
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/27
 */
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("reduceGoods")
    public Result<Boolean> reduceGoods(@RequestParam("id") Integer id,@RequestParam("nums") Integer nums){
        return goodsService.reduceGoods(id, nums);
    }
}
