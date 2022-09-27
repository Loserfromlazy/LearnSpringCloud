package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * AutoDeliverNacosApplication
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/22
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients //开启Feign客户端功能
public class AutoDeliverNacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoDeliverNacosApplication.class,args);
    }

    @Bean
    @LoadBalanced//Ribbon负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
