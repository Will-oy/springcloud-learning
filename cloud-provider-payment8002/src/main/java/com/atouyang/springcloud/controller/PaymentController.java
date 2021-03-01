package com.atouyang.springcloud.controller;

import com.atouyang.springcloud.entities.CommonResult;
import com.atouyang.springcloud.entities.Payment;
import com.atouyang.springcloud.service.PaymentService;
import com.atouyang.springcloud.service.PaymentServiceIml;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author oyyh
 *
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentServiceIml paymentServiceIml;


    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentServiceIml.create(payment);
        log.info("插入结果："+result);
        if (result > 0) {
            return new CommonResult(200,"插入数据库成功!serverPort:"+serverPort,result);
        } else {
            return new CommonResult(444,"插入数据库失败！",null);
        }

    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentId(@PathVariable("id") Long id) {
        Payment payment = paymentServiceIml.getPaymentById(id);
        log.info("查询结果："+payment);
        if (payment != null) {
            return new CommonResult(200,"查询成功!serverPort:"+serverPort,payment);
        } else {
            return new CommonResult(444,"查询失败！",null);
        }

    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}