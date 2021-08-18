package service;

import dao.AccountRepository;
import model.Account;

import java.util.List;

public class AccountService {
    private static final AccountRepository accountRepository = new AccountRepository();

    public AccountService(){}

    public static Account findAccount(int number){
        return accountRepository.findById(number);
    }

    public static List<Account> findAllAccounts(){
        return accountRepository.findAll();
    }

    public static Account findByLogin(String login){
        return accountRepository.findByLogin(login);
    }

    public static void saveAccount(Account account){
        accountRepository.save(account);
    }

    public static void updateAccount(Account account){
        accountRepository.update(account);
    }

    public static void deleteAccount(Account account){
        accountRepository.delete(account);
    }
}
