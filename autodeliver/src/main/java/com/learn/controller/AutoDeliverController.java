package com.learn.controller;

import com.learn.pojo.UserInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * <p>
 * AutoDeliverController
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/8
 */
@RestController
@RequestMapping("/autoDeliver")
public class AutoDeliverController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;


    @HystrixCommand(
            threadPoolKey = "findOpenStatusByUid",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize",value = "2"),// 线程数
                    @HystrixProperty(name="maxQueueSize",value="20") // 等待队列长度
            },
            commandProperties = {
                    //@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
                    //配置一个8s内请求次数达到2个失败率达到50%就跳闸的熔断器，跳闸后的活动窗口设置为3s
//                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "8000"),
//                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "2"),
//                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
//                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000")
            },
            fallbackMethod = "myFallBack"
    )
    @GetMapping("/findOpenStatusByUid")
    public Integer findOpenStatusByUid(@RequestParam("uid") Integer uid){
        String url = "http://user/user/findUserById?id="+uid;
        System.out.println("############URL##########:"+url);
        UserInfo forObject = restTemplate.getForObject(url, UserInfo.class);
        return forObject.getOpen();
    }

    @HystrixCommand(
            // 线程池标识，要保持唯一，不唯一的话就共用了
            threadPoolKey = "findOpenStatusByUid1",
            // 线程池细节属性配置
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize",value = "2"),// 线程数
                    @HystrixProperty(name="maxQueueSize",value="20") // 等待队列长度
            },
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
            },
            fallbackMethod = "myFallBack"
    )
    @GetMapping("/findOpenStatusByUid1")
    public Integer findOpenStatusByUid1(@RequestParam("uid") Integer uid){
        String url = "http://user/user/findUserById?id="+uid;
        System.out.println("############URL##########:"+url);
        UserInfo forObject = restTemplate.getForObject(url, UserInfo.class);
        return forObject.getOpen();
    }
    //回退方法，返回默认值
    public Integer myFallBack(Integer uid){
        return -1;//默认数据\兜底数据
    }
}
