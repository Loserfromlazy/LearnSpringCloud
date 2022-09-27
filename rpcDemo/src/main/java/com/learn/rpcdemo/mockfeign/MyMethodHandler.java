package com.learn.rpcdemo.mockfeign;

/**
 * <p>
 * MyMethodHandler
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/5
 */
public interface MyMethodHandler {

    /**
     * 组装URL，完成REST远程调用，返回JSON结果
     *
     * @param args RPC方法的参数
     * @return REST接口响应
     * @throws Throwable 异常
     */
    Object invoke(Object[] args) throws Throwable;
}
