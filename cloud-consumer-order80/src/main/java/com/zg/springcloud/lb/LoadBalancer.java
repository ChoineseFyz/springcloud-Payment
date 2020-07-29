package com.zg.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/7/17 20:07
 */

public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
