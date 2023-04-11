package com.example.demo23.domain;

public class Users {
    String username;
    String password;
    String authorized;
    String currentUser;

    public Users(String username, String password, String authorized, String currentUser) {
        this.username = username;
        this.password = password;
        this.authorized = authorized;
        this.currentUser = currentUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = String.valueOf(authorized);
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser() {
        this.currentUser = username;
    }
}
