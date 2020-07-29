package com.zg.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import sun.awt.SunHints;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/** 
 * @author fyz
 * @version 1.0
 * @date 2020/7/20 11:21
 */

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池 ："+Thread.currentThread().getName()+"paymentInfo_OK,id:+"+id+"\t"+"哈哈";
    }

    //服务降级  这里设置三秒钟响应超过三秒调用paymentInfo_TimeoutHandler这个方法完成兜底  当前峰值为3
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value ="5000")
    })
    public String paymentInfo_Timeout(Integer id){
        return "线程池 ："+Thread.currentThread().getName()+"paymentInfo_Timeout,id:"+id+"\t"+"哈哈`";
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池 ："+Thread.currentThread().getName()+"paymentInfo_Timeout,id:+"+id+"\t"+"系统繁忙请稍后再试/(ㄒoㄒ)/~~";
    }


    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value ="true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),//时间范围
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60") //失败频率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if (id<0){
            throw new RuntimeException("*********参数不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return "线程池 ："+Thread.currentThread().getName()+"调用成功····O(∩_∩)O：流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id不能为负数，请稍后再试······/(ㄒoㄒ)/~~";
    }
}
