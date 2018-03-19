package main.java.com.jkahn.social.dao;

import main.java.com.jkahn.social.objects.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class UserDAOImpl implements UserDAO{
    private final static Logger log = Logger.getLogger(UserDAOImpl.class.getName());
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        log.info("inside method");
        Session currentSession = sessionFactory.getCurrentSession();
        log.info(user.getFirst());
        currentSession.save(user);
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void removeUser(User user) {

    }
}
