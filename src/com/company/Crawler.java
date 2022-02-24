package com.company;

import java.io.IOException;
import java.sql.SQLException;

public class Crawler {


    public static void main(String[] args) throws IOException, SQLException {


        try {
            Database db = new Database("jdbc:mysql://localhost:3306/db?useSSL=false", "root", "harut");
            db.connect();
        }
        // Catch block to handle database exceptions
        catch (SQLException | ClassNotFoundException e) {

            // Print the line number where exception occurs
            e.printStackTrace();
        }






/*        Set<String> set = new Parser().getHTML("https://www.list.am/ru/");//set i mej a gcum amboxj html-y

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
    */
    }


}