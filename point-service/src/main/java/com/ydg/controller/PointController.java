package com.ydg.controller;

import com.ydg.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ydg.entity.Order;

/**
 * @Author yandg
 * @Date 2024/08/06 0006 22:36
 * @Description
 */
@RestController
@RequestMapping(value = "/point")
public class PointController {


    @GetMapping(value = "/test")
    public String test() {
        return "point test";
    }

    @PostMapping(value = "/add")
    public String addPoint(@RequestBody Order order){
        return "add point success! 商品名称222：" + order.getProductionName();
    }



    @PostMapping(value = "/add2")
    public String addProductName(@RequestParam("productionName") String productionName){
        return "add production name success" + productionName;
    }
}
