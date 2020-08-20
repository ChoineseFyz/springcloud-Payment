package com.zg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/8/18 18:15
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConfigMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConfigMain3377.class,args);
    }
}
