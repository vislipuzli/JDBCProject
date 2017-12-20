package com.jdbc;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        ParserOfQuery parserOfQuery = new ParserOfQuery();
        parserOfQuery.entranceQuestion();

    }
}
