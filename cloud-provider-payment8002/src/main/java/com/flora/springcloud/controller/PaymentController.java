package com.flora.springcloud.controller;

import com.flora.springcloud.entities.CommonResult;
import com.flora.springcloud.entities.Payment;
import com.flora.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author qinxiang
 * @Date 2022/8/12-下午4:48
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果:" +result);
        if(result > 0){
            return new CommonResult(
                    200,"插入数据库成功,serverPort"+serverPort,result
            );
        }else{
            return new CommonResult(444, "插入数据库失败", null);
        }

    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("获得结果:" +payment);
        if(payment != null){
            return new CommonResult(
                    200,"查询成功,serverPort"+serverPort,payment
            );
        }else{
            return new CommonResult(444, "查询失败，没有对应的记录，ID："+ id, null);
        }

    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
