package service;


import dao.FileDao;
import entity.daoentity.KfmFile;

import java.sql.SQLException;
import java.util.List;

/**
 * 文件服务类
 */
public class FileService {

    private FileDao fileDao = new FileDao();

    public List<KfmFile> listFiles() {
        return fileDao.selectAll();
    }

    public void addFile(KfmFile file){
        int save = fileDao.save(file);
        if (save == 0){
            throw new RuntimeException("保存文件失败");
        }
    }
}
