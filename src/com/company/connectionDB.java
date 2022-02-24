package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDB {




        final String DB_URL = "jdbc:mysql://localhost:3306/db?useSSL=false";

        //  Database credentials

        // We need two parameters to access the database
        // Root and password

        // 1. Root
        final String USER = "root";

        // 2. Password to fetch database
        final String PASS = "harut";

        // Connection class for our database connectivity
        public Connection connectDB()
        {
            // Initially setting NULL
            // to connection class object
            Connection con = null;

            // Try block to check exceptions
            try {

                // Loading DB(SQL) drivers
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Registering SQL drivers
                con = DriverManager.getConnection(DB_URL, USER, PASS);
            }

            // Catch block to handle database exceptions
            catch (SQLException | ClassNotFoundException e) {
                // Print the line number where exception occurs
                e.printStackTrace();
            }

            // Returning Connection class object to
            // be used in (App/Main) GFG class
            return con;
        }
    }


