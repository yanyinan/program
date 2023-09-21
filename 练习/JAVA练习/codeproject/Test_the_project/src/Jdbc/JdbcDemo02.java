package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Class.forName;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class JdbcDemo02 {
    public static void main(String[] args) {

        opar();
    }

    private static void opar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String name = "root";
            String pass = "";
            String url = "jdbc:mysql://localhost:3306/company";
            try (Connection oparConnection = DriverManager.getConnection(url, name, pass);
                 Statement oparStatement = oparConnection.createStatement()) {
                int product_id = 12;
                String product_name = "苹果";
                String category = "水果";
                int price = 121;
                //Sql 语句
                String opar  = "insert into products(product_id, product_name, category, price) values (%d,%s,%s,%d)".formatted(product_id,product_name,category,price);
                oparStatement.execute(opar);
                int upRow = oparStatement.getUpdateCount();
                System.out.println(upRow);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
