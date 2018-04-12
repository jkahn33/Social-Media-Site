package main.java.com.jkahn.social.service;

import main.java.com.jkahn.social.objects.Status;
import main.java.com.jkahn.social.objects.User;

import java.util.List;

public interface StatusService {
    public void addStatus(Status status);
    public List<Status> getStatuses(User user);
    public List<Status> sortByChrono(List<Status> statuses);
}
