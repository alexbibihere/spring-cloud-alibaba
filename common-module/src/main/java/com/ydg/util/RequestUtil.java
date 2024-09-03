package com.ydg.util;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson.JSONObject;
import com.ydg.exception.ServiceException;
import org.hibernate.validator.HibernateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author : yandg
 * @Date 2024/8/30 星期五
 */
public class RequestUtil {

    private static final Logger log = LoggerFactory.getLogger(RequestUtil.class);

    private static final Validator VALIDATOR = Validation.byProvider(HibernateValidator.class)
            .configure()
            .failFast(true).buildValidatorFactory().getValidator();

    private static final String USERID = "userId";
    private static final String CREATE_USER_ID = "createUserId";

    /**
     * 获取requestBody参数
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T getBodyParam(HttpServletRequest request, Class<T> t) {
        T object = null;
        try {
            String body = ((RequestWrapper) request).getBodyString();
            object = JSONObject.parseObject(body, t);
            String clientType = request.getHeader("Client-Type");
            if("API".equals(clientType) && object!=null){
                String token = request.getHeader("Authorization");
                JWT jwt = JWTUtil.parseToken(token);
                if(jwt !=null){
                    Object userId = jwt.getPayload(USERID);
                    if(ReflectUtil.hasField(object.getClass(),USERID)){
                        ReflectUtil.setFieldValue(object, USERID, userId);
                    }
                    if(ReflectUtil.hasField(object.getClass(),CREATE_USER_ID)){
                        ReflectUtil.setFieldValue(object, CREATE_USER_ID, userId);
                    }
                }
            }
        } catch (Exception e) {
            log.error("获取request参数错误", e);
            throw new ServiceException("获取request参数错误");
        }
        return object;
    }


    /**
     * @description: //非法字符的判断
     * @author: Administrator
     * @date: 2023/3/28 14:54
     * @param: null
     * @return: null
     **/
    /**
     * 获取requestBody参数
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<T> getBodyParams(HttpServletRequest request, Class<T> t) {
        List<T> object = null;
        try {
            String body = ((RequestWrapper) request).getBodyString();
            object = JSONObject.parseArray(body, t);
        } catch (Exception e) {
            log.error("获取request参数错误", e);
            throw new ServiceException("获取request参数错误");
        }
        return object;
    }
    /**
     * 获取requestBody参数+参数校验
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T getValidBodyParam(HttpServletRequest request, Class<T> t) {
        T object = getBodyParam(request, t);
        if (object == null) {
            throw new ServiceException("参数为空");
        }
        Set<ConstraintViolation<T>> constraintViolations = VALIDATOR.validate(object);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
        return object;
    }
    /**
     * 获取requestBody参数+参数校验
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<T> getValidBodyParams(HttpServletRequest request, Class<T> t) {
        List<T> object = getBodyParams(request, t);
        if (object == null) {
            throw new ServiceException("参数为空");
        }
        object.forEach(item->{
            Set<ConstraintViolation<T>> constraintViolations = VALIDATOR.validate(item);
            if (!constraintViolations.isEmpty()) {
                throw new ConstraintViolationException(constraintViolations);
            }
        });
        return object;
    }


}
