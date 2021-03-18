package logic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queries queries = new Queries();

        System.out.println(queries.isConnected());
        System.out.println();

        queries.getAuthorResult();
        System.out.println();

        queries.getBookResult();
        System.out.println();

        queries.getJoinTableResult();

        System.out.println();

        queries.createTable();

        System.out.println("Do you want to drop a table(Y/N)?");
        String choice = scanner.next();
        if (choice.equals("Y")) {
            queries.dropTable();
        } else {
            System.out.println("Ok, a table was not removed");
        }




    }
}