package com.atouyang.springcloud.service;

import com.atouyang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author oyyh
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
