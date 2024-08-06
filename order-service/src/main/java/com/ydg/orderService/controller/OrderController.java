package com.ydg.orderService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yandg
 * @Date 2024/08/06 0006 22:20
 * @Description
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @GetMapping(value = "/test")
    public  String test(){
        return  "this is order-service";
    }
}
