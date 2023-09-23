package test0932;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        BookManager bookManager = new BookManager();
        bookManager.addBookInfo();
//        bookManager.removeBook();
//        bookManager.modifyBookQuantity();
        bookManager.close();
    }
}