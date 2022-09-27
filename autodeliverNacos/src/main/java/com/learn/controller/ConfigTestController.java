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

    @Value("${test.name}")
    private String name;
    @Value("${test.sex}")
    private String sex;

    @RequestMapping("testGetConfig")
    public String testGetConfig(){
        return "name="+name+";sex="+sex;
    }
}
