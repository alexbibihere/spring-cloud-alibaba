package com.ydg.orderService.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.ydg.commonmodule.entity.Order;

@FeignClient(value = "point-service")
public interface PointServiceFeignClient {

    @PostMapping(value = "/point/add")
    String addPoint(@RequestBody Order order);

    @PostMapping(value = "/point/add2")
    String addProductName(@RequestParam("productionName") String productionName);
}
