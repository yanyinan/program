package test0932;


import test0932.utils.SqlUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class BookManager {

    static Scanner input = new Scanner(System.in);
    String user ="root";
    String pass = "";
    String url = "jdbc:mysql://localhost:3306/manger";
    String adds ="C:\\Users\\26481\\Desktop\\git_up\\progrmstudynote\\练习\\JAVA练习\\codeproject\\Test_the_project\\src\\test0932\\sql.txt";
    SqlUtils bookSql;
    public BookManager() throws SQLException {
        init();
    }

    /**
     * 初始化系统
     * @throws SQLException
     */
    public void init() throws SQLException {
        bookSql = new SqlUtils(user,pass,url);
        bookSql.conn();
        initi(bookSql);
    }

    /**
     * 关闭系统
     * @throws SQLException
     */
    public void close() throws SQLException {
        if (bookSql != null){
            bookSql.colse();
        }
    }

    /**
     * 初始化文本摘取
     * @param bookSql
     * @throws SQLException
     */
    private void initi(SqlUtils bookSql) throws SQLException {
        String[] string = initia().split(";");
        for (int i = 0; i< string.length;i++){
            bookSql.initialize(string[i]);
        }
    }

    /**
     * 初始化 operation_log books
     * @return
     */
    private String initia() {
        File file = new File(adds);
        try (FileInputStream inputStream = new FileInputStream(file);) {
            byte[] bytes = inputStream.readAllBytes();
            String sql = new String(bytes,0,bytes.length);
            return sql;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void addBookInfo() throws SQLException {
        String sql = "insert into books(book_title,publication_date,author,price,quantity) values(?,?,?,?,?)";
        String book_title, publication_date, author ;
        Double price;
        Integer quantity;
        System.out.println("书名");
        book_title = input.nextLine();
        System.out.println("日期");
        publication_date = input.nextLine();
        System.out.println("作者");
        author = input.nextLine();
        System.out.println("价格");
        price = input.nextDouble();
        System.out.println("数量");
        quantity = input.nextInt();
        bookSql.grud(sql,book_title,publication_date,author,price,quantity);
//        bookSql.grud(sql,1,"book_title","2023/2/2","author",12.1,1);
    }
    public void removeBook() throws SQLException {
        String sql ="delete from books where id =?";
        String content = input.nextLine();
        bookSql.grud(sql,content);
    }
    public void modifyBookQuantity() throws SQLException {
        String sql ="update books set quantity = ? where id =?;";
        int quantity = input.nextInt();
        int id = input.nextInt();
        bookSql.grud(sql,quantity,id);
        System.out.println("修改成功");
    }
    public void showAllBooks(){}
    public void log(String desc) {}

}
