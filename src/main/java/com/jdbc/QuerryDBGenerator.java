package com.jdbc;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

public class QuerryDBGenerator {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";

    public void loginToDB(String login, String password) throws Exception {

        if(parseIfRegistered(login, password)){
            System.out.println("Welcome " + login);
        }

        else {
            System.out.println("Login or password is incorect or doesn't exist.");
            ParserOfQuery newQuery = new ParserOfQuery();
            newQuery.entranceQuestion();
        }
    }

    private boolean parseIfRegistered(String login, String password) throws Exception {

        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);

        String query = "SELECT * FROM users.new_table WHERE login = '" + login +"' and password = '"+ password +"'";
        java.sql.PreparedStatement prepQuery = conn.prepareStatement(query);

        prepQuery.execute();

        java.sql.PreparedStatement prepStat = conn.prepareStatement(query);
        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void register(String login) throws Exception {


        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URL, USERNAME, PASSWORD);

        String query = "SELECT * FROM users.new_table WHERE login = '" + login + "'";
        java.sql.PreparedStatement prepQuery = conn.prepareStatement(query);
        prepQuery.execute();

        java.sql.PreparedStatement prepStat = conn.prepareStatement(query);
        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()){
            System.out.println("Login already exist! Try again.");
            ParserOfQuery parserOfQuery = new ParserOfQuery();
            parserOfQuery.entranceQuestion();
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Please, enter password: ");
        String password = input.nextLine();
        System.out.println("Please, enter email: ");
        String email = input.nextLine();

        if (!email.contains("@")){
            System.out.println("Sorry, email is incorrect. Try again and ");
            register(login);
        }

        String insert = "INSERT INTO `users`.`new_table` (`login`, `password`, `email`) VALUES ('"+login+"', '"+password+"', '"+email+"')";
        java.sql.PreparedStatement prepInsert = conn.prepareStatement(insert);
        prepInsert.execute();
        prepStat.executeQuery();

        System.out.println("Welcome " + login + "! Yor email is "+ email);

    }

}
