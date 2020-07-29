package com.zg.springcloud.controller;


import com.zg.springcloud.entities.CommonResult;
import com.zg.springcloud.entities.Payment;
import com.zg.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;


@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value="/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("插入成功");
        if (result>0){
            return  new CommonResult(200,"插入成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(300,"插入失败,serverPort:"+serverPort,null);
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id){
        Payment Payment = paymentService.getPaymentById(id);
        log.info("查询成功");
        if (null!=Payment){
            return  new CommonResult(200,"查询成功,serverPort:"+serverPort,Payment);
        }else {
            return new CommonResult(300,"没有查询到对应结果集,对应ID:"+id+"serverPort:"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/getDiscovery")
    public Object getDiscoveryClient(){
        List<String> services = discoveryClient.getServices();
        for (String ser : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(ser);
            for (ServiceInstance ins : instances) {
                log.info(ins.getServiceId()+"\t"+ins.getHost()+"\t"+ins.getPort()+"\t"+ins.getUri());
            }
        }
        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String GetPaymentLB(){
        return serverPort;
    }


}
