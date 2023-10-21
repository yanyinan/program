package servlet;

import entity.daoentity.KfmUser;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;


/**
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/21 11:37
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        KfmUser kfmUser = new KfmUser();
        // 获取请求数据
        kfmUser.setName(req.getParameter("nickname"));
        kfmUser.setUsername(req.getParameter("rename"));
        kfmUser.setBirth(Date.valueOf(req.getParameter("birth")));
        kfmUser.setCreateTime(Date.valueOf(LocalDate.now()));
        kfmUser.setPhone(req.getParameter("phone"));
        kfmUser.setEmail(req.getParameter("email"));
        String password = req.getParameter("Registration-password");
        String repassword = req.getParameter("re-Registration-password");
        if (password.equals(repassword)) {
            kfmUser.setPassword(password);
        } else {
            //todo 提示密码错误
            System.out.println("密码输入不一致");
            resp.sendRedirect(req.getContextPath() + "/");
        }
        Boolean registerUser = userService.registerUser(kfmUser);
        if (registerUser){
            System.out.println("用户注册成功，即将返回登录页面");
            resp.sendRedirect(req.getContextPath() + "/");
        }else {
            //todo 提示创建失败
            System.out.println("用户注册失败");
        }
    }

}
