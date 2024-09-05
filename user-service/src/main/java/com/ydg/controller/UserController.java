package com.ydg.controller;

import com.ydg.model.User;
import com.ydg.service.UserService;
import com.ydg.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yandg
 * @Date: 2024-9-5 17:23:24
 * @Description: 用户相关类
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password){
        return Result.success(userService.login(username, password));
    }

    @GetMapping("/get")
    public Result get(@RequestParam("username")  String username) {
        return Result.success(userService.getUserByUsername( username ));
    }

    @GetMapping("/list")
    public Result list() {
        return Result.success(userService.listUser());
    }

    @PostMapping("/add")
    public Result add(@RequestParam("user") User user) {
        return Result.success(userService.addUser(user));
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id") String id) {
        return Result.success(userService.deleteUser(id));
    }

    @PostMapping("/update")
    public Result update(@RequestParam User user) {
        return Result.success(userService.updateUser(user));
    }


    @GetMapping("/exportAll")
    public void exportAll(HttpServletResponse response) {
         userService.exportALlUser(response);
    }
}
