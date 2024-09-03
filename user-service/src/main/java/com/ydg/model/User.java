package com.ydg.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
public class User implements Serializable {

    private String id;

    private String userName;

    private String password;

    private String email;

    private String phone;

    private Integer status;

    private Date createTime;

    private static final long serialVersionUID = 1L;


}