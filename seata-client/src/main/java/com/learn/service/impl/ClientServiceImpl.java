package com.learn.service.impl;

import com.learn.entity.Order;
import com.learn.entity.Result;
import com.learn.service.ClientService;
import com.learn.feign.OrderFeign;
import com.learn.feign.UserFeign;
import com.learn.feign.WarehouseFeign;
import com.learn.utils.ResultUtils;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * ClientServiceImpl
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/26
 */
@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    OrderFeign orderFeign;

    @Autowired
    UserFeign userFeign;

    @Autowired
    WarehouseFeign warehouseFeign;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public Result<Boolean> buy(Integer num, Integer userId, Integer goodsId) {
        Order order = new Order();
        order.setGoodsId(goodsId);
        order.setName("购买商品"+goodsId);
        order.setUserId(userId);
        order.setNums(num);
        order.setCreateTime(new Date());
        Result<Boolean> result = orderFeign.addOrder(order);
        if (!result.getResult()){
            return ResultUtils.resultInit(0,"购买失败，原因"+result.getMsg(),false);
        }
        Result<Boolean> result1 = userFeign.addPoints(userId, num);
        if (!result1.getResult()){
            return ResultUtils.resultInit(0,"购买失败，原因"+result1.getMsg(),false);
        }
        Result<Boolean> result2 = warehouseFeign.reduceGoods(goodsId, num);
        if (!result2.getResult()){
            return ResultUtils.resultInit(0,"购买失败，原因"+result2.getMsg(),false);
        }
        return ResultUtils.successBuild(true);
    }
}
