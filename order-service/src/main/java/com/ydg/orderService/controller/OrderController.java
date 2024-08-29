package com.ydg.orderService.controller;

import com.ydg.orderService.feignClient.PointServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ydg.commonmodule.entity.Order;

/**
 * @Author yandg
 * @Date 2024/08/06 0006 22:20
 * @Description
 */
@RestController
@RequestMapping(value = "/order")
@RefreshScope
public class OrderController {

    @Autowired
    private PointServiceFeignClient pointServiceFeignClient;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/test")
    public  String test(){
        return  "this is order-service";
    }

    @GetMapping(value = "/test/getConfigInfo")
    public  String getConfigInfo(){
        return configInfo;
    }

    @PostMapping(value = "/add")
    public String addOrder(){
        Order order = new Order();
        order.setId("123");
        order.setProductionName("iphone14");
        return pointServiceFeignClient.addPoint(order);
    }

    @PostMapping(value = "/add2")
    public String addProductName(){
        return pointServiceFeignClient.addProductName("iphone14");
    }
}
