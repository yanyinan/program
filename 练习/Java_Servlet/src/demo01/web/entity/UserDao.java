package demo01.web.entity;


import demo01.web.entity.User;
import demo01.web.util.DBHelper;

import java.sql.SQLException;

/**
 * UserDao 用于处理用户表(user)数据
 * @author 26481
 */
public class UserDao {

    private DBHelper db = new DBHelper();

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 查询到的用户. 如果没有查询到, 返回 null
     * @throws SQLException
     */
    public User selectByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "select id, username, password from user where username = ? and password = ?";
        return db.selectOne(sql, User.class, username, password);
    }
}
