package com.company;

import java.io.IOException;
import java.sql.*;

public class Main {


    public static void main(String[] args) throws IOException, SQLException {

        // Step 2: Establishing a connection
        connectionDB connection = new connectionDB();

        // Assigning NULL to object of Connection class
        // as shown returned by above program
        Connection con = null;

        PreparedStatement p = null;
        ResultSet rs = null;

        // Step 3: Loading and registereding drivers
        // Loaded and registered in Connection class
        // shown in above program
        //con = connection.connectDB();
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "harut");
        // Try block to check exceptions
        try {

            // Step 4: Write a statement
            String sql = "select * from webpage where id=1";

            // Step 5: Execute the query
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            // Step 6: Process the results
            System.out.println("id\t\tLinks\t\t                    Text");

            // Condition check using next() method
            // Holds true till there is single element remaining
            // in the object
            if (rs.next()) {

                int ID = rs.getInt("ID");
                String Links = rs.getString("Links");
                String Text = rs.getString("Text");
                //String password = rs.getString("password");

                // Print and display ID, Link and Text
                System.out.println(ID + "\t\t" + Links + "\t\t" + Text );


              //  new Parser().getTextFromHtml(String.valueOf(new Parser().parse(Links)));

              // new  Crawler().findLinks(Links);
            }
        }

        // Catch block to handle exceptions
        catch (SQLException e) {

            // Print the exception
            System.out.println(e);
        }
    }
}


//new Crawler().findLinks("https://www.list.am/ru/");

        // new newParser().URLReader("https://www.list.am/ru/",6);
       /*  String html = "<html><body><p>текст1</p><p>текст2</p><img src=\"some.jpg\"><br><p>текст3<img src=\"another.jpg\"><br></body></html>";

                Document doc = Jsoup.parse(result);
                Elements paragraphs = doc.select("p");
                for(Element paragraph : paragraphs) {
                    System.out.println(paragraph.text());
                }
            }
        }
*/






     /*   Socket socket = new Socket();
      //  String host = null;
        SocketAddress socketAddress = new InetSocketAddress(String.valueOf(80), port);
        socket.connect(socketAddress, 30000);
*/

        //  Set<String> links = new Crawler().findLinks("https://www.list.am/ru/");

      /*  for(String el:links){
            System.out.println(el);
        }
*/


