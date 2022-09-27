package com.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 * UserApllication8090
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/14
 */
@SpringBootApplication
@MapperScan("com.learn.com.learn.mapper")
@EnableDiscoveryClient  //开启注册中心客户端（通用型注解，比如注册到Eureka、
public class UserApllication8091 {

    public static void main(String[] args) {
        SpringApplication.run(UserApllication8091.class,args);
    }
}
