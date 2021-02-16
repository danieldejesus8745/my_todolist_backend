package com.my_todolist.controllers;

import com.my_todolist.entities.User;
import com.my_todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("create")
    public User addUser()
    {
        return userService.addUser();
    }

    @GetMapping("read")
    public String getUser()
    {
        return userService.getUser();
    }
}