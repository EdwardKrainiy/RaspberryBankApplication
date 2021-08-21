package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "card")
public class Card extends BaseEntity{

    @Column(name = "AccountId")
    private int accountId;

    @Column(name = "CardNumber")
    private String cardNumber;

    @Column(name = "SecureCode")
    private String secureCode;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSecureCode() {
        return secureCode;
    }

    public void setSecureCode(String secureCode) {
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

    public Card(int accountId, String cardNumber, String secureCode) {
        this.accountId = accountId;
        this.cardNumber = cardNumber;
        this.secureCode = secureCode;
    }

    public Card() {
    }
}
