package demo01.web.servlet;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.utils.CaptchaUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CaptchaServlet 用于生成验证码
 * @author 26481
 */
@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GifCaptcha gifCaptcha = new GifCaptcha(100, 48, 4);
        CaptchaUtil.out(gifCaptcha, req, resp);
    }
}
