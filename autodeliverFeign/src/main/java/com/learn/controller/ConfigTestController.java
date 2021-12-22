package com.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * ConfigTestController
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/22
 */
@RestController
@RequestMapping("config")
@RefreshScope
public class ConfigTestController {

    @Value("${testname.namestr}")
    private String testStr;

    @RequestMapping("testGetConfig")
    public String testGetConfig(){
        return testStr;
    }
}
