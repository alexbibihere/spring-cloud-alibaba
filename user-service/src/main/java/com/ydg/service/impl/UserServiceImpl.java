package com.ydg.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ydg.excel.UserExcel;
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

    @Override
    public List<User> listUser() {
        List<User> userList = userMapper.selectList(null);
       return userList;
    }

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




