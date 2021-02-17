package com.my_todolist.security;

public interface Argon2
{
    String hash(int iterations, int memory, int parallelism, char[] password);
}