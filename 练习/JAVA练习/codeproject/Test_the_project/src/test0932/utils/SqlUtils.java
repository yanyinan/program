package test0932.utils;

import java.sql.*;
import java.util.List;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class SqlUtils {
    static {
        // 注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 用户连接信息
      */
    private String user;
    private String pass;
    private String url;
    private Connection conn;
    private PreparedStatement prestate;

    /**
     * 有参构造
     * @param user 用户名
     * @param pass 用户密码
     * @param url 数据库链接
     */
    public SqlUtils(String user, String pass, String url) {
        this.user = user;
        this.pass = pass;
        this.url = url;
    }

    /**
     * 与数据库建立连接
     * @return 链接
     * @throws SQLException
     */
    public Connection conn() throws SQLException {
        conn = DriverManager.getConnection(url,user,pass);
        return conn;
    }

    /**
     * 关闭连接 conn prestate
     * @throws SQLException
     */
    public void colse() throws SQLException {
        if (conn != null){
            conn.close();
        }
        if (prestate != null){
            prestate.close();
        }
    }

    /**
     * 初始化表操作
     * @param sql sql语句
     * @throws SQLException
     */
    public void initialize(String sql) throws SQLException {
        prestate = conn().prepareStatement(sql);
        prestate.execute();
    }

    public <T> T selectOne(String sql,String... params){
        return null;
    }
    public List<T> l selectAll(String sql, String... params){
        return null;
    }
    /**
     * GRUD操作
     * insert update
     * @param sql
     * @param params
     * @throws SQLException
     */
    public int update(String sql,String... params) throws SQLException {
        prestate = conn().prepareStatement(sql);
        setParams(params);
        return prestate.executeUpdate();
    }
    /**
     * 设置值
     * @param params 元素
     * @throws SQLException
     */
    private void setParams(Object... params) throws SQLException {
        if (params != null){
            // 设置参数
            for (int i = 0; i < params.length; i++) {
                prestate.setObject(i + 1, params[i]);
            }
        }
    }
}
