package service;

import com.mysql.cj.util.StringUtils;
import dao.UserDao;
import entity.daoentity.KfmUser;

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
    public KfmUser login(String username, String password) {
        // 参数校验
        if (StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password)) {
            return null;
        }
        // 查询数据库
        return userDao.selectByUsernameAndPassword(username, password);
    }

    public int loginTime(String username, String password) {
        // 参数校验
        // 查询数据库
        return userDao.logintime(username, password);
    }
    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @return 添加成功返回 true ，添加失败返回 false
     */
    public boolean registerUser(KfmUser kfmUser){
        // 添加用户
        if (kfmUser.getName() != null ||
                kfmUser.getUsername() != null ||
                kfmUser.getBirth() != null ||
                kfmUser.getEmail() != null ||
                kfmUser.getPassword() != null
        ) {
            return userDao.insertUser(kfmUser)!=0;
        }else {
            System.out.println("数据未填写完整");
            return false;
        }
    }
}
