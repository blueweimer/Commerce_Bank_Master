package com.example.Commerce_Bank_Back_End.controller;

import com.example.Commerce_Bank_Back_End.domain.Transactions;
import com.example.Commerce_Bank_Back_End.service.TransactionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Date;

@Controller
public class TransactionsController {
    private final TransactionsService transactionsService = new TransactionsService();


    public TransactionsController() throws SQLException, ClassNotFoundException {
    }

    //Checking if Get Mapping Works
    @CrossOrigin
    @GetMapping("/checkGetWorks")
    public ResponseEntity<?> checkGetWorks(Model model) throws ClassNotFoundException, SQLException {
        System.out.println("");
        return new ResponseEntity<>("Get Works", HttpStatus.OK);
    }


    //GET METHODS By T_id
    /******************************************/

        //Test Get T_id path variable... get from local
        @CrossOrigin
        @GetMapping("/getId/{t_id}")
        public ResponseEntity<?> getId(@PathVariable Integer t_id) throws ClassNotFoundException, SQLException {
            System.out.println(t_id);
            return new ResponseEntity<>("T_Id: " + t_id, HttpStatus.OK);
        }


        //Get U_id
        @CrossOrigin
        @GetMapping("/getUIdById/{t_id}")
        public ResponseEntity<?> getUIdById(Model model, @PathVariable Integer t_id) throws ClassNotFoundException, SQLException {
            System.out.println(t_id);
            String newUId = transactionsService.getUIdById(t_id);
            return new ResponseEntity<>("U_Id: " + newUId, HttpStatus.OK);
        }

        //Get Balance
        @CrossOrigin
        @GetMapping("/getBalanceById/{t_id}")
        public ResponseEntity<?> getBalanceById(Model model, @PathVariable Integer t_id) throws ClassNotFoundException, SQLException {
            System.out.println(t_id);
            String newBalance = transactionsService.getBalanceById(t_id);
            return new ResponseEntity<>("Balance: " + newBalance, HttpStatus.OK);
        }

        //Get Amount
        @CrossOrigin
        @GetMapping("/getAmountById/{t_id}")
        public ResponseEntity<?> getAmountById(Model model, @PathVariable Integer t_id) throws ClassNotFoundException, SQLException {
            System.out.println(t_id);
            String newAmount = transactionsService.getAmountById(t_id);
            return new ResponseEntity<>("Amount: " + newAmount, HttpStatus.OK);
        }

        //Get Type
        @CrossOrigin
        @GetMapping("/getTypeById/{t_id}")
        public ResponseEntity<?> getTypeById(Model model, @PathVariable Integer t_id) throws ClassNotFoundException, SQLException {
            System.out.println(t_id);
            String newType = transactionsService.getTypeById(t_id);
            return new ResponseEntity<>("Type: " + newType, HttpStatus.OK);
        }

        //Get Savings_Goal
        @CrossOrigin
        @GetMapping("/getSavingsGoalById/{t_id}")
        public ResponseEntity<?> getSavingsGoalById(Model model, @PathVariable Integer t_id) throws ClassNotFoundException, SQLException {
            System.out.println(t_id);
            String newSavingsGoal = transactionsService.getSavingsGoalById(t_id);
            return new ResponseEntity<>("Savings_goal: " + newSavingsGoal, HttpStatus.OK);
        }

        //Get Date
        @CrossOrigin
        @GetMapping("/getDateById/{t_id}")
        public ResponseEntity<?> getDateById(Model model, @PathVariable Integer t_id) throws ClassNotFoundException, SQLException {
            System.out.println(t_id);
            String newDate = transactionsService.getDateById(t_id);
            return new ResponseEntity<>("Date: " + newDate, HttpStatus.OK);
        }



    //GET METHODS By U_id
    /******************************************/


        //Get T_id
        @CrossOrigin
        @GetMapping("/getTIdByUId/{u_id}")
        public ResponseEntity<?> getTIdByUId(Model model, @PathVariable Integer u_id) throws ClassNotFoundException, SQLException {
            String newTId = transactionsService.getTIdByUId(u_id);
            return new ResponseEntity<>("T_Id: " + newTId, HttpStatus.OK);
        }

        //Get Balance
        @CrossOrigin
        @GetMapping("/getBalanceByUId/{u_id}")
        public ResponseEntity<?> getBalanceByUId(Model model, @PathVariable Integer u_id) throws ClassNotFoundException, SQLException {
            String newBalance = transactionsService.getBalanceByUId(u_id);
            return new ResponseEntity<>("Balance: " + newBalance, HttpStatus.OK);
        }

        //Get Amount
        @CrossOrigin
        @GetMapping("/getAmountByUId/{u_id}")
        public ResponseEntity<?> getAmountByUId(Model model, @PathVariable Integer u_id) throws ClassNotFoundException, SQLException {
            String newAmount = transactionsService.getAmountByUId(u_id);
            return new ResponseEntity<>("Amount: " + newAmount, HttpStatus.OK);
        }

        //Get Type
        @CrossOrigin
        @GetMapping("/getTypeByUId/{u_id}")
        public ResponseEntity<?> getTypeByUId(Model model, @PathVariable Integer u_id) throws ClassNotFoundException, SQLException {
            String newType = transactionsService.getTypeByUId(u_id);
            return new ResponseEntity<>("Type: " + newType, HttpStatus.OK);
        }

        //Get Savings_Goal
        @CrossOrigin
        @GetMapping("/getSavingsGoalByUId/{u_id}")
        public ResponseEntity<?> getSavingsGoalByUId(Model model, @PathVariable Integer u_id) throws ClassNotFoundException, SQLException {
            String newSavingsGoal = transactionsService.getSavingsGoalByUId(u_id);
            return new ResponseEntity<>("SavingsGoal: " + newSavingsGoal, HttpStatus.OK);
        }

        //Get Date
        @CrossOrigin
        @GetMapping("/getDateByUId/{u_id}")
        public ResponseEntity<?> getDateByUId(Model model, @PathVariable Integer u_id) throws ClassNotFoundException, SQLException {
            String newDate = transactionsService.getDateByUId(u_id);
            return new ResponseEntity<>("Date: " + newDate, HttpStatus.OK);
        }




     //Calendar View Methods
    /***************************************************/

        //Display all expenses/incomes by u_id
        @CrossOrigin
        @RequestMapping(value = "/displayExpensesIncomes/{u_id}", method = {RequestMethod.POST, RequestMethod.GET})
        public ResponseEntity<?> displayExpensesIncomes(Model model, @PathVariable Integer u_id, Transactions transactions) throws ClassNotFoundException, SQLException {
            String newExpensesIncomesDisplay = transactionsService.displayExpensesIncomes(u_id);
            return new ResponseEntity<>(newExpensesIncomesDisplay, HttpStatus.OK);
        }



        //update savings_goal
        @CrossOrigin
        @RequestMapping(value = "/setSavingsGoal/{t_id}/{val}", method = {RequestMethod.POST, RequestMethod.GET})
        public ResponseEntity<?> setSavingsGoal(Model model, @PathVariable Integer t_id, @PathVariable double val, Transactions transactions) throws ClassNotFoundException, SQLException {
            String newSetGoal = transactionsService.setSavingsGoal(t_id, val);
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        }

        //get target balance     formula: (day/total days in month) * monthly savings + balance
        @CrossOrigin
        @RequestMapping(value = "/getTargetBalance/{t_id}", method = {RequestMethod.POST, RequestMethod.GET})
        public @ResponseBody Double getTargetBalance(Model model, @PathVariable Integer t_id, Transactions transactions) throws ClassNotFoundException, SQLException {
            double output = 0;

            String date = transactionsService.getDateById(t_id);
            String[] parts = date.split("-");

            //get year as int
            String year = parts[0];
            int yearInt = Integer.parseInt(year);

            //get month as int
            String month = parts[1];
            int monthInt = Integer.parseInt(month);

            //get day as int
            String day = parts[2];
            int dayInt = Integer.parseInt(day);

            //get monthly savings
            double monthlySavings = Double.parseDouble(transactionsService.getSavingsGoalById(t_id));

            //get balance
            double balance = Double.parseDouble(transactionsService.getBalanceById(t_id));

            // Get the number of days in that month
            YearMonth yearMonthObject = YearMonth.of(yearInt, monthInt);
            int daysInMonth = yearMonthObject.lengthOfMonth();

            //Formula: (day/total days in month)*monthly savings+ balance
            output = (((double)dayInt/(double)daysInMonth) * monthlySavings) + balance;
            System.out.println(output);

            if(output == 0){
                return 0.0;
            } else {
                return output;
            }

        }

        //find if over or under target balance

        @CrossOrigin
        @RequestMapping(value = "/findOverUnder/{t_id}/{month}", method = {RequestMethod.POST, RequestMethod.GET})
        public @ResponseBody Double findOverUnder(Model model, @PathVariable Integer t_id, @PathVariable Integer month, Transactions transactions) throws ClassNotFoundException, SQLException {
            //find target balance
            Double target = getTargetBalance(model, t_id, transactions);

            //find daily balance by adding up all amounts on that day
            Double daily = findDailyBalance(model, Integer.valueOf(transactionsService.getUIdById(t_id)), month, transactions);

            //see if over or under
            if(daily > target){
                System.out.println("Over target value by " + (daily - target));
            } else if (daily < target){
                System.out.println("Under target value by " + (target - daily));
            } else {
                System.out.println("Equal with target value at " + (daily));
            }
            return daily - target;

        }

        //get daily balance
        @CrossOrigin
        @RequestMapping(value = "/findDailyBalance/{u_id}/{month}", method = {RequestMethod.POST, RequestMethod.GET})
        public @ResponseBody double findDailyBalance(Model model, @PathVariable Integer u_id,  @PathVariable Integer month, Transactions transactions) throws ClassNotFoundException, SQLException {

            //Return array of all balance with given u_id and given month
            double newDailyBalance = transactionsService.findDailyBalance(u_id, month);
            //add all up

            return newDailyBalance;

        }





    //Balance Adjustment View Methods
    /***************************************************/

        //check and set initial balance
        @CrossOrigin
        @RequestMapping(value = "/updateBalance/{t_id}/{val}", method = {RequestMethod.POST, RequestMethod.GET})
        public ResponseEntity<?> updateBalance(Model model, @PathVariable Integer t_id, @PathVariable Double val, Transactions transactions) throws ClassNotFoundException, SQLException {
            if(transactionsService.getBalanceById(t_id) == null){
                String newBalance = transactionsService.updateBalance(t_id, val);
            }
                return new ResponseEntity<>(transactions, HttpStatus.OK);

        }

        //set expenses/incomes
        @CrossOrigin
        @RequestMapping(value = "/newExpensesIncomes/{t_id}/{u_id}/{amount}/{balance}/{type}/{savings_goal}", method = {RequestMethod.POST, RequestMethod.GET})
        public ResponseEntity<?> newExpensesIncomes(Model model, @PathVariable Integer t_id, @PathVariable Integer u_id, @PathVariable double amount, @PathVariable double balance, @PathVariable String type, @PathVariable double savings_goal, Transactions transactions) throws ClassNotFoundException, SQLException, ParseException {



            Date date = new Date();

            SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String input = oldFormat.format(date);

            Date newdate = oldFormat.parse(input);
            SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
            String output = newFormat.format(newdate);

            String newTransactions = transactionsService.newExpensesIncomes(t_id, u_id, balance, amount, type, savings_goal, output);
            return new ResponseEntity<>(newTransactions, HttpStatus.OK);

        }



        //update type
        @CrossOrigin
        @RequestMapping(value = "/updateType/{t_id}/{val}", method = {RequestMethod.POST, RequestMethod.GET})
        public ResponseEntity<?> updateType(Model model, @PathVariable Integer t_id, @PathVariable String val, Transactions transactions) throws ClassNotFoundException, SQLException {
            String newType = transactionsService.setType(t_id, val);
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        }





}
