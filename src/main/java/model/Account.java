package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account", schema = "bankdb")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account that = (Account) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
