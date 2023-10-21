package dao;

import entity.daoentity.KfmUser;
import utils.dao.basesoperations.DbUtilsHelper;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * UserDao 用于处理用户表
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/21 10:56
 */
public class UserDao {
    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 查询到的用户. 如果没有查询到, 返回 null
     */
    public KfmUser selectByUsernameAndPassword(String username,String password){
        String sql = "select id, username, name from kfm_user where username = ? and password = ?";
        return DbUtilsHelper.queryOne(sql, KfmUser.class,username,password);
    }

    /**
     * 查询所有用户
     * @return 查询到的用户. 如果没有查询到, 返回 null
     */
    public List<KfmUser> selectByUsernameAndPassword(){
        String sql = "select id, username, name from kfm_user";
        return DbUtilsHelper.queryList(sql, KfmUser.class);
    }

    /**
     * 增加用户
     * @param kfmUser 用户名
     * @return 添加用户，如果没有添加成功返回 0
     */
    public int insertUser(KfmUser kfmUser){
        //todo 注册
        String sql = "insert into kfm_user(username,name,password,birth,create_time,email,phone) values(?,?,?,?,?,?,?)";
        return DbUtilsHelper.update(sql,kfmUser.getUsername(),kfmUser.getName(),kfmUser.getPassword(),kfmUser.getBirth(),kfmUser.getCreateTime(),kfmUser.getEmail(),kfmUser.getPhone());
    }

    /**
     * 登录时间
     * @param username 用户账号
     * @param password 用户密码
     * @return 更新成功
     */
    public int logintime(String username,String password){
        String sql = "update kfm_user set last_login = ? where username = ? and password = ?";
        return DbUtilsHelper.update(sql,LocalDateTime.now(),username,password);
    }
}
