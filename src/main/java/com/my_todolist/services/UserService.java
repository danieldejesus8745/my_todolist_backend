package com.my_todolist.services;

import org.springframework.stereotype.Service;

@Service
public class UserService
{
    public String getUser()
    {
        return "Hello form User service";
    }
}