package com.my_todolist.services;

import com.my_todolist.entities.User;
import com.my_todolist.repositories.UserRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
            throw new IllegalStateException("email-already-exists");
        }

        Argon2 argon2 = Argon2Factory.create();
        char[] password = user.getPassword().toCharArray();
        String hash = argon2.hash(10, 1024, 1, password);
        user.setPassword(hash);

        return userRepository.save(user);
    }

    public Optional<User> getUser(User user)
    {
        Optional<User> userFound = userRepository.findUserByEmail(user.getEmail());
        if (!userFound.isPresent()) {
            throw new IllegalStateException("email-error");
        }

        Argon2 argon2 = Argon2Factory.create();
        char[] password = user.getPassword().toCharArray();
        if (!argon2.verify(userFound.get().getPassword(), password)) {
            throw new IllegalStateException("password-error");
        }

        return userFound;
    }

    public User updateUser(User user)
    {
        return userRepository.save(user);
    }
}