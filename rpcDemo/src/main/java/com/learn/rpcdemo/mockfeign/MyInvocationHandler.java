package com.learn.rpcdemo.mockfeign;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * MyInvocationHandler
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/5
 */
public class MyInvocationHandler implements InvocationHandler {

    /**
     * 远程调用的映射，根据方法名称，分发方法处理器
     * key：Feign接口的方法名称；value：方法处理器
     */
    private Map<Method, MyMethodHandler> dispatch;

    public static <T> T newInstance(Class<T> clazz) {
        //获取contextPath
        RestController controllerAnno = clazz.getAnnotation(RestController.class);
        if (controllerAnno == null) {
            return null;
        }
        String contextPath = controllerAnno.value();
        MyInvocationHandler invocationHandler = new MyInvocationHandler();
        invocationHandler.dispatch = new LinkedHashMap<>();
        //遍历获取url
        for (Method method : clazz.getMethods()) {
            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
            if (requestMapping == null) {
                continue;
            }
            String uri = requestMapping.name();
            //缓存MethodHandler
            MyMethodHandler methodHandler = new MyMethodHandlerImpl(contextPath, uri);
            invocationHandler.dispatch.put(method, methodHandler);
        }
        T proxy = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, invocationHandler);
        return proxy;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("equals".equals(method.getName())) {
            Object o = args.length > 0 && args[0] != null ? args[0] : null;
            return equals(o);
        } else if ("hashCode".equals(method.getName())) {
            return hashCode();
        } else if ("toString".equals(method.getName())) {
            return toString();
        }
        //从dispatch映射中取出MyMethodHandler，并进行远程调用
        MyMethodHandler methodHandler = dispatch.get(method);
        return methodHandler.invoke(args);
    }
}
