package com.zg.cloud.dao;

import com.zg.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/9/15 9:27
 */

@Mapper
public interface PaymentDao {

    public Payment getPaymentInfo(@Param("id") Long id);

}
