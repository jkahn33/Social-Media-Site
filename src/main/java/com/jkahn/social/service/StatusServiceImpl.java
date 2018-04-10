package main.java.com.jkahn.social.service;

import main.java.com.jkahn.social.dao.StatusDAO;
import main.java.com.jkahn.social.objects.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusDAO statusDAO;

    @Override
    @Transactional
    public void addStatus(Status status) {
        statusDAO.addStatus(status);
    }
}
