package com.my_todolist.services;

import com.my_todolist.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    public User addUser()
    {
        return new User(1L, "Daniel", "daniel@email.com", "daniel123");
    }

    public String getUser()
    {
        return "Hello form User service";
    }
}