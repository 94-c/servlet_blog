package com.blog.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public Connection getConnection() {
        try{
            String url = "jdbc:mysql://localhost:3306/servlet_blog?serverTimezone=UTC";
            String id = "root";
            String pw = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, id, pw);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("DBUtil Error");
        }
        return null;
    }


}
