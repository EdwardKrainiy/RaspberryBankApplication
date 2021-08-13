package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account", schema = "bankdb")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    private int balance;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getNumber() == account.getNumber() && getBalance() == account.getBalance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
