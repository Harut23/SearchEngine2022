package com.company;

import java.io.IOException;

public class Crawler {


    public static void main(String[] args) {
        try {
          /*  Database db = new Database("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "harut");
            db.connect();

            ArrayList<WebPage> pages = db.getLinks(4);
            // System.out.println(pages.size());

            for (WebPage page : pages) {
                //System.out.println(page.url);

                Parser parser = new Parser(page.url);
//                parser.parseText();
                parser.parseLinks(); // <---nullptrexception

                //System.out.println(parser.getHtml());

            }*/

            Parser parser = new Parser("https://www.bbc.com/news");
            parser.parse();

        }
        // Catch block to handle database exceptions
        catch (/*SQLException | ClassNotFoundException | */IOException err) {

            // Print the line number where exception occurs
            err.printStackTrace();
        }


    }


}