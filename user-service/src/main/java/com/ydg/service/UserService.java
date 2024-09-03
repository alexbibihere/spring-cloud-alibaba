package com.ydg.service;


import com.baomidou.mybatisplus.service.IService;
import com.ydg.model.User;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
* @author yandg
* @description 针对表【t_user】的数据库操作Service
* @createDate 2024-08-30 00:25:01
*/
public interface UserService extends IService<User> {

    User getUserByUsername(String username);

    int addUser(User user);

    int deleteUser(String id);

    int updateUser(User user);

    List<User> listUser();

    void exportALlUser(HttpServletResponse response);
}
