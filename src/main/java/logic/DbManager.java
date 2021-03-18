package logic;

import java.sql.*;

public class DbManager {
    Connection connection;

    public Connection getConnection() {
        String driverName = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driverName); // here is the ClassNotFoundException
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //mysql -h'avf01.mysql.tools' -u'avf01_library' -p'C96%6-Ljbk' avf01_library
        String serverName = "avf01.mysql.tools";
        String databaseName = "avf01_library";
        String ignoreSSL = "?verifyServerCertificate=false&useSSL=true";
        String url = "jdbc:mysql://" + serverName + "/" + databaseName + ignoreSSL;

        String username = "avf01_library";
        String password = "C96%6-Ljbk";
        try {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
