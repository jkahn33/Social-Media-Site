package main.java.com.jkahn.social.service;

import main.java.com.jkahn.social.objects.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public User getUserByEmail(String email);
}
