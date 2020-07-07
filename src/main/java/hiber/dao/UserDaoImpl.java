package hiber.dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction;

        transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public User removeUserById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction;

        transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        if (user != null){
        session.delete(user);
        transaction.commit();
        session.close();
        return user;
        } else return null;
    }

    @Override
    public User getUser(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction;

        transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public void updateUser(User user){
        Session session = sessionFactory.openSession();
        Transaction transaction;

        transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        Session session = sessionFactory.openSession();
        return  session.createQuery("from User").list();
    }
}
