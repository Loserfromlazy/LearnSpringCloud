package com.learn.service.impl;

import com.learn.service.ClientService;
import feign.OrderFeign;
import feign.UserFeign;
import feign.WarehouseFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void buy(Integer num, Integer userId, Integer goodsId) {

    }
}
