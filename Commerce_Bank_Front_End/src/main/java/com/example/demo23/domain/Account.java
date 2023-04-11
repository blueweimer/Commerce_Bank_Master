package com.example.demo23.domain;

public class Account {
    Integer ssn;
    String firstName;
    String lastName;
    Integer phone;
    String street;
    String password;

    public Account(Integer ssn, String firstName, String lastName, Integer phone, String street, String password) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.street = street;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPhone() {
        return phone;
    }

    public String getStreet() {
        return street;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
