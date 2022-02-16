package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    //private static int port;

    public static void main(String[] args){

try {
    Connection connection = DriverManager.getConnection("jdbs:mysql://localhost:3306/webpages,root,root");

    Statement statement = connection.createStatement();

    ResultSet resultSet = statement.executeQuery("select * from pages");

    while (resultSet.next()) {
        System.out.println(resultSet.getString("idpages"));
    }


}catch(Exception e){
    e.printStackTrace();
}


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



    }
}
