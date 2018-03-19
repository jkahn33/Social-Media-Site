package main.java.com.jkahn.social.service;

import main.java.com.jkahn.social.dao.UserDAO;
import main.java.com.jkahn.social.objects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional
    public void addUser(User user){
        userDAO.addUser(user);
    }
}
