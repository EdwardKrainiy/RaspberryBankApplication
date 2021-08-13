package dao;

import model.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class AccountDAO implements  DAOInterface<Account>{

    @Override
    public Account findById(int id){
        return HibernateSessionFactory.getSessionFactory().openSession().get(Account.class, id);
    }

    @Override
    public List<Account> findAll(){
        return (List<Account>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Account").list();
    }

    @Override
    public void save(Account account) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(account);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Account account){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(account);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Account account){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(account);
        tx1.commit();
        session.close();
    }
}
