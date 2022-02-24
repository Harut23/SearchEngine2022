package com.company;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Crawler {


    public static void main(String[] args) throws IOException, SQLException {


        try {
            Database db = new Database("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "harut");
            db.connect();

            ArrayList<WebPage> pages = db.getLinks(4);

            for(WebPage page : pages) {
                System.out.println(page.url);
             Parser parser = new Parser(page.url);
            parser.parse();
                System.out.println(parser.getHtml());

            }
        }
        // Catch block to handle database exceptions
        catch (SQLException | ClassNotFoundException e) {

            // Print the line number where exception occurs
            e.printStackTrace();
        }

        catch (IOException io){
            System.out.println("error");;
        }



    }


}