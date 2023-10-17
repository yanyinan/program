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
 * @date: 2023 2023/10/16 17:26
 */
@WebServlet("/index")
public class RequestDemo002 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("http://localhost:8080/Java_Servlet_war_exploded/index.html");
    }
}
