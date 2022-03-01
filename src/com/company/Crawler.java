package com.company;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Crawler {


    public static void main(String[] args) {
        try {
            Database db = new Database("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "harut");
            db.connect();
            final int linksCount = 40;
            ArrayList<WebPage> pages = db.getLinks(linksCount);

            for (WebPage page : pages) {
                Parser parser = new Parser(page.url);
                parser.parse();

            }
        }
        // Catch block to handle database exceptions
        catch (SQLException | ClassNotFoundException | IOException err) {

            // Print the line number where exception occurs
            err.printStackTrace();
        }


    }


}