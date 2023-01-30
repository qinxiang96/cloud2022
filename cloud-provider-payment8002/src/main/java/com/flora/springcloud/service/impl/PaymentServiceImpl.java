package com.flora.springcloud.service.impl;

import com.flora.springcloud.dao.PaymentDao;
import com.flora.springcloud.entities.Payment;
import com.flora.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author qinxiang
 * @Date 2022/8/12-下午4:35
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
