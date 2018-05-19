package main.java.com.jkahn.social.service;

import main.java.com.jkahn.social.objects.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public List<User> getUserByEmail(String email);
    public User getUserById(int id);
    public void addFriend(User current, User friend);
}
