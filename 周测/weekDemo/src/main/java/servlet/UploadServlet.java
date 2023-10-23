package servlet;



import entity.daoentity.KfmFile;
import entity.daoentity.KfmUser;
import finalpool.FileConstant;
import finalpool.UserConstant;
import service.FileService;

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

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    private final List<String> IMAGE_TYPES = List.of("image/jpeg", "image/png", "image/gif");

    private FileService fileService = new FileService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/upload.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        // 上传文件
        Part img = req.getPart("img");

        // 获取文件大小
        long size = img.getSize();

        // 上传的有内容
        if (size > 0){
            // 获取文件类型
            String contentType = img.getContentType();

            if (!IMAGE_TYPES.contains(contentType)){
                response.sendError(503, "上传的文件必须是图片(.jpeg/.png/.gif)");
                return;
            }


            if (size > 1024 * 1024 * 10){
                response.sendError(503, "上传的文件不能超过10M");
                return;
            }

            // 按照日期存储. 获取日期的字符串 替换 - // 20231017
            String date = LocalDate.now().toString().replace("-", "");

            // 保存文件的路径   d:/temp/upload/20231017
            File file = new File(FileConstant.UPLOAD_PATH, date);

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
            String submittedFileName = img.getSubmittedFileName(); // cat.jpg

            // .jpg
            String substring = submittedFileName.substring(submittedFileName.lastIndexOf("."));


            String fileName = UUID.randomUUID().toString().replace("-", "");
            // 存文件  d:/temp/upload/20231017/fileName + substring
            img.write(file.getAbsolutePath() + File.separator + fileName + substring);

            // 存数据库
            KfmFile fileDO = new KfmFile();
            fileDO.setName(submittedFileName);
            fileDO.setSize(size);
            // session 中获取用户
            Object obj = req.getSession().getAttribute(UserConstant.LOGIN_USER);
            KfmUser user = (KfmUser) obj;
//            文件属性
//            fileDO.setCreateUser(user.getId());
//            fileDO.setType(contentType);
            fileDO.setDownloadLink("download/" + date + "/" + fileName + substring);

            try{
                fileService.addFile(fileDO);
                response.sendRedirect(req.getContextPath() + "/file-list");
            } catch (RuntimeException ex){
                // 上传失败
                response.sendRedirect(req.getContextPath() + "/upload");
            }
        }
    }
}
