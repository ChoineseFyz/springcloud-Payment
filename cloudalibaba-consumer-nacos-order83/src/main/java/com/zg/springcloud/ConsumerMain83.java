package com.zg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/8/18 18:48
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerMain83 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain83.class,args);
    }

}
