package com.atouyang.springcloud.service;

import com.atouyang.springcloud.entities.CommonResult;
import com.atouyang.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * OpenFeign 写接口+注释
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    //此处接口定义要与服务提供者的定义路径一致, 主要原因是Spring 4.0版本后，@RequestParam 注解对参数传值有了很好的封装特性并严格校验。
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();

}
