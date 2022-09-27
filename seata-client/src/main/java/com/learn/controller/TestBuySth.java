package com.learn.controller;

import com.learn.entity.Result;
import com.learn.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * TestBuySth
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/26
 */
@RestController
@RequestMapping("/test")
public class TestBuySth {

    @Autowired
    ClientService clientService;

    @GetMapping("/testBuy1")
    public Result<Boolean> testBuy1() {
        return clientService.buy(10,1,1);
    }

    @GetMapping("/testBuy2")
    public Result<Boolean> testBuy2() {
        return clientService.buy(100,1,1);
    }
}
