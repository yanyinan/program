package xyz.nanzhou.fw.servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/14 13:55
 */
@WebServlet("/parameter")
public class ServletDemo003  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ParameterServlet 接收到请求");

        // 设置请求编码
        req.setCharacterEncoding("utf-8");

        // 获取请求参数
        String username = req.getParameter("username");
        String[] hobbies = req.getParameterValues("hobby");

        System.out.println("username : " + username);
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
    }
}
