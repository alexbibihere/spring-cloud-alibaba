package com.ydg.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ydg.excel.UserExcel;
import com.ydg.utils.SM4Util;
import org.apache.poi.ss.usermodel.Workbook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ydg.model.User;
import com.ydg.mapper.TUserMapper;
import com.ydg.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author yandg
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2024-08-30 00:25:01
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<TUserMapper, User>
    implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        return userMapper.selectOneByUsername(username);
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

    @Override
    public List<User> listUser() {
        return userMapper.selectList(null);
    }
//    public List<User> listUserByCondition(User user) {
//        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        if (user.getUsername() != null) {
//            queryWrapper.eq(User::getUsername, user.getUsername());
//        }
//        return userMapper.selectList(queryWrapper);
//    }

    public void exportALlUser(HttpServletResponse response) {
        List<User> userList = userMapper.selectList(null);
        List<UserExcel> userList1 = new ArrayList<>();
        userList.forEach(user -> {
            UserExcel userExcel = new UserExcel();
            BeanUtils.copyProperties(user, userExcel);
            userList1.add(userExcel);
        });
        exportExcel(response, userList1);
    }

    @Override
    public Boolean login(String username, String password) {
        log.info("登录参数：username={}, password={}", username, password);
        User user = userMapper.selectOneByUsername(username);
        if (user == null) {
            log.info("用户名不存在");
            return false;
        }
        if (!user.getPassword().equals(password)) {
            log.info("密码错误");
            return false;
        }
        log.info("登录成功");
        return true;
    }

    @Override
    public boolean register(User user) {
        user.setId(IdUtil.getSnowflakeNextIdStr());
        user.setIsDeleted(0);
        user.setPassword(SM4Util.encrypt(user.getPassword()));
        user.setCreateTime(new Date());
        userMapper.insert(user);
        log.info("注册参数：{}", user);
        return false;
    }

    @Override
    public Object logout() {
        return null;
    }

    private void exportExcel(HttpServletResponse response, List list) {
        try {
            Date date = new Date();
            String strDateFormat = "yyyyMMddHHmmss";
            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
            String dateStr = sdf.format(date);
            String fileName = "推送收集日志";
            /* 设置excel参数 */
            ExportParams params = new ExportParams();
            /* 设置sheet名 */
            params.setSheetName(fileName);
            fileName = fileName + "_" + dateStr + ".xls";
            /* 设置响应输出的头类型及下载文件的默认名称 */
            response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            /* 导出excel */
            Workbook workbook = ExcelExportUtil.exportExcel(params, UserExcel.class, list);
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            log.info("导出推送收集日志异常：{}", e.getMessage());
            e.printStackTrace();
        }
    }
}




