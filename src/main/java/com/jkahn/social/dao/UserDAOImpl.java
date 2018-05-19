package main.java.com.jkahn.social.dao;

import main.java.com.jkahn.social.objects.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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
    public List<User> getUserByEmail(String email) {
        //create the entity manager from the session factory
        EntityManager em = sessionFactory.createEntityManager();
        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(User.class).get();
        org.apache.lucene.search.Query luceneQuery = qb.keyword().onFields("email").matching(email).createQuery();
        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, User.class);

        List result = jpaQuery.getResultList();

        return result;
    }

    @Override
    public void addFriend(int currentId, int friendId) {
        Session currentSession = sessionFactory.getCurrentSession();
        User currentUser = currentSession.get(User.class, currentId);
        User userToFriend = currentSession.get(User.class, friendId);

        currentUser.addFriend(userToFriend);

    }

    @Override
    public void removeUser(User user) {

    }
}
