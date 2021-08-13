package dao;

import model.Bank;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class BankDAO implements DAOInterface<Bank> {

    @Override
    public Bank findById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Bank.class, id);
    }

    @Override
    public List<Bank> findAll(){
        return (List<Bank>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Bank").list();
    }

    @Override
    public void save(Bank bank) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(bank);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Bank bank){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(bank);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Bank bank){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(bank);
        tx1.commit();
        session.close();
    }
}
