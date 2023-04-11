package com.example.demo23.service;

import com.example.demo23.repository.UserRepository;

import java.sql.SQLException;

public class UserService {
    private UserRepository userRepository=new UserRepository();


    public UserService() throws SQLException, ClassNotFoundException {
    }

    public String findLastName(String lastName) throws SQLException {
        return userRepository.findbyLastName(lastName);
    }

    public String findLastName_Ssn(String lastName, String ssn) throws SQLException {
        return userRepository.findbyLast_SSn(lastName, ssn);
    }

    public boolean checkauthority(String lastName, String password) throws SQLException {
        return userRepository.findbyLast_Pwd(lastName, password);
    }

    public boolean checkUsers(String username, String password) throws SQLException {
        return userRepository.findbyUser_Pwd(username, password);
    }
}
