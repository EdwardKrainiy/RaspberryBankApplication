package dao;

import model.Card;
import utils.HibernateSessionFactory;

public class CardRepository extends EntityRepository<Card> {

    @Override
    public String getTableName() {
        return "Card";
    }

    public Card findByAccountId(int accountId){
        return (Card) HibernateSessionFactory.getSessionFactory().openSession().createQuery("from Card where accountId =: accountId ")
                .setParameter("accountId", accountId).uniqueResult();
    }
}
