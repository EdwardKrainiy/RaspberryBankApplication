package dao;

import model.BaseEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public abstract class EntityRepository<TEntity extends BaseEntity> implements IRepository<TEntity> {

    @Override
    public TEntity findById(int id) {
        return (TEntity) HibernateSessionFactory.getSessionFactory().openSession().createQuery("from " + getTableName() + " WHERE id = " + id).uniqueResult();
    }

    @Override
    public List<TEntity> findAll(){
        return (List<TEntity>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("from " + getTableName()).list();
    }

    @Override
    public int create(TEntity entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        int entityId = (int) session.save(entity);
        tx1.commit();
        session.close();
        return entityId;
    }

    @Override
    public TEntity update(TEntity entity){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(entity);
        tx1.commit();
        session.close();
        return entity;
    }

    @Override
    public void delete(TEntity entity){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(entity);
        tx1.commit();
        session.close();
    }

    public abstract String getTableName();
}


