package dao;

import model.AccountInfo;

public class AccountInfoRepository extends EntityRepository<AccountInfo> {
    @Override
    public String getTableName() {
        return "Accountinfo";
    }
}