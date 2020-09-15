package com.zg.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zg.cloud.myhandler.CustomerBlockException;
import com.zg.springcloud.entities.CommonResult;
import com.zg.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/9/14 15:47
 */

@RestController
@Slf4j
public class RateLimitController {

    @GetMapping(value = "/getCommonInfo")
    @SentinelResource(value = "getCommonInfo" ,blockHandler = "heal_getCommonInfo")
    public CommonResult getCommonInfo(){
        return new CommonResult(200,"按资源名称限流：访问成功",new Payment(1,"getCommonInfo ：(*^_^*)"));
    }

    public CommonResult heal_getCommonInfo(BlockException b1){
        return new CommonResult(444,"按资源名称限流：访问失败",new Payment(1,"getCommonInfo ：/(ㄒoㄒ)/~~  服务不可用"));
    }

    @GetMapping(value = "/getRateLimit/asUrl")
    @SentinelResource(value = "asUrl")
    public CommonResult getRateLimit(){
        return new CommonResult(444,"按url限流：访问成功",new Payment(1,"getCommonInfo ：(*^_^*)"));
    }


    @GetMapping(value = "/getRateLimit/asHandlerException")
    @SentinelResource(value = "asHandlerException" ,
            blockHandlerClass = CustomerBlockException.class,
            blockHandler = "handlerException")
    public CommonResult asHandlerException(){
        return new CommonResult(200,"按客户自定义请求：成功",new Payment(1,"getCommonInfo ：(*^_^*)"));
    }

}
