package xyz.nanzhou.fw.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/16 11:42
 */
@WebServlet("/login")
public class RequestDemo001 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //请求对象（req）中获取名为"username"的属性值，并将其赋值给一个名为nameDemo01的Object类型变量。
        Object nameDemo01 = req.getAttribute("username");
        //判断是否登录
        if (nameDemo01 != null){
            System.out.println("已登录");
        }

        // 接收参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        System.out.println(username);
//        System.out.println(password);
        // null 判断，合法性、有效性判断
        if (username != null && password != null
                && "admin".equalsIgnoreCase(username) // jdbc 连接数据库, 从数据库中查询
                && "a123456".equals(password)){
            // 登录成功
            // 记录登录状态
            req.setAttribute("login", true);
            req.setAttribute("username", username);

            // 转发到 indexServlet
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index");
//            requestDispatcher.forward(request, response);
            req.getRequestDispatcher("index").forward(req, resp);
            return; // 结束方法
        } else{
            // 登录失败
            resp.getWriter().println("login failed. username or password is wrong");
        }
    }
}
