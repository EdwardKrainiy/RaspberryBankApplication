package dao;

import model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class PersonDAO implements DAOInterface<Person> {

    @Override
    public Person findById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Person.class, id);
    }

    @Override
    public List<Person> findAll(){
        List<Person> personList = HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Person ").list();
        return personList;
    }

    @Override
    public void save(Person person) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(person);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Person person){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(person);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Person person){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(person);
        tx1.commit();
        session.close();
    }
}
