package com.example.Commerce_Bank_Back_End.repository;

import java.sql.*;

public class TransactionsRepository {
    Statement statement;

    public TransactionsRepository() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        // Connect to a database
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://127.0.0.1:3306/CommerceBankOne" , "root", "slateydog");
        System.out.println("Database connected");

        // Create a statement
        statement = connection.createStatement();
    }

    //Exact format to find by any variable
    public String findById(Integer t_id) throws SQLException {

        ResultSet resultSet = statement.executeQuery("select u_id from CommerceBankOne.transactions " +
                "where t_id = '" + t_id + "'");

        String output = "";


        while(resultSet.next())
        {
            //System.out.println(resultSet.getString(1) + "\t" +resultSet.getString(2) + "\t" + resultSet.getString(3));
            String u_id = resultSet.getString("u_id");
            System.out.println(u_id);

            output+=u_id+"<br>";

        }

        return output;

    }

    //GET METHODS
    /**************************************/


        //U_Id
        public String getUIdById(Integer t_id) throws SQLException {

            ResultSet resultSet = statement.executeQuery("select u_id from CommerceBankOne.transactions " +
                    "where t_id = '" + t_id + "'");

            String output = "";


            while(resultSet.next())
            {

                String newUId = resultSet.getString("u_id");
                System.out.println(newUId);

                output+=newUId;

            }

            return output;

        }


        //Balance
        public String getBalanceById(Integer t_id) throws SQLException {

            ResultSet resultSet = statement.executeQuery("select balance from CommerceBankOne.transactions " +
                    "where t_id = '" + t_id + "'");

            String output = "";


            while(resultSet.next())
            {

                String newBalance = resultSet.getString("balance");
                System.out.println(newBalance);

                output+=newBalance;

            }

            return output;

        }


        //Amount
        public String getAmountById(Integer t_id) throws SQLException {

            ResultSet resultSet = statement.executeQuery("select amount from CommerceBankOne.transactions " +
                    "where t_id = '" + t_id + "'");

            String output = "";


            while(resultSet.next())
            {

                String newAmount = resultSet.getString("amount");
                System.out.println(newAmount);

                output+=newAmount+"<br>";

            }

            return output;

        }


        //Type
        public String getTypeById(Integer t_id) throws SQLException {

            ResultSet resultSet = statement.executeQuery("select type from CommerceBankOne.transactions " +
                    "where t_id = '" + t_id + "'");

            String output = "";


            while(resultSet.next())
            {

                String newType = resultSet.getString("type");
                System.out.println(newType);

                output+=newType;

            }

            return output;

        }


        //Savings_Goal
        public String getSavingsGoalById(Integer t_id) throws SQLException {

            ResultSet resultSet = statement.executeQuery("select savings_goal from CommerceBankOne.transactions " +
                    "where t_id = '" + t_id + "'");

            String output = "";


            while(resultSet.next())
            {

                String newSavingsGoal = resultSet.getString("savings_goal");
                System.out.println(newSavingsGoal);

                output+=newSavingsGoal;

            }

            return output;

        }


        //Date
        public String getDateById(Integer t_id) throws SQLException {

            ResultSet resultSet = statement.executeQuery("select date from CommerceBankOne.transactions " +
                    "where t_id = '" + t_id + "'");

            String output = "";


            while(resultSet.next())
            {

                String newDate = resultSet.getString("date");
                System.out.println(newDate);

                output+=newDate;

            }

            return output;

        }

    //Get All by U_Id
    /***************************************************/

        //T_Id
        public String getTIdByUId(Integer u_id) throws SQLException {

            ResultSet resultSet = statement.executeQuery("select t_id from CommerceBankOne.transactions " +
                    "where u_id = '" + u_id + "'");

            String output = "";


            while(resultSet.next())
            {

                String newTId = resultSet.getString("t_id");
                System.out.println(newTId);

                output+=newTId + ", ";

            }

            return output;

        }

        //Balance
        public String getBalanceByUId(Integer u_id) throws SQLException {

            ResultSet resultSet = statement.executeQuery("select balance from CommerceBankOne.transactions " +
                    "where u_id = '" + u_id + "'");

            String output = "";


            while(resultSet.next())
            {

                String newBalance = resultSet.getString("balance");
                System.out.println(newBalance);

                output+=newBalance + ", ";

            }

            return output;

        }

        //Amount
        public String getAmountByUId(Integer u_id) throws SQLException {

            ResultSet resultSet = statement.executeQuery("select amount from CommerceBankOne.transactions " +
                    "where u_id = '" + u_id + "'");

            String output = "";


            while(resultSet.next())
            {

                String newAmount = resultSet.getString("amount");
                System.out.println(newAmount);

                output+=newAmount + ", ";

            }

            return output;

        }

        //Type
        public String getTypeByUId(Integer u_id) throws SQLException {

            ResultSet resultSet = statement.executeQuery("select type from CommerceBankOne.transactions " +
                    "where u_id = '" + u_id + "'");

            String output = "";


            while(resultSet.next())
            {

                String newType = resultSet.getString("type");
                System.out.println(newType);

                output+=newType + ", ";

            }

            return output;

        }

        //Savings_Goal
        public String getSavingsGoalByUId(Integer u_id) throws SQLException {

            ResultSet resultSet = statement.executeQuery("select savings_goal from CommerceBankOne.transactions " +
                    "where u_id = '" + u_id + "'");

            String output = "";


            while(resultSet.next())
            {

                String newSavingsGoal = resultSet.getString("savings_goal");
                System.out.println(newSavingsGoal);

                output+=newSavingsGoal + ", ";

            }

            return output;

        }

        //Date
        public String getDateByUId(Integer u_id) throws SQLException {

            ResultSet resultSet = statement.executeQuery("select date from CommerceBankOne.transactions " +
                    "where u_id = '" + u_id + "'");

            String output = "";


            while(resultSet.next())
            {

                String newDate = resultSet.getString("date");
                System.out.println(newDate);

                output+=newDate + ", ";

            }

            return output;

        }






    //Calendar View Methods
    /***************************************************/

        //Display all expenses/incomes
        public String displayExpensesIncomes(Integer u_id) throws SQLException {

            ResultSet resultSet = statement.executeQuery("select amount from CommerceBankOne.transactions " +
                    "where u_id = '" + u_id + "'");

            String output = "";


            while(resultSet.next())
            {

                String newExpensesIncome = resultSet.getString("amount");
                System.out.println(newExpensesIncome);

                output+=newExpensesIncome + ", ";

            }

            return output;

        }


        //set savings goal
        public String setSavingsGoal(Integer t_id, double val) throws SQLException {
            String query = "UPDATE CommerceBankOne.transactions SET savings_goal=" + val +
                    " where t_id = '" + t_id + "'";
            statement.executeUpdate(query);
            String output = "Done";
            return output;
        }

        //daily balance
        public double findDailyBalance(Integer u_id, Integer month) throws SQLException {

            ResultSet resultSet = statement.executeQuery("select balance from CommerceBankOne.transactions " +
                    "where u_id = '" + u_id + "' AND month(date) = " + month);

            double count = 0;
            double balance = 0;


            while(resultSet.next())
            {


                String newBalance = resultSet.getString("balance");

                if(newBalance != null){
                    balance = Double.parseDouble(newBalance);
                    System.out.println(balance);
                    count+=balance;
                } else {
                    System.out.println("null");
                }

            }

            return count;

        }


    //Balance Adjustment View Methods
    /***************************************************/

        //update Balance
        public String updateBalance(Integer t_id, Double val) throws SQLException {
            String query = "UPDATE CommerceBankOne.transactions SET balance=" + val +
                    " where t_id = '" + t_id + "'";
            statement.executeUpdate(query);
            String output = "Done";
            return output;
        }

        //new expense/income
        public String newExpensesIncomes(Integer t_id, Integer u_id, double balance, double amount, String type, double savings_goal, String date) throws SQLException {
            String query = "INSERT INTO CommerceBankOne.transactions VALUES (" + t_id + ", " + u_id + ", " + balance + ", " + amount + ", '" + type + "', " + savings_goal + ", DATE '" + date + "')";
            statement.executeUpdate(query);
            String output = "Done";
            return output;
        }

        //update type
        public String setType(Integer t_id, String val) throws SQLException {
            String query = "UPDATE CommerceBankOne.transactions SET type='" + val +
                    "' where t_id = '" + t_id + "'";
            statement.executeUpdate(query);
            String output = "Done";
            return output;
        }




}
