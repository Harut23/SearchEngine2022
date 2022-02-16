/*package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcQueries {

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager
                .getConnection("jdbc:mysql://localhost/test?serverTimezone=UTC",
                        "root", "root")) {

            PreparedStatement selectStatement = conn.prepareStatement("select * from WebInfos");
            ResultSet rs = selectStatement.executeQuery();

            List<WebInfo> WebInfos = new ArrayList<>();

            while (rs.next()) { // will traverse through all rows
                Integer id = rs.getInt("ID");
                String URL = rs.getString("URL");
                String text = rs.getString("text");

                WebInfo ob = new WebInfo(1,""," ");
                WebInfos.add(ob);
            }

        }
    }


}
*/