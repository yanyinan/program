package demo01.web.servlet;

import demo01.web.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 26481
 */
@WebServlet("/welcome")
public class WelcomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object flag = req.getSession().getAttribute(Constant.LOGIN_USER);
        if(flag == null){
            // 没登录
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }
        // 请求转发到 /WEB-INF/welcome.html 页面
        req.getRequestDispatcher("/WEB-INF/welcome.html").forward(req, resp);
    }
}
