package main.java.com.jkahn.social.dao;

import main.java.com.jkahn.social.objects.User;

import java.util.List;

public interface UserDAO{
    public void addUser(User user);
    public List<User> getUsers();
    public User getUser();
    public void updateUser(User user);
    public void removeUser(User user);
}
