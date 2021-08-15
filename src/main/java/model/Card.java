package model;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "card", schema = "bankdb", catalog = "")
public class Card extends BaseEntity{
    private int id;
    private int accountId;
    private String cardNumber;
    private int secureCode;

    @Basic
    @Column(name = "AccountId")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "CardNumber")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "SecureCode")
    public int getSecureCode() {
        return secureCode;
    }

    public void setSecureCode(int secureCode) {
        this.secureCode = secureCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card that = (Card) o;
        return id == that.id && accountId == that.accountId && secureCode == that.secureCode && Objects.equals(cardNumber, that.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, cardNumber, secureCode);
    }
}
