package demo01.web.service;

import com.mysql.cj.util.StringUtils;
import demo01.web.entity.UserDao;
import demo01.web.entity.User;

import java.sql.SQLException;

/**
 * UserService 用于处理用户相关的业务逻辑
 * @author 26481
 */
public class UserService {

    private UserDao userDao = new UserDao();

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回 User 对象，登录失败返回 null
     */
    public User login(String username, String password) {
        // 参数校验
        if (StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password)) {
            return null;
        }

        try {
            // 查询数据库
            return userDao.selectByUsernameAndPassword(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
