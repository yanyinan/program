package test0932;


import test0932.utils.SqlUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class BookManager {

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
    public void addBookInfo(){}
    public void removeBook(){}
    public void modifyBookQuantity(){}
    public void showAllBooks(){}
    public void log(String desc) {}

}
