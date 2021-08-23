package dao;

import model.AccountInfo;
import utils.HibernateSessionFactory;

public class AccountInfoRepository extends EntityRepository<AccountInfo> {
    @Override
    public String getTableName() {
        return "Accountinfo";
    }

    public AccountInfo findAccountInfoById(int accountId){
        return (AccountInfo) HibernateSessionFactory.getSessionFactory().openSession().createQuery("from AccountInfo where accountId =: accountId ")
                .setParameter("accountId", accountId).uniqueResult();
    }
}