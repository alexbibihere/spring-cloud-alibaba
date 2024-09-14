package com.ydg.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ydg.model.User;

import java.util.List;

/**
* @author yandg
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2024-08-30 00:25:01
* @Entity generator.domain.TUser
*/
public interface TUserMapper extends BaseMapper<User> {

    User selectOneByUsername(String username);

}




