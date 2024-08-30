package com.ydg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ydg.model.User;
import com.ydg.mapper.TUserMapper;
import com.ydg.service.UserService;

/**
* @author yandg
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2024-08-30 00:25:01
*/
@Service
public class UserServiceImpl extends ServiceImpl<TUserMapper, User>
    implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, username);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteUser(String id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }


}




