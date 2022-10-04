package com.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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
@SpringBootApplication(scanBasePackages = "com.learn")
@EnableDiscoveryClient
@EnableFeignClients //开启Feign客户端功能
@MapperScan("com.learn.mapper")
public class WarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseApplication.class,args);
    }
}
