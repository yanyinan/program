package test0932;

import utils.SqlUtils;

import java.sql.SQLException;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class BookManager {

    String user ="root";
    String pass = "";
    String url = "jdbc:Localhost:3306/manger";
    String reurl = "Localhost";
    String adds ="D:\\小练习\\Test0923\\sourse\\sql.txt" ;

    public BookManager() throws SQLException {
        init();
    }
    public void init() throws SQLException {
        SqlUtils bookSql = new SqlUtils(user,pass,url);
        bookSql.conn();
        bookSql.initialize(initia(),reurl,user,pass,"manger",adds);
        bookSql.colse();
    }

    private String initia() {
        String sql = "mysql -h ? -u ? -p ? ? < ?";
//        mysql -h127.0.0.1 -u root -p root db_name<back.sql
        return sql;

    }
}
