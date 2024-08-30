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
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private String id;

    private String userName;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public void setUsername(String username) {
        this.userName = username;
    }

}