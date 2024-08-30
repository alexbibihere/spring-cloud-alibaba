package com.ydg.controller;

import com.ydg.model.User;
import com.ydg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/get")
    public User get(@RequestParam String username) {
        return userService.getUserByUsername( username );
    }


    @RequestMapping("/add")
    public int add(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        return userService.addUser(user);
    }


    @RequestMapping("/delete")
    public int delete(@RequestParam String id) {
        return userService.deleteUser(id);
    }


    @RequestMapping("/update")
    public int update(@RequestParam String id, @RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return userService.updateUser(user);
    }
}
