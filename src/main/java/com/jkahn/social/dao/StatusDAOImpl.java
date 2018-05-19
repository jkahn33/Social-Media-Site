package main.java.com.jkahn.social.dao;

import main.java.com.jkahn.social.objects.Status;
import main.java.com.jkahn.social.objects.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class StatusDAOImpl implements StatusDAO {
    private final static Logger log = Logger.getLogger(UserDAOImpl.class.getName());
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addStatus(Status status) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(status);

    }

    @Override
    public List<Status> getStatuses(User user) {
        int creator_id = user.getId();
        log.info("ID: " + creator_id);
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Status> theQuery = currentSession.createQuery("from Status where creatorId = " + creator_id);
        List<Status> statuses = theQuery.getResultList();
        return statuses;
    }

    @Override
    public void updateUser(Status status) {

    }

    @Override
    public void addFriend(User friend){

    }

    @Override
    public void removeUser(Status status) {

    }
}
