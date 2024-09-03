package com.ydg.util;

import lombok.Data;

/**
 * @Description:  通用请求返回结果类
 * @Author : yandg
 * @Date 2024/8/30 星期五
 */
@Data
public class Result {
    private int code;
    private String message;
    private Object data;

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success(Object data) {
        return new Result(200, "success", data);
    }

    public static Result error(int code, String message) {
        return new Result(code, message, null);
    }
}
