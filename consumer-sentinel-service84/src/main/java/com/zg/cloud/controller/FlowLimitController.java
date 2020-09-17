package com.zg.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;


/**
 * @author fyz
 * @version 1.0
 * @date 2020/9/14 10:26
 */

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String restA() {
        // try { Thread.sleep(800); }catch (Exception e){ System.out.println(e.getMessage()); }
        return "testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "/n");
        return "testB";
    }


    @GetMapping(value = "/testD")
    public String testD() throws Exception {
//        TimeUnit.SECONDS.sleep(1);
//        log.info("testD");
        //log.info("testD  异常比例");
        // int i = 10/0;
        return "testD";
    }

    @GetMapping(value = "/testE")
    public String testE() throws Exception {
//        TimeUnit.SECONDS.sleep(1);
//        log.info("testD");
        //log.info("testE  异常数");
        // int i = 10/0;
        return "testE";
    }

    @GetMapping(value = "/getHotKey")
    @SentinelResource(value = "getHotKey", blockHandler = "deal_getHotKey")
    public String getHotKey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2) {
        return "sentinel HotKey (*^_^*)";
    }

    public String deal_getHotKey(String p1, String p2, BlockException e) {
        return "sentinel HotKey /(ㄒoㄒ)/~~ 异常";
    }

}
