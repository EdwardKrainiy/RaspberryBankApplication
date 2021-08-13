package service;

import dao.AccountDAO;
import model.Account;

import java.util.List;

public class AccountService {
    private final AccountDAO accountDAO = new AccountDAO();

    public AccountService(){}

    public Account findAccount(int number){
        return accountDAO.findById(number);
    }

    public List<Account> findAllAccounts(){
        return accountDAO.findAll();
    }

    public void saveAccount(Account account){
        accountDAO.save(account);
    }

    public void updateAccount(Account account){
        accountDAO.update(account);
    }

    public void deleteAccount(Account account){
        accountDAO.delete(account);
    }
}
