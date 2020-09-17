package com.zg.cloud.service;

import com.zg.springcloud.entities.CommonResult;
import com.zg.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/9/15 20:07
 */
@Component
public class PaymentFallbackService  implements PaymentService{
    @Override
    public CommonResult getPaymentByData(Long id) {
        return new  CommonResult(444,"失败", Payment.class);
    }
}
