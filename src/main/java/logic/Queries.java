package logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Queries extends DbManager{

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

    public void getJoinTableResult() {
        try {
            Statement statement = connection.createStatement();
            String sql = "select books.title, authors.name " +
                    "from authors join books on books.author = authors.id where authors.country = 'USA'";
            ResultSet result = statement.executeQuery(sql);
            System.out.println(sql + ";");
            while (result.next()) {
                String title = result.getString("title");
                String name = result.getString("name");

                System.out.println(" | " + title + " | " + name + " | ");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTable() {
        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE `TLDTYPES` (`Id` int(6) NOT NULL DEFAULT '0'," +
                    " `Test` varchar(64) NOT NULL DEFAULT '') ENGINE=InnoDB;";
            statement.executeUpdate(sql);
            System.out.println(sql + ";");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropTable() {
        try {
            Statement statement = connection.createStatement();
            String sql = "DROP TABLE TLDTYPES";
            statement.execute(sql);
            System.out.println(sql + ";");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
