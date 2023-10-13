package xyz.nanzhou.fw.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/13 17:06
 */
@WebServlet(name = "helloServlet", urlPatterns = {"/hello", "/hello1"})
public class ServletDemo001 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service()");
    }
}
