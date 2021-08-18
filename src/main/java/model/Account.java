package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account extends BaseEntity {

    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account that = (Account) o;
        return id == that.id && Objects.equals(login, that.login) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }

    public Account(String login, String password){
        this.login = login;
        this.password = password;
    }

    public Account() {
    }
}
