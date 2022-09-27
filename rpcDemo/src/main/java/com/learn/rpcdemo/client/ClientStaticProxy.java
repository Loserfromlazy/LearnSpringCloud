package com.learn.rpcdemo.client;

import com.learn.entity.Result;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ClientStaticProxy
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/2
 */
@Slf4j
@AllArgsConstructor
public class ClientStaticProxy implements RpcDemoClient{
    private RpcDemoClient rpcDemoClient;

    @Override
    public Result<Boolean> test() {
        log.info("静态代理，test方法执行");
        return rpcDemoClient.test();
    }

    @Override
    public Result<String> testPrint(String input) {
        log.info("静态代理，print方法执行");
        return rpcDemoClient.testPrint(input);
    }
}
