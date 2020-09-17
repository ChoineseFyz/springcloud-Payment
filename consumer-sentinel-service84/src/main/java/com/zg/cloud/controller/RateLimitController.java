package com.zg.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zg.cloud.myhandler.CustomerBlockException;
import com.zg.cloud.service.PaymentService;
import com.zg.springcloud.entities.CommonResult;
import com.zg.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/9/14 15:47
 */

@RestController
@Slf4j
public class RateLimitController {

    private static final String  PAYMENT_URL ="http://cloudalibaba-sentinel-payment";
    @Resource
    private RestTemplate restTemplate;

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


    @GetMapping(value = "/rateLimit/getPaymentData/{id}")
    @SentinelResource(value = "getPaymentData", fallback = "handlerException",blockHandlerClass = CustomerBlockException.class,
            blockHandler = "handlerException3")
    public CommonResult getPaymentData(@PathVariable("id") Long id){
        CommonResult forObject = restTemplate.getForObject(PAYMENT_URL + "/getId/" + id, CommonResult.class);
        if (id==4){
            throw  new IllegalArgumentException("IllegalArgumentException : 非法参数异常");
        }else if(forObject.getData()==null){
            throw  new NullPointerException("NullPointerException : 该Id 没有对应的记录");
        }
        return forObject;
    }

    public CommonResult handlerException(@PathVariable("id") Long id,Throwable t){
        Payment payment =new Payment(id,null);
        return new CommonResult<>(444," 兜底异常handlerException 异常信息："+t.getMessage(),payment);
    }
    @Resource
    private PaymentService paymentService;
    @GetMapping(value = "/consumer/getId/{id}")
    @SentinelResource(value = "consumerGetId",blockHandlerClass = CustomerBlockException.class,
            blockHandler = "handlerException3")
    public CommonResult getPaymentByData(@PathVariable("id") Long id){
        return paymentService.getPaymentByData(id);
    };
}
