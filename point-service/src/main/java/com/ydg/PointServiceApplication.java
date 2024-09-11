package com.ydg;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author yandg
 * @Date 2024/08/06 0006 22:36
 * @Description
 */
@SpringBootApplication
//@Mapper("com.ydg.mapper")
public class PointServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PointServiceApplication.class, args);
    }
}
