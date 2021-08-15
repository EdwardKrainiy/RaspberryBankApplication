package service;

import dao.AccountInfoRepository;
import model.AccountInfo;

import java.util.List;

public class AccountInfoService {
    private final AccountInfoRepository accountInfoRepository = new AccountInfoRepository();

    public AccountInfoService(){};

    public AccountInfo findAccountInfo(int id){
        return accountInfoRepository.findById(id);
    }

    public List<AccountInfo> findAllAccountInfos(){
        return accountInfoRepository.findAll();
    }

    public void saveAccountInfo(AccountInfo accountInfo){
        accountInfoRepository.save(accountInfo);
    }

    public void updateAccountInfo(AccountInfo accountInfo){
        accountInfoRepository.update(accountInfo);
    }

    public void deleteAccountInfo(AccountInfo accountInfo){
        accountInfoRepository.delete(accountInfo);
    }
}
