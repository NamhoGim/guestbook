package com.project.one.guestbook.util;

import javax.sql.DataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class DBUtil implements DataSource {

    static final String dbUrl = "localhost";
    static final String dbUser = "root";
    static final String databaseName = "guestBook";
    static final String dbPassword = "tksqhs511";
    static final String sqlDriver = "com.mysql.cj.jdbc.Driver";

    public Connection getConnection() {
        return getConnection(dbUser, dbPassword);
    }

    public Connection getConnection(String dbUser, String dbPassword) {

        try {
            Class.forName(sqlDriver);
            return DriverManager.getConnection("jdbc:mysql://" + dbUrl + "/" + databaseName +
                    "?useSSL=false&serverTimezone=UTC&characterEncoding=utf8", dbUser, dbPassword);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
