package com.zg.cloud.service;

import com.zg.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/9/15 9:34
 */

public interface PaymentService {
    public Payment getPaymentInfo(@Param("id") Long id);
}
