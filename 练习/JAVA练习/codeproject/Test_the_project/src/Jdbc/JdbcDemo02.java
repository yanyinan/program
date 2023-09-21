package Jdbc;

import java.sql.*;


/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class JdbcDemo02 {

    public static void main(String[] args) {
        del();
    }

    /**
     * 建立连接
     * @return Connection 返回数据库连接
     */
    private static Connection con() {
        try {
            String name = "root";
            String pass = "";
            String url = "jdbc:mysql://localhost:3306/company";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, name, pass);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private static void del(String ) {
        try (Statement statement = con().createStatement();){
            String sql = "delete from products where product_id = 2;";
            if (statement.executeUpdate(sql) >0){
                System.out.println("成功");
            }else {
                System.out.println("未添加成功");
            }
            con().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void update() {
        try (Statement statement = con().createStatement();){
            String sql = "update products set price = 20 where product_id = 5;";
            statement.execute(sql);
            con().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void select() {
        try (Statement statement = con().createStatement();){
            String sql = "select * from products";
            boolean execute = statement.execute(sql);
            if (execute) {
                System.out.println("执行成功");

            }
            ResultSet resultSet = statement.getResultSet();
            System.out.println(resultSet);
            while (resultSet.next()) {
                for (int i = 1; i < 5; i++) {
                    Object object = resultSet.getObject(i);
                    System.out.print(object+"\t");
                }
                System.out.println();
            }
            resultSet.close();
            con().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void opar() {
        try (Statement statement = con().createStatement();){
            int product_id = 12;
            String product_name = "121";
            String category = "232";
            int price = 121;
            //Sql 语句
            String opar  = "insert into products(product_id, product_name, category, price) values (%d,%s,%s,%d)".formatted(product_id,product_name,category,price);
            if (statement.executeUpdate(opar) >0){
                System.out.println("成功");
            }else {
                System.out.println("未添加成功");
            }
            con().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
