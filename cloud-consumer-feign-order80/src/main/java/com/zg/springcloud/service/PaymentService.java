package com.zg.springcloud.service;

import com.zg.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/7/20 9:19
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id);
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
