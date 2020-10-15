package com.project.one.guestbook.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    static final String dbUrl = "localhost";
    static final String dbUser = "root";
    static final String databaseName = "guestBook";
    static final String dbPassword = "tksqhs511";
    static final String sqlDriver = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        return getConnection(dbUrl, databaseName, dbUser, dbPassword);
    }

    public static Connection getConnection(String dbUrl,String databaseName, String dbUser, String dbPassword) {

        try {
            Class.forName(sqlDriver);
            return DriverManager.getConnection("jdbc:mysql://" + dbUrl + "/" + databaseName + "?useSSL=false&serverTimezone=UTC&characterEncoding=utf8", dbUser, dbPassword);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}