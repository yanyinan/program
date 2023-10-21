package servlet;

import com.wf.captcha.utils.CaptchaUtil;
import entity.daoentity.KfmUser;
import finalpool.UserConstant;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/21 11:37
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求数据
        String username = req.getParameter("name");
        String password = req.getParameter("pass");
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
        KfmUser loginUser = userService.login(username, password);

        if (loginUser == null){
            // 登录失败
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            // 登录成功
            userService.loginTime(username,password);
            // 将登录成功的用户信息保存到 Session 中
            HttpSession session = req.getSession();

            // 设置session有效期为60分钟
            session.setMaxInactiveInterval(60 * 60);

            session.setAttribute(UserConstant.LOGIN_USER, loginUser);
            // 重定向到欢迎页面
            resp.sendRedirect(req.getContextPath() + "/welcome");
        }
    }
}
