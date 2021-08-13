package service;

import dao.BankDAO;
import model.Bank;

import java.util.List;

public class BankService {
    private final BankDAO bankDAO = new BankDAO();

    public BankService(){};

    public Bank findBank(int id){
        return bankDAO.findById(id);
    }

    public List<Bank> findAllBanks(){
        return bankDAO.findAll();
    }

    public void saveBank(Bank bank){
        bankDAO.save(bank);
    }

    public void updateBank(Bank bank){
        bankDAO.update(bank);
    }

    public void deleteBank(Bank bank){
        bankDAO.delete(bank);
    }
}
