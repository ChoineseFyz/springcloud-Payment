package com.zg.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/8/18 18:25
 */


@RestController
@RefreshScope //这个注解是支持nacos的动态刷新
public class NacosPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getServerPort(@PathVariable("id") Integer id){
        return "nacos serverPort "+serverPort+"\t id:"+id;
    }

    @GetMapping(value = "/config/info")
    public  String getConfigInfo(){
        return configInfo;
    }

}
