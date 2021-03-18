package logic;

public class Main {
    public static void main(String[] args) {
        DbManager dbManager = new DbManager();
        dbManager.getConnection();
        System.out.println(dbManager.isConnected());

        System.out.println();

        dbManager.getAuthorResult();

        System.out.println();

        dbManager.getBookResult();

        System.out.println();

        dbManager.getJoinTableResult();


    }
}
