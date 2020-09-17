package com.zg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/9/15 9:02
 */

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelPaymentMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelPaymentMain9003.class,args);
    }
}
