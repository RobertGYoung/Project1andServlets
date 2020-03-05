package com.revature.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


	
public class SingletonConnection {
    private static SingletonConnection instance;
    private Connection connection;
    private String url = "jdbc:oracle:thin:@localhost:1522:orcl";
    private String username = "Rahb";
    private String password = "root";
    private SingletonConnection() throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }
    public Connection getConnection() {
        return connection;
    }
    public static SingletonConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new SingletonConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new SingletonConnection();
        }
        return instance;
    }
}
	
	
	
