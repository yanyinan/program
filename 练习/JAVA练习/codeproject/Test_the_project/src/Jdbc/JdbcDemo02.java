package Jdbc;

import java.sql.*;


/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class JdbcDemo02 {

    public static void main(String[] args) {

    }

    /**
     * 建立连接
     *
     * @return Connection 返回数据库连接
     */
    private static Connection con() {
        try {
            //用户名
            String name = "root";
            //用户密码
            String pass = "";
            //数据库链接
            String url = "jdbc:mysql://localhost:3306/company";
            // 加载驱动类， 解耦
//            DriverManager.registerDriver(new Driver());
            // 全限定类名
            Class.forName("com.mysql.cj.jdbc.Driver");
            //创建链接
            Connection connection = DriverManager.getConnection(url, name, pass);

            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除测试
     */
    private static void del() {
        // 建立链接，执行操作
        try (Statement statement = con().createStatement();) {
            //sql语句
            String sql = "delete from products where product_id = 4;";
            //执行 sql 并检测是否成功
            if (statement.executeUpdate(sql) > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("未删除成功");
            }
            //关闭链接
            con().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 基础删除
     *
     * @param tableName 删除表名
     * @param condition 条件
     */
    private static void del(String tableName, String condition) {
        // 建立链接，执行操作
        try (Statement statement = con().createStatement();) {
            //sql语句
            String sql = "delete from %s where %s;".formatted(tableName, condition);
            //执行 sql 检测是否成功
            if (statement.executeUpdate(sql) > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("未删除成功");
            }
            //关闭链接
            con().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新测试
     */
    private static void update() {
        // 建立链接，执行操作
        try (Statement statement = con().createStatement();) {
            //Sql 语句
            String sql = " update products set price = 12 where product_id = 5;";
            //执行 sql
            statement.execute(sql);
            //关闭链接
            con().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 基础更新
     *
     * @param tableName 待操作表名
     * @param condition 条件
     * @param content   修改内容
     */
    private static void update(String tableName, String condition, String content) {
        // 建立链接，执行操作
        try (Statement statement = con().createStatement();) {
            //Sql 语句
            String sql = "update %s set %s where %s;".formatted(tableName, content, condition);
            //执行 sql
            statement.execute(sql);
            //关闭链接
            con().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询测试
     */
    private static void select() {
        // 建立链接，执行操作
        try (Statement statement = con().createStatement();) {
            //Sql 语句
            String sql = "select * from product;";
            //执行 sql 返回是否执行成功
            boolean execute = statement.execute(sql);
            //判断
            if (execute) {
                System.out.println("执行成功");
            }
            // sql 执行的结果
            ResultSet resultSet = statement.getResultSet();
            //遍历
            while (resultSet.next()) {
                for (int i = 1; i < 5; i++) {
                    Object object = resultSet.getObject(i);
                    System.out.print(object + "\t");
                }
                System.out.println();
            }
            // 关闭结果流
            resultSet.close();
            //关闭链接
            con().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 基础查询
     *
     * @param tableName 查询待查询表
     * @param content   待查询元素
     */
    private static void select(String tableName, String content) {
        // 建立链接，执行操作
        try (Statement statement = con().createStatement();) {
            //Sql 语句
            String sql = "select %s from %s;".formatted(content, tableName);

            if (statement.execute(sql)) {
                System.out.println("执行成功");
            }
            // sql 执行的结果
            ResultSet resultSet = statement.getResultSet();
            //遍历数据
            while (resultSet.next()) {
                for (int i = 1; i < 5; i++) {
                    Object object = resultSet.getObject(i);
                    System.out.print(object + "\t");
                }
                System.out.println();
            }
            // 关闭结果流
            resultSet.close();
            //关闭链接
            con().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 添加测试
     */
    private static void addSql() {
        // 建立链接，执行操作
        try (Statement statement = con().createStatement();) {
            int product_id = 12;
            String product_name = "121";
            String category = "232";
            int price = 121;
            //Sql 语句
            String par = "insert into products(product_id, product_name, category, price) values (%d,%s,%s,%d)".formatted(product_id, product_name, category, price);
            //检测是否成功
            if (statement.executeUpdate(par) > 0) {
                System.out.println("成功");
            } else {
                System.out.println("未添加成功");
            }
            //关闭链接
            con().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 基础添加
     *
     * @param tableNameContent 待添加内容
     * @param values           添加内容
     */
    private static void addSql(String tableNameContent, String values) {
        // 建立链接，执行操作
        try (Statement statement = con().createStatement()) {
            //Sql 语句
            String par = "insert into %s values (%s)".formatted(tableNameContent, values);
            //检测是否成功
            if (statement.executeUpdate(par) > 0) {
                System.out.println("成功");
            } else {
                System.out.println("未添加成功");
            }
            //关闭链接
            con().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
