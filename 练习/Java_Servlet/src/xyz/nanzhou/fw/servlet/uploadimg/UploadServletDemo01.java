package xyz.nanzhou.fw.servlet.uploadimg;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/17 14:05
 */
@MultipartConfig(location = "d://temp") // 上传文件必须加上这个注解
@WebServlet("/upload")
public class UploadServletDemo01 extends HttpServlet {
    private final List<String> IMAGE_TYPES = List.of("image/jpeg", "image/png", "image/gif");

    private final String UPLOAD_PATH = "d:/temp/upload";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取文件
        Part img = req.getPart("img");
        // 获取文件类型
        String contentType = img.getContentType();
        System.out.println("getContentType : " + contentType);
        long imgSize = img.getSize();
        // 获取文件大小
        long size = img.getSize();
        if (size > 1024 * 1024 * 10){
            resp.sendError(503, "上传的文件不能超过10M");
            return;
        }

        // 按照日期存储. 获取日期的字符串 替换 -
        String date = LocalDate.now().toString().replace("-", "");

        // 保存文件的路径   d:/temp/upload/20231017
        File file = new File(UPLOAD_PATH, date);

        // 判断文件夹是否存在
        if (!file.exists()){
            // 不存在创建
            file.mkdirs();
        }

        /*
         重命名文件，防止文件冲突
            时间戳
            UUID
         */
        String submittedFileName = img.getSubmittedFileName();

        // 获取文件名后缀  .jpg
        String substring = submittedFileName.substring(submittedFileName.lastIndexOf("."));


        String fileName = UUID.randomUUID().toString().replace("-", "");
        // 存文件
        img.write(file.getAbsolutePath() + File.separator + fileName + substring);
    }
}
