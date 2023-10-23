package entity.daoentity;

import lombok.Data;


import java.io.Serializable;
import java.util.Date;

/**
 * KfmFile 实体类
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/21 9:47
 */
@Data
public class KfmFile implements Serializable {
    private int id;
    private String name;
    private long size;
    private Date createTime;
    private String uploadIp;
    private String downloadLink;

}
