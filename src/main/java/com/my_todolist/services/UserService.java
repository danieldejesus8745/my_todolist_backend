package com.my_todolist.services;

import com.my_todolist.entities.User;
import com.my_todolist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService
{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User addUser(User user)
    {
        Optional<User> emailExists = userRepository.findUserByEmail(user.getEmail());
        if (emailExists.isPresent()) {
            throw new IllegalStateException("E-mail já cadastrado");
        }

        return userRepository.save(user);
    }

    public Optional<User> getUser(User user)
    {
        Optional<User> userFound = userRepository.findUserByEmail(user.getEmail());
        if (!userFound.isPresent()) {
            throw new IllegalStateException("E-mail não encontrado");
        }

        return userFound;
    }
}