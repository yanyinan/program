package utils.dao.basesoperations;

import entity.dbutilentity.BasicDataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.bases.reader.ConfigReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * 定义一个工具类，封装了常用的数据库操作方法
 *
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/21 10:05
 */

public class DbUtilsHelper {

    /**
     * 定义一个私有的QueryRunner对象，用于执行SQL语句
     */
    private static QueryRunner queryRunner = new QueryRunner();

    /**
     * 定义一个私有的构造方法，防止外部创建实例
     */
    private DbUtilsHelper() {
    }

    /**
     * 定义一个公共的静态方法，获取数据库连接
     * @return 返回连接
     */
    public static Connection getConnection() throws SQLException {

        // 获取数据源
        BasicDataSource basicDataSource = ConfigReader.basicData;

        // 全限定类名
        try {
            Class.forName(basicDataSource.getDriverClassName());
        } catch (ClassNotFoundException e) {
            System.out.println("注册异常");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection(basicDataSource.getUrl(), basicDataSource.getUsername(), basicDataSource.getPassword());
    }

    /**
     * 定义一个公共的静态方法，执行增删改操作
     * @param sql sql执行与语句
     * @param params 参数
     * @return 返回值
     */
    public static int update(String sql, Object... params)  {
        // 获取数据库连接
        Connection conn;
        try {
            conn = getConnection();
        } catch (SQLException e) {
            System.out.println("增删改操作连接数据库异常");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try {
            // 调用QueryRunner的update方法，执行SQL语句，返回影响的行数
            return queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            // 处理异常
            System.out.println("增删改操作异常");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 定义一个公共的静态方法，执行查询操作，返回单个对象
     * @param sql SQL执行语句
     * @param type 对象类型
     * @param params 参数
     * @param <T> 泛型
     * @return 查询结果
     */
    public static <T> T queryOne(String sql, Class<T> type, Object... params)  {
        // 获取数据库连接
        Connection conn;
        try {
            conn = getConnection();
        } catch (SQLException e) {
            System.out.println("查询单个操作连接数据库异常");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try {
            // 调用QueryRunner的query方法，执行SQL语句，使用BeanHandler处理结果集，返回单个对象
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), params);
        } catch (SQLException e) {
            // 处理异常
            System.out.println("查询数据库异常");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 定义一个公共的静态方法，执行查询操作，返回多个对象
     * @param sql SQL执行语句
     * @param type 对象类型
     * @param params 参数
     * @param <T> 泛型
     * @return 查询结果
     */
    public static <T> List<T> queryList(String sql, Class<T> type, Object... params) {
        // 获取数据库连接
        Connection conn;
        try {
            conn = getConnection();
        } catch (SQLException e) {
            System.out.println("查询多个操作连接数据库异常");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try {
            // 调用QueryRunner的query方法，执行SQL语句，使用BeanListHandler处理结果集，返回多个对象
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), params);
        } catch (SQLException e) {
            // 处理异常
            System.out.println("查询数据库异常");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            DbUtils.closeQuietly(conn);
        }
    }

}
