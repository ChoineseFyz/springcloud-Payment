package com.zg.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/7/20 17:37
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fallback-paymentInfo_OK,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "PaymentFallbackService fallback-paymentInfo_Timeout,/(ㄒoㄒ)/~~";
    }
}
