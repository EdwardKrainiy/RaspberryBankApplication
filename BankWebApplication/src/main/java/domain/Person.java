package domain;

import java.util.Objects;

public class Person {
    private int id;
    private String firstName;
    private String secondName;
    private String surName;
    private String phoneNumber;
    private String cardNumber;

    public Person(){
        this.id = -1;
        this.firstName = "";
        this.secondName = "";
        this.surName = "";
        this.phoneNumber = "";
        this.cardNumber = "";
    }

    public Person(int id, String firstName, String secondName, String surName, String phoneNumber, String cardNumber){
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId() == person.getId() &&
                Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getSecondName(), person.getSecondName()) &&
                Objects.equals(getSurName(), person.getSurName()) &&
                Objects.equals(getPhoneNumber(), person.getPhoneNumber()) &&
                Objects.equals(getCardNumber(), person.getCardNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getSecondName(), getSurName(), getPhoneNumber(), getCardNumber());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", surName='" + surName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
