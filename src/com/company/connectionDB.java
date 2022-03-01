package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDB {


    final String DB_URL = "jdbc:mysql://localhost:3306/db?useSSL=false";


    final String USER = "root";

    final String PASS = "harut";

    public Connection connectDB() {

        Connection con = null;

        try {

            // Loading DB drivers
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Registering SQL drivers
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            // the line number of exception
            e.printStackTrace();
        }

        return con;
    }
}


