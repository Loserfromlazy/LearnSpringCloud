package com.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * UserApplication8093
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/22
 */
@SpringBootApplication
@MapperScan("com.learn.com.learn.mapper")
@EnableDiscoveryClient  //开启注册中心客户端（通用型注解，比如注册到Eureka、Nacos
public class UserApplication8093 {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication8093.class, args);
    }
}
