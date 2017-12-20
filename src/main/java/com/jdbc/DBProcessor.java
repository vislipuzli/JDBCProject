package com.jdbc;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBProcessor {

    private Connection connection;

    public DBProcessor() throws  Exception {
        DriverManager.registerDriver(new FabricMySQLDriver());
    }

    public Connection getConnection(String url, String username, String password) throws Exception {

        if (connection != null)
        return connection;

        connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
}
