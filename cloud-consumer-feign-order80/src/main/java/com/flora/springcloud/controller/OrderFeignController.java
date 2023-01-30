package com.flora.springcloud.controller;

import com.flora.springcloud.entities.CommonResult;
import com.flora.springcloud.entities.Payment;
import com.flora.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author qinxiang
 * @Date 2022/8/16-下午5:53
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }
//    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
//        String result = paymentHystrixService
//    }
}
