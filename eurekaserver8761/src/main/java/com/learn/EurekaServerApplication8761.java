package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>
 * EurekaServerApplication
 * </p>
 *
 * @author Yuhaoran
 * @since 2021/12/8
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication8761 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication8761.class,args);
    }
}
