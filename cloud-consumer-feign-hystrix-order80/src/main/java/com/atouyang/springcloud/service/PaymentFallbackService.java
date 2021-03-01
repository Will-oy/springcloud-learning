package com.atouyang.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 服务降级：
 * 客户端接口@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")可让客户端调用到对应服务的所有方法，
 * 那么我们对客户端进行降级时，直接可从接口处入手，无需再controller多做处理。
 * 于是做一个降级类实现原接口,接口处加上fallback
 *
 * 解决：服务机器宕机（根本走不到controller处）
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_Ok(Integer id)
    {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id)
    {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
