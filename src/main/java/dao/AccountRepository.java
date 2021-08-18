package dao;

import model.Account;

public class AccountRepository extends EntityRepository<Account> {

    @Override
    public String getTableName() {
        return "Account";
    }
}
