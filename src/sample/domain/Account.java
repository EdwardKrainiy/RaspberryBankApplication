package sample.domain;

import java.util.Objects;

public class Account {
    private int number;
    private int personId;
    private int bankId;

    public Account(){
        this.number = -1;
        this.personId = -1;
        this.bankId = -1;
    }

    public Account(int number, int personId, int bankId) {
        this.number = number;
        this.personId = personId;
        this.bankId = bankId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getNumber() == account.getNumber() &&
                getPersonId() == account.getPersonId() &&
                getBankId() == account.getBankId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getPersonId(), getBankId());
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", personId=" + personId +
                ", bankId=" + bankId +
                '}';
    }
}
