package dao;

import model.Account;
import utils.HibernateSessionFactory;

public class AccountRepository extends EntityRepository<Account> {

    @Override
    public String getTableName() {
        return "Account";
    }

    public Account findByLogin(String login){
        return (Account) HibernateSessionFactory.getSessionFactory().openSession().createQuery("from Account where login =:login ")
                .setParameter("login", login).uniqueResult();
    }
}
