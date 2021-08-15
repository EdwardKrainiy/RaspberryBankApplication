package service;

import dao.AccountRepository;
import model.Account;

import java.util.List;

public class AccountService {
    private final AccountRepository accountRepository = new AccountRepository();

    public AccountService(){}

    public Account findAccount(int number){
        return accountRepository.findById(number);
    }

    public List<Account> findAllAccounts(){
        return accountRepository.findAll();
    }

    public void saveAccount(Account account){
        accountRepository.save(account);
    }

    public void updateAccount(Account account){
        accountRepository.update(account);
    }

    public void deleteAccount(Account account){
        accountRepository.delete(account);
    }
}
