package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 * AutoDeliverFeign
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/17
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启Feign客户端功能
public class AutoDeliverFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoDeliverFeignApplication.class, args);
    }
}
