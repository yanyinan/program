package entity.daoentity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * kfm_user 实体类
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/21 9:41
 */
@Data
public class KfmUser implements Serializable {
    private Integer id;
    private String username;
    private String name;
    private String password;
    private Date birth;
    private Date createTime;
    private Date lastLogin;
    private String phone;
    private String email;

}
