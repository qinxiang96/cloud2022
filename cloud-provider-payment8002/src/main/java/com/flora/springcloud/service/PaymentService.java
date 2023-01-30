package com.flora.springcloud.service;

import com.flora.springcloud.entities.Payment;

/**
 * @Author qinxiang
 * @Date 2022/8/12-下午4:36
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
