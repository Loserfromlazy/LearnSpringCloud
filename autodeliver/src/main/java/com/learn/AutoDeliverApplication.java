package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * AutoDeliverApplicatin
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/8
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
//@EnableHystrix  //开启Hystrix功能
@EnableCircuitBreaker //开启熔断器功能
//@SpringCloudApplication //等价于@SpringBootApplication + @EnableDiscoveryClient + @EnableCircuitBreaker
public class AutoDeliverApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoDeliverApplication.class, args);
    }

    @Bean
    @LoadBalanced//Ribbon负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
