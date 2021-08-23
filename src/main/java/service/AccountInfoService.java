package service;

import dao.AccountInfoRepository;
import model.AccountInfo;

import java.util.List;

public class AccountInfoService {
    private static final AccountInfoRepository accountInfoRepository = new AccountInfoRepository();

    public AccountInfoService(){};

    public static AccountInfo findAccountInfo(int id){
        return accountInfoRepository.findById(id);
    }

    public List<AccountInfo> findAllAccountInfos(){
        return accountInfoRepository.findAll();
    }

    public static void saveAccountInfo(AccountInfo accountInfo){
        accountInfoRepository.create(accountInfo);
    }

    public void updateAccountInfo(AccountInfo accountInfo){
        accountInfoRepository.update(accountInfo);
    }

    public void deleteAccountInfo(AccountInfo accountInfo){
        accountInfoRepository.delete(accountInfo);
    }

    public static AccountInfo findAccountInfoByLogin(int accountId){
        return accountInfoRepository.findAccountInfoById(accountId);
    }
}
