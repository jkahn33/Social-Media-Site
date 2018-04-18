package main.java.com.jkahn.social.service;

import main.java.com.jkahn.social.dao.StatusDAO;
import main.java.com.jkahn.social.objects.Status;
import main.java.com.jkahn.social.objects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusDAO statusDAO;

    @Override
    @Transactional
    public void addStatus(Status status) {
        statusDAO.addStatus(status);
    }

    @Override
    @Transactional
    public List<Status> getStatuses(User user) {
        return statusDAO.getStatuses(user);
    }

    @Override
    public List<Status> sortByChrono(List<Status> statuses) {
        return null;
    }
}
