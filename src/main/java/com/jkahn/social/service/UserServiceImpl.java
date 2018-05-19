package main.java.com.jkahn.social.service;

import main.java.com.jkahn.social.dao.UserDAO;
import main.java.com.jkahn.social.objects.User;
import org.hibernate.SessionFactory;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addUser(User user){
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public List<User> getUserByEmail(String email) {
        List<User> result = userDAO.getUserByEmail(email);

        return result;
    }

    @Override
    @Transactional
    public void addFriend(User friend){

    }
}
