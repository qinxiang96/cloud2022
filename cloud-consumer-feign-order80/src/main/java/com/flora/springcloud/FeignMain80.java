package com.flora.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author qinxiang
 * @Date 2022/8/16-下午5:38
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class FeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignMain80.class, args);
    }
}
