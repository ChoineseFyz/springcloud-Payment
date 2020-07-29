package com.zg.springcloud.lb;


import com.zg.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/7/17 20:10
 */

@Component
public class MyLb implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current ;
        int next ;
        do {
            current  = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current+1;
        }while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println("当前next :"+ next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
