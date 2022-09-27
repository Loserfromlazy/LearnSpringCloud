package com.learn.rpcdemo;

import com.learn.entity.Result;
import com.learn.rpcdemo.client.ClientStaticProxy;
import com.learn.rpcdemo.client.RpcDemoClient;
import com.learn.rpcdemo.client.RpcDemoClientImpl;
import com.learn.rpcdemo.mockfeign.MyInvocationHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SpringBootTest
class RpcDemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void testRpcDemoClient(){
        RpcDemoClient client = new RpcDemoClientImpl();
        Result<Boolean> test = client.test();
        System.out.println(test);
        Result<String> stringResult = client.testPrint("123456");
        System.out.println(stringResult);
    }

    @Test
    void testRpcStaticClientProxy(){
        RpcDemoClient client = new RpcDemoClientImpl();
        ClientStaticProxy proxy = new ClientStaticProxy(client);
        Result<Boolean> test = proxy.test();
        System.out.println(test);
        Result<String> stringResult = proxy.testPrint("123456");
        System.out.println(stringResult);
    }

    @Test
    public void testDynamicClientProxy(){
        RpcDemoClient client = new RpcDemoClientImpl();
        RpcDemoClient proxyClient = (RpcDemoClient) Proxy.newProxyInstance(RpcDemoApplicationTests.class.getClassLoader(), new Class[]{RpcDemoClient.class}, (proxy, method, args) -> {
            System.out.println("动态代理，代理方法执行");
            return method.invoke(client, args);
        });
        Result<Boolean> test = proxyClient.test();
        System.out.println(test);
        Result<String> stringResult = proxyClient.testPrint("1234567");
        System.out.println(stringResult);
    }

    @Test
    public void testMyFeignImpl(){
        RpcDemoClient client = MyInvocationHandler.newInstance(RpcDemoClient.class);
        Result<Boolean> test = client.test();
        System.out.println(test);
        Result<String> stringResult = client.testPrint("123456");
        System.out.println(stringResult);
    }

}
