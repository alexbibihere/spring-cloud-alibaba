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

    @PostMapping("/register")
    public Result register(@RequestParam("user") User user) {
        return Result.success(userService.register(user));
    }

    @GetMapping("/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password){
        return Result.success(userService.login(username, password));
    }

    @GetMapping("/logout")
    public Result logout() {
        return Result.success(userService.logout());
        }

    @GetMapping("/getUserInfo")
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

    @RequestMapping("/delete")
    public Result delete(@RequestParam String id) {
        return Result.success(userService.deleteUser(id));
    }

    @RequestMapping("/update")
    public Result update(@RequestParam User user) {
        return Result.success(userService.updateUser(user));
    }


    @RequestMapping("/exportAll")
    public void exportAll(HttpServletResponse response) {
         userService.exportALlUser(response);
    }
}
