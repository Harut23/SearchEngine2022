package com.company;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    String url;
    String user;
    String password;

    Connection connection = null;

    public Database(String URL, String user, String password) {

        this.url = URL;
        this.user = user;
        this.password = password;

    }

    ArrayList<WebPage> result = new ArrayList<>();

    public void connect() throws ClassNotFoundException, SQLException {

        // Loading DB(SQL) drivers
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Registering SQL drivers
        connection = DriverManager.getConnection(url, user, password);
    }


    public ArrayList<WebPage> getLinks(int count) {

        try {

            // Write a statement
            String sqlCmd = "SELECT * FROM table1 ORDER BY CrawledNumber ASC ";


            // Execute the query
            PreparedStatement statement = connection.prepareStatement(sqlCmd);
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next() && count > 0) {
                --count;
                int ID = resultSet.getInt("ID");
                String url = resultSet.getString("URL");
                int crawledNumber = resultSet.getInt("CrawledNumber");

                result.add(new WebPage(ID, crawledNumber, url));

            }


        }

        // Catch block to handle exceptions
        catch (SQLException e) {

            // Print the exception
            System.out.println(e);
        }
        return result;

    }

    public void insertLinks(ArrayList<String> links) throws SQLException {
        for (String link : links) {
            String sqlCmd = "INSERT INTO table1(url) VALUES " + link + ";";
            PreparedStatement statement = connection.prepareStatement(sqlCmd);
            statement.executeQuery();
        }
    }

    public void insertContent(int id, ArrayList<String> textContent) {

    }
}
