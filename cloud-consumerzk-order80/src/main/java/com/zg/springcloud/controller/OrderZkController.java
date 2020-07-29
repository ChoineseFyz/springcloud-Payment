package com.zg.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class OrderZkController {

    private  static final String INVOKE_URL="http://cloud-proider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/commons/payment/zk")
    public String getPaymentInfo(){
       return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }
}
