package com.zg.cloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zg.springcloud.entities.CommonResult;
import com.zg.springcloud.entities.Payment;

/**
 * @author fyz
 * @version 1.0
 * @date 2020/9/14 16:20
 */
public class CustomerBlockException {

    public static CommonResult handlerException(BlockException b1){
        return new CommonResult(444,"按客户自定义异常信息 1 ······",new Payment(1,"getCommonInfo ：/(ㄒoㄒ)/~~"));
    }

    public static CommonResult handlerException2(BlockException b1){
        return new CommonResult(444,"按客户自定义异常信息 2 ······",new Payment(1,"getCommonInfo ：/(ㄒoㄒ)/~~"));
    }

}
