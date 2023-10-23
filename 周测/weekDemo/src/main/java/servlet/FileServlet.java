package servlet;


import entity.daoentity.KfmFile;

import service.FileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet("/file-list")
public class FileServlet extends HttpServlet {

    private FileService fileService = new FileService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置响应头
        resp.setContentType("text/html;charset=utf-8");

        // 写网页 包含一个文件表格（table）
        StringBuilder htmlBuilder = new StringBuilder("""
                <html>
                    <head>
                    <meta charset="uft-8">
                        <title>文件列表</title>
                        <style>
                            table{
                                width: 100%;
                                border-collapse: collapse;
                                text-align: center;
                            }
                            th,td{
                                border: 1px solid #ccc;
                                padding: 8px;
                            }
                            th{
                                background-color: #4CAF50;
                                color: white;
                            }
                           </style>
                    </head>
                    <body>
                       <table>
                       <tr>
                          <th>序号</th>
                          <th>文件名</th>
                          <th>大小</th>
                  
                           <th>操作</th>
                        </tr>
                """);

         // 查询文件列表
         List<KfmFile> files = fileService.listFiles();
            // 遍历文件列表，生成表格行
        int i = 1;
        for (KfmFile file : files){
            htmlBuilder.append("""
                     <tr>
                       <td>%d</td>
                       <td>%s</td>
                       <td>%s</td>
            
                       <td>%s</td> 
                    """.formatted(i++, file.getName(), Math.ceil(file.getSize() / 1024.0) + "KB","<a href='" + file.getDownloadLink() + "' target='_blank'>下载</a>"));
        }

        htmlBuilder.append("""
                </table>
                </body>
                </html>
                """);

        resp.getWriter().write(htmlBuilder.toString());


    }

    private String formatDate(Date date)  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
