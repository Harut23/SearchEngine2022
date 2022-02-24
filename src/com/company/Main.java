package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.sql.*;
import java.util.Set;

public class Main {


    public static void main(String[] args) throws IOException, SQLException {

        Set<String> set = new Parser().getHTML("https://www.list.am/ru/");//set i mej a gcum amboxj html-y

       // String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
        Document doc = Jsoup.parse(String.valueOf(set));
        String text = ((org.jsoup.nodes.Document) doc).body().text(); // "An example link"

        //System.out.println(text);


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
               String sql = "select * from table1 where ID=1";


            // Step 5: Execute the query
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            // Step 6: Process the results
            System.out.println("ID\t\tURL\t\t");

            // Condition check using next() method
            // Holds true till there is single element remaining
            // in the object
            if (rs.next()) {

                int ID = rs.getInt("ID");
                String Links = rs.getString("URL");
                //String Text = rs.getString("Text");
                //String password = rs.getString("password");

                // Print and display ID, Link and Text
                System.out.println(ID + "\t\t" + Links + "\t\t");

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
/*
        try {
            String url = "jdbc:mysql://localhost:3306/db";
            Connection conn = DriverManager.getConnection(url,"root","harut");
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO table2 " + "VALUES ('1','')");

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

*/

  /*db i mej avelacnelu hamar
      try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "harut");
            Statement mystmt = conn.createStatement();
           // mystmt.executeUpdate("insert into webpage "  + "values('4','','ssss')");
  mystmt.executeUpdate("insert into db.webpage(Text) "  + "values('ssss')");
 // mystmt.executeUpdate("insert TOP(1) into db.webpage(Text) "  + "values('ssss')" + "wehere ID=1");


              //System.out.println("all good");
        }catch(SQLException e){
            e.printStackTrace();
        }
*/
    }
}

/*    String url = "jdbc:mysql://localhost:3306/db";
        String user = "root";
        String password = "harut";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
Statement mystmt = conn.createStatement();
mystmt.executeUpdate("insert into webpage" + "Text" + "values('a','ssss')");
            System.out.println("all good");
        }catch(SQLException e){
            e.printStackTrace();
        }

    }*/






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


