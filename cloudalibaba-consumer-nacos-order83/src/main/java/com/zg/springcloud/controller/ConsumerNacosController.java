package com.zg.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.OptionalDouble;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/8/18 18:49
 */

@RestController
@Slf4j
public class ConsumerNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPort;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping(value = "/consumer/nacos/{id}")
    public String getServerPort(@PathVariable("id") Integer id){
        return "nacos serverPort "+serverPort+"\t id:"+id;
    }

    @GetMapping(value = "/consumer/paument/nacos/{id}")
    public  String getPaymentInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(serverUrl+"/payment/nacos/"+ id,String.class);
    }

}
