package com.ydg.excel;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author : yandg
 * @Date 2024/9/3 星期二
 */
@Data
public class UserExcel {

    private String userName;

    private String password;

    private String email;

    private String phone;

    private Integer status;

    private String createTime;

}
