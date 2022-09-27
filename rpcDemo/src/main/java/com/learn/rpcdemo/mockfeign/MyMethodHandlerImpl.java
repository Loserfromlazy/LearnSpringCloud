package com.learn.rpcdemo.mockfeign;

import com.alibaba.fastjson.JSONObject;
import com.learn.entity.Result;
import com.learn.rpcdemo.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;

/**
 * <p>
 * MyMethodHandlerImpl
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/5
 */
@Slf4j
public class MyMethodHandlerImpl implements MyMethodHandler{

    /**
     * REST URL的前半部分，来自Feign接口的类级别注释
     * 比如：“http://www.demo.com:8111/demo”
     */
    final String contextPath;
    /**
     * REST URL的后半部分，来自Feign接口的方法级别注释
     * 比如："/print"或"/test"
     */
    final String url;

    public MyMethodHandlerImpl(String contextPath, String url) {
        this.contextPath = contextPath;
        this.url = url;
    }

    @Override
    public Object invoke(Object[] args) throws Throwable {
        String restUrl = contextPath + MessageFormat.format(url,args);
        log.info("restUrl={}",restUrl);
        String response = HttpUtils.getRequest(restUrl);
        Result result = JSONObject.parseObject(response, Result.class);
        return result;
    }
}
