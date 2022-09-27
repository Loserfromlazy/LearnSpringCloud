package com.learn.rpcdemo.client;

import com.learn.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * RpcDemoClient
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/1
 */
@RestController(RpcConstant.CONTEXT)
public interface RpcDemoClient {

    @RequestMapping(name = "/test")
    Result<Boolean> test();

    @RequestMapping(name = "/print?input={0}")
    Result<String> testPrint(String input);
}
