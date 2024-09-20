package com.ydg.utils;

import cn.hutool.core.util.IdUtil;

/**
 * @Description: 雪花算法工具类
 * @Author : yandg
 * @Date 2024/9/18 星期三
 */
public class SnowflakeUtil {
    private static SnowflakeUtil instance = new SnowflakeUtil();

    public static SnowflakeUtil getInstance() {
        return instance;
    }

    public long nextId() {
        return IdUtil.getSnowflake(6, 8).nextId();
    }
}
