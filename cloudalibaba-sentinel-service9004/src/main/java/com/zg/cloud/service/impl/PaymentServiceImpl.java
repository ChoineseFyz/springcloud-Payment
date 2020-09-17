package com.zg.cloud.service.impl;

import com.zg.cloud.dao.PaymentDao;
import com.zg.cloud.service.PaymentService;
import com.zg.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/9/15 9:37
 */

@Service
public class PaymentServiceImpl  implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public Payment getPaymentInfo(@Param("id") Long id) {
        return paymentDao.getPaymentInfo(id);
    }
}
