package com.jdbc;

public class Users {

    private int user_id;
    private String login;
    private String password;
    private String email;

    public Users(){

    }
    public Users(int user_id, String login, String password, String email){
        this.user_id = user_id;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User: [" + login + "\t" + email + "]";
    }
}
