package com.ydg.pointService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
