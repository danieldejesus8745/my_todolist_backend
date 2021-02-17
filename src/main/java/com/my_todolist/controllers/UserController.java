package com.my_todolist.controllers;

import com.my_todolist.entities.User;
import com.my_todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("create")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @PostMapping("read")
    public Optional<User> getUser(@RequestBody User user)
    {
        return userService.getUser(user);
    }

    @PutMapping("update")
    public User updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }
}