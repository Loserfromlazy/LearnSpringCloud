package com.learn.rpcdemo.client;

import com.alibaba.fastjson.JSONObject;
import com.learn.entity.Result;
import com.learn.rpcdemo.utils.HttpUtils;
import com.learn.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * <p>
 * RpcDemoClientImpl
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/2
 */
@Slf4j
public class RpcDemoClientImpl implements RpcDemoClient{
    final String contextPath = RpcConstant.CONTEXT;

    @Override
    public Result<Boolean> test() {
        String uri = "/test";
        String restUri = contextPath + uri;
        log.info("restUri={}",restUri);
        String request = null;
        try {
            request = HttpUtils.getRequest(restUri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (StringUtils.hasText(request)){
            return JSONObject.parseObject(request, Result.class);
        }else {
            return ResultUtils.resultInit(0,"失败",false);
        }
    }

    @Override
    public Result<String> testPrint(String input) {
        String uri = "/print?input={0}";
        String uriParams = MessageFormat.format(uri, input);
        String restUri = contextPath + uriParams;
        log.info("restUri={}",restUri);
        String request = null;
        try {
            request = HttpUtils.getRequest(restUri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (StringUtils.hasText(request)){
            return JSONObject.parseObject(request, Result.class);
        }else {
            return ResultUtils.resultInit(0,"失败",null);
        }
    }
}
