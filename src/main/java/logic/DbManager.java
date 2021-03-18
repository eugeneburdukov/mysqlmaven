package logic;

import java.sql.*;
import java.util.ArrayList;

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
        String mydatabase = "avf01_library";
        String ignoreSSL = "?verifyServerCertificate=false&useSSL=true";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase + ignoreSSL;

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

    public String isConnected() {
        Connection connection = getConnection();
        if (connection != null) {
            return "Connection is successfull!";
        }

        return "Connection Error! Please review login details!";
    }

    public void getAuthorResult() {
        ArrayList<Author> authors = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * FROM authors";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                authors.add(new Author(result.getInt(1), result.getString(2), result.getString(3)));
            }
            System.out.println(sql + ";");
            for (Author e : authors) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getBookResult() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * FROM books";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                books.add
                        (new Book(result.getInt(1), result.getString(2),
                                result.getString(3), result.getString(4)));
            }
            System.out.println(sql + ";");
            for (Book e : books) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//    public List<Author> getAuthors() {
//        List<Author> authors = new ArrayList<>();
//        Connection connection = getConnection();
//        if (connection != null) {
//            System.out.println(connection);
//        }
//
//        return authors;
//    }
}
