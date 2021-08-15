package dao;

import model.Card;

public class CardRepository extends EntityRepository<Card> {

    @Override
    public String getTableName() {
        return "card";
    }
}
