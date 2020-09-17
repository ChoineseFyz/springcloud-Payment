package com.zg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/9/14 10:24
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SentinelServiceMain84 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceMain84.class,args);
    }

}
