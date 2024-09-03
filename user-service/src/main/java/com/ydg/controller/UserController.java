package com.ydg.controller;

import com.ydg.model.User;
import com.ydg.service.UserService;
import com.ydg.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/get")
    public Result get(@RequestParam String username) {
        return Result.success(userService.getUserByUsername( username ));
    }

    @RequestMapping("/list")
    public Result list() {
        return Result.success(userService.listUser());
    }

    @RequestMapping("/add")
    public Result add(@RequestParam User user) {
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
