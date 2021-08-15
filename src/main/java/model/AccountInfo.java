package model;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "accountinfo", schema = "bankdb")
public class AccountInfo extends BaseEntity {
    private int id;
    private int accountId;
    private String firstname;
    private String lastname;
    private String patronymic;
    private String phoneNumber;
    private int balance;

    @Basic
    @Column(name = "AccountID")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "Firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "Lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "Patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "PhoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "Balance")
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountInfo that = (AccountInfo) o;
        return id == that.id && accountId == that.accountId && balance == that.balance && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(patronymic, that.patronymic) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, firstname, lastname, patronymic, phoneNumber, balance);
    }
}
