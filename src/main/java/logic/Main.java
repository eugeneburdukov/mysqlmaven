package logic;

public class Main {
    public static void main(String[] args) {
        Queries queries = new Queries();

        System.out.println(queries.isConnected());
        System.out.println();

        queries.getAuthorResult();
        System.out.println();

        queries.getBookResult();
        System.out.println();

        queries.getJoinTableResult();


    }
}
