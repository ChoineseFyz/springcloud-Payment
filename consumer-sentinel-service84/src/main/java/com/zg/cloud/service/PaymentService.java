package com.zg.cloud.service;

import com.zg.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/9/15 20:02
 */

@FeignClient(value = "cloudalibaba-sentinel-payment",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/getId/{id}")
    public CommonResult getPaymentByData(@PathVariable("id") Long id);
}
