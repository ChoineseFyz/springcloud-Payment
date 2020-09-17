package com.zg.cloud.controller;

import com.zg.cloud.service.PaymentService;
import com.zg.springcloud.entities.CommonResult;
import com.zg.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/9/15 9:04
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/getId/{id}")
    public CommonResult getPaymentData(@PathVariable("id") Long id){
        Payment paymentInfo = paymentService.getPaymentInfo(id);
        return new CommonResult(200,"请求成功 端口号为："+serverPort,paymentInfo);
    }

}
