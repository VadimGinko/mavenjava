package my;

import my.Newspaper;

import java.sql.*;
import java.util.ArrayList;

public class Connect {
    public static ArrayList<Newspaper> take()
    {
        String DB_URL = "jdbc:mysql://localhost:3306/servlet?autoReconnect=true&useSSL=false";
        String DB_NAME = "root";
        String DB_PASSWORD = "6788393vadim";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        ArrayList<Newspaper> list = new ArrayList<Newspaper>();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM newspapers");
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Newspaper def = new Newspaper();
                def.NewspaperName = res.getString("NewspaperName");
                def.NewspaperType = res.getString("NewspaperType");
                list.add(def);
            }
            return list;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
}
