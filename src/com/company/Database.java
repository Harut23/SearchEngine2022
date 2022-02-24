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


    public ArrayList<WebPage> getLinks(int count, int maxCrawledNumber) {

        try {

            // Write a statement
            String sql = "select * from table1 where ID=1";


            // Execute the query
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Process the results
            // System.out.println("ID\t\tURL\t\t");

            // Condition check using next() method
            // Holds true till there is single element remaining
            // in the object

            while (resultSet.next()) {

                int ID = resultSet.getInt("ID");
                String url = resultSet.getString("URL");
                int crawledNumber = resultSet.getInt("CrawledNumber");

                result.add(new WebPage(ID,crawledNumber,url));
                //
//                // Print and display ID, Link and Text
//                System.out.println(ID + "\t\t" + Links + "\t\t");

                // Set<String> set = new Crawler().findLinks(Links);
                //  System.out.println(set);
                //  new Parser().getTextFromHtml(String.valueOf(new Parser().parse(Links)));

                // new  Crawler().findLinks(Links);
            }


        }

        // Catch block to handle exceptions
        catch (SQLException e) {

            // Print the exception
            System.out.println(e);
        }
        return result;

    }
}
