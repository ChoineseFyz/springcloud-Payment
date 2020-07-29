package com.zg.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    public static final String INVODE_URL="http://cloud-providerconsul-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/commons/payment/consul")
    public String getPaymentConsul(){
        return restTemplate.getForObject(INVODE_URL+"/payment/consul",String.class);
    }
}
