package main.java.com.jkahn.social.dao;

import main.java.com.jkahn.social.objects.Status;
import main.java.com.jkahn.social.objects.User;

import java.util.List;

public interface StatusDAO {
    public void addStatus(Status status);
    public List<Status> getStatuses(User user);
    public void updateUser(Status status);
    public void removeUser(Status status);
}
