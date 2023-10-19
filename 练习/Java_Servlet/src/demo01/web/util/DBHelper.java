package demo01.web.util;

import demo01.web.servlet.LoginServlet;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 数据库工具类
 * <p>
 * 提供获取连接的方法
 * CRUD 方法
 *
 * 支持事务
 */
public class DBHelper {

    // 数据库连接信息
    private static String url;

    private static String user;

    private static String pass;

    // 操作对象
    private Connection conn;

    private PreparedStatement ps;

    private boolean autoCommit = true;

    private ResultSet rs;

    static{
        InputStream resourceAsStream = LoginServlet.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);


            // 加载驱动类
            Class.forName(properties.getProperty("driver"));

            url = properties.getProperty("url");
            user = properties.getProperty("username");
            pass = properties.getProperty("password");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DBHelper() {
    }

    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()){
            try {
                conn = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }


    public void startTransaction() throws SQLException {
        getConnection();
        if (conn != null && !conn.isClosed() && autoCommit == true){
            conn.setAutoCommit(false);
            autoCommit = false;
        }
    }

    public void commit() throws SQLException {
        if (conn != null && !conn.isClosed() && autoCommit == false){
            conn.commit();
            autoCommit = true;
        }
    }

    public void rollback() throws SQLException {
        if (conn != null && !conn.isClosed() && autoCommit == false){
            conn.rollback();
            autoCommit = true;
        }
    }

    /**
     * 释放资源
     */
    public void close(){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            rs = null;
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ps = null;
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conn = null;
        }
    }

    /**
     * 修改数据操作
     * insert  update delete
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */

    public int update(String sql, Object... params) throws SQLException {
        // 获取连接
        getConnection();
        // 创建 PreparedStatement 对象
        ps = conn.prepareStatement(sql);

        // 设置值
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }

        // 执行 sql
        return ps.executeUpdate();
    }

    /**
     * 新增并返回自增长值
     * @return
     */
    public int insert(String sql, Object... params) throws SQLException {
        // 获取连接
        getConnection();

        // 创建 prepareStatement
        ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // 设置值
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }

        // 执行操作
        ps.executeUpdate();


        // 去自增长值
        rs = ps.getGeneratedKeys();

        // 取值
        if (rs.next()){
            return rs.getInt(1);
        }
        return -1;
    }


    public <T> T selectOne(String sql, IResultMapper<T> resultMapper,  Object... params) throws SQLException {
        // 获取连接
        getConnection();

        // 创建 prepareStatement
        ps = conn.prepareStatement(sql);

        // 设置值
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }

        // 执行操作
        rs = ps.executeQuery();

        // 解析结果
        if (rs.next()){
            return resultMapper.mapper(rs);
        }
        return null;
    }

    public <T> T selectOne(String sql, Class<T> cla,  Object... params) throws SQLException {
        // 获取连接
        getConnection();

        // 创建 prepareStatement
        ps = conn.prepareStatement(sql);

        // 设置值
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }

        // 打印执行的 SQL
        System.out.println(ps);
        // 执行操作
        rs = ps.executeQuery();

        // 解析结果
        if (rs.next()){
            return mapper(rs, cla);
//            return resultMapper.mapper(rs);
        }
        return null;
    }

    private <T> T mapper(ResultSet set, Class<T> cla) {
        try {
            // 创建对象
            Constructor<T> declaredConstructor = cla.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            T t = declaredConstructor.newInstance();

            // 解析结果集
            ResultSetMetaData metaData = set.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount ; i++) {
                // 获取列名 getColumnLabel 和 getColumnName 的区别：前者获取别名，后者获取列名
                String columnName = metaData.getColumnLabel(i).toLowerCase();

                // 判断是否由多个单词组成
                if (columnName.contains("_")){
                    // 有多个单词组成，转换为驼峰命名
                    columnName = toCamelCase(columnName);
                }

                try{
                    // 获取属性描述器
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName, cla);

                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    writeMethod.setAccessible(true);

                    // 设置值
                    Object value = set.getObject(i);
                    writeMethod.invoke(t, value);
                } catch (Exception e){
                    // 没有对应的属性
                    System.err.println("没有对应的属性：" + columnName + "，跳过");
                }



            }
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String toCamelCase(String columnName) {
        // 判断是否由多个单词组成
        if (columnName.contains("_")){
            // 有多个单词组成，转换为驼峰命名  is_marry
            String[] split = columnName.split("_");
            StringBuilder sb = new StringBuilder(split[0]);
            for (int i = 1; i < split.length; i++) {
                String s = split[i];
                sb.append(s.substring(0, 1).toUpperCase()).append(s.substring(1).toLowerCase());
            }
            return sb.toString();
        }
        return columnName;
    }

    public <T> List<T> selectList(String sql, IResultMapper<T> resultMapper,  Object... params) throws SQLException {
        // 获取连接
        getConnection();

        // 创建 prepareStatement
        ps = conn.prepareStatement(sql);

        // 设置值
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }

        // 执行操作
        rs = ps.executeQuery();

        List<T> list = new ArrayList<>();
        // 解析结果
        while (rs.next()){
            T t = resultMapper.mapper(rs);
            list.add(t);
        }

        return list;
    }

    public <T> List<T> selectList(String sql, Class<T> cla,  Object... params) throws SQLException {
        // 获取连接
        getConnection();

        // 创建 prepareStatement
        ps = conn.prepareStatement(sql);

        // 设置值
        if (params != null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }

        // 执行操作
        rs = ps.executeQuery();

        List<T> list = new ArrayList<>();
        // 解析结果
        while (rs.next()){
            T t = mapper(rs, cla);
            list.add(t);
        }

        return list;
    }

}

/**
 * 结果映射
 */
@FunctionalInterface
interface IResultMapper<T> {

    T mapper(ResultSet set);
}


