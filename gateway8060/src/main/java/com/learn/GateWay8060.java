package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * GateWay8060
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/21
 */
@SpringBootApplication
@EnableDiscoveryClient  //开启注册中心客户端（通用型注解，比如注册到Eureka、
public class GateWay8060 {
    public static void main(String[] args) {
        SpringApplication.run(GateWay8060.class,args);
    }
}
