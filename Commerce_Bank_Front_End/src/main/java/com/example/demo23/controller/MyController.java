package com.example.demo23.controller;

import com.example.demo23.domain.Account;
import com.example.demo23.domain.Book;
import com.example.demo23.domain.Users;
import com.example.demo23.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@Controller
public class MyController {
    private final UserService userService=new UserService();

    public MyController() throws SQLException, ClassNotFoundException {
    }



    @GetMapping("checkLastName")
    public String checkLastName(Model model) throws ClassNotFoundException, SQLException {
        return "checkLastName";   //hello.html
    }




//    @GetMapping("GetFullName")
//    public String GetFullName(Model model, @ModelAttribute("lastname") String lastName, @ModelAttribute("ssn") String ssn) throws SQLException {
//
//        String output=userService.findLastName(lastName);
//        model.addAttribute("data1",output);
//
//        String output2=userService.findLastName_Ssn(lastName, ssn);
//        model.addAttribute("data2",output2);
//
//        return "checkResult";
//    }

    @CrossOrigin
    @PutMapping("student")
    public ResponseEntity<?> update(@RequestBody Account account){
        System.out.println(account.getLastName());
        return new ResponseEntity<>("Response Result: 123", HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/showDay/{date}")
    public ResponseEntity<?> showDay(@PathVariable String date){
        System.out.println(date);
        return new ResponseEntity<>("Response Result: "+date, HttpStatus.OK);
    }


    @CrossOrigin
    @PostMapping("/student")
    public ResponseEntity<?> save(@RequestBody Account account) throws SQLException {

        System.out.println("lastname " + account.getLastName());
        System.out.println("ssn " + account.getSsn());
        System.out.println("password "+account.getPassword());

        boolean checkResult=userService.checkauthority(account.getLastName(),account.getPassword());
        System.out.println(checkResult);


        account.setFirstName(account.getLastName()+" Check result: " + checkResult);
        return new ResponseEntity<>(account, HttpStatus.OK);

    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> save(@RequestBody Users users) throws SQLException {
        System.out.println("Username: " + users.getUsername());
        System.out.println("Password: " + users.getPassword());

        boolean checkResults=userService.checkUsers(users.getUsername(), users.getPassword());
        System.out.println(checkResults);

        if (checkResults == true) {
            users.setCurrentUser();
        }

        System.out.println(users.getCurrentUser());
        users.setAuthorized(checkResults);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


/*
    @CrossOrigin
    @DeleteMapping("student")
    public ResponseEntity<?> student(Model model, @ModelAttribute("lastname") String lastName, @ModelAttribute("ssn") String ssn) throws SQLException {
        System.out.println(lastName);
        System.out.println(ssn);
        return new ResponseEntity<>("Response Result: ", HttpStatus.OK);
    }
*/

}
