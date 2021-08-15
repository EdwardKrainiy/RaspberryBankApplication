package dao;

public class AccountInfoRepository extends EntityRepository<model.AccountInfo> {
    @Override
    public String getTableName() {
        return "Accountinfo";
    }
}