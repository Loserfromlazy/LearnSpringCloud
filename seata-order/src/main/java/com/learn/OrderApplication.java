package com.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 * com.learn.OrderApplication
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/27
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启Feign客户端功能
@MapperScan("com.learn.mapper")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
