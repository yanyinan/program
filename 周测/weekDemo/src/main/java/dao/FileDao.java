package dao;

import entity.daoentity.KfmFile;
import utils.dao.basesoperations.DbUtilsHelper;

import java.util.List;

/**
 * 用于处理文件
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/23 9:43
 */
public class FileDao {
    /**
     * 查找所有文件
     * @return 返回文件对象序列
     */
    public List<KfmFile> selectAll() {
        String sql ="select id,name,size,create_time,upload_ip,download_link from kfm_file";
        return DbUtilsHelper.queryList(sql,KfmFile.class);
    }

    /**
     * 添加文件
     * @param file
     * @return
     */
    public int save(KfmFile file) {
        String sql = "insert  into kfm_file(name,size,create_time,upload_ip,download_link) values(?,?,?,?,?)";
        return DbUtilsHelper.update(sql,file.getName(),file.getSize(),file.getCreateTime(),file.getUploadIp(),file.getDownloadLink());
    }
}
