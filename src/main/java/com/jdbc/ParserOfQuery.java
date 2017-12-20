package com.jdbc;

import java.util.Scanner;

public class ParserOfQuery {

    private String answer;

    void entranceQuestion() throws Exception {

        System.out.println("Do you want to login or register? [l/r]: ");
        Scanner input = new Scanner(System.in);
        this.answer = input.nextLine();
        parseOfAnswer();
    }

    private void parseOfAnswer() throws Exception {

        if (this.answer.equals("l")){
            Scanner input = new Scanner(System.in);

            System.out.println("Please, enter login: ");
            String login = input.nextLine();

            System.out.println("Please, enter password: ");
            String password = input.nextLine();

            QuerryDBGenerator loginInput = new QuerryDBGenerator();
            loginInput.loginToDB(login, password);
        }

        if (this.answer.equals("r")){
            QuerryDBGenerator register = new QuerryDBGenerator();

            Scanner input = new Scanner(System.in);
            System.out.println("Please, enter login: ");
            String login = input.nextLine();

            register.register(login);
        }

        if (!this.answer.equals("l")&& !this.answer.equals("r")){
            System.out.println("Please repeat.");
            entranceQuestion();
        }
    }
}
