package demo01.web.servlet;


import com.wf.captcha.utils.CaptchaUtil;
import demo01.web.Constant;
import demo01.web.entity.User;
import demo01.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * LoginServlet 用于处理登录请求
 * @author 26481
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String captcha = req.getParameter("captcha");

        // 校验验证码
        if (!CaptchaUtil.ver(captcha, req)) {
            // 验证码错误
            // 清除验证码
            CaptchaUtil.clear(req);
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }
        // 清除验证码
        CaptchaUtil.clear(req);

        // 登录
        User loginUser = userService.login(username, password);

        if (loginUser == null){
            // 登录失败
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            // 登录成功
            // 将登录成功的用户信息保存到 Session 中
            HttpSession session = req.getSession();

            // 设置session有效期为60分钟
            session.setMaxInactiveInterval(60 * 60);

            session.setAttribute(Constant.LOGIN_USER, loginUser);
            // 重定向到欢迎页面
            resp.sendRedirect(req.getContextPath() + "/welcome");
        }
    }
}
