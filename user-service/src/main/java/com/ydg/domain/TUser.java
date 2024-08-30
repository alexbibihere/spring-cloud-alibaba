package com.ydg.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
public class TUser implements Serializable {
    private String id;

    private String userName;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}