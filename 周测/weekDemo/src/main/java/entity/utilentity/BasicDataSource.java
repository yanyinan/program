package entity.utilentity;

import lombok.Data;

import java.io.Serializable;

/**
 * 基本数据源
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/21 10:12
 */
@Data
public class BasicDataSource implements Serializable {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
