package com.atouyang.springcloud.service;

import com.atouyang.springcloud.dao.PaymentDao;
import com.atouyang.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author oyyh
 */
@Service
public class PaymentServiceIml implements PaymentService{


//    @Autowired
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
