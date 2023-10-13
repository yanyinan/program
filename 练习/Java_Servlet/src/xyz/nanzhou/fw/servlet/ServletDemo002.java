package xyz.nanzhou.fw.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author: Nanzhou
 * @version: v0.0.1
 * @date: 2023 2023/10/13 20:06
 */
@WebServlet(urlPatterns = "/http",
        initParams = {
                @WebInitParam(name = "username", value = "kaifamiao"),
                @WebInitParam(name = "password", value = "a123456")
        })
public class ServletDemo002 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
//         所有初始化参数的名称
//        Enumeration<String> initParameterNames = config.getInitParameterNames();
//        // 迭代
//        while ( initParameterNames.hasMoreElements()){
//            String name = initParameterNames.nextElement();
//            // 获取值
//            String value = config.getInitParameter(name);
//            System.out.println(name + " : " + value);
//        }

        // servlet 上下文对象
//        ServletContext servletContext = config.getServletContext();
//
//        System.out.println(servletContext);

//        ServletRegistration.Dynamic name = servletContext.addServlet("name", ServletDemo002.class);// 动态注册 servlet
//        name.addMapping("/demo");

        // 应用上下文路径
//        String contextPath = servletContext.getContextPath();
//        System.out.println(contextPath); // /web02_war_exploded
//
//        // image/jpeg MIME 类型  image/png image/gif image/bmp text/html text/plain text/css text/javascript
//        String mimeType = servletContext.getMimeType("a.png");// 获取文件的 MIME 类型
//        System.out.println(mimeType); // image/png
//
//        String realPath = servletContext.getRealPath("/");// 获取 web 应用的真实路径
//        System.out.println("/ :" + realPath); // C:\Users\10854\Desktop\note\code\web02\out\artifacts\web02_war_exploded\
//        String realPath1 = servletContext.getRealPath("");
//        System.out.println(" :" + realPath1);
//        String realPath3 = servletContext.getRealPath("/WEB-INF/classes/");
//        System.out.println("/WEB-INF/classes/ :" + realPath3);
//        String realPath2 = servletContext.getRealPath("/a.jpg");
//        System.out.println("/a.jpg :" + realPath2);
//        String realPath4 = servletContext.getRealPath("a.jpg");
//        System.out.println("a.jpg :" + realPath4);
//
//        try {
//            URL resource = servletContext.getResource("a.txt");
//            System.out.println(resource);
//
//            InputStream resourceAsStream = servletContext.getResourceAsStream("a.txt");
//            System.out.println(new String(resourceAsStream.readAllBytes()));
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到 GET 请求");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到 POST 请求");
    }
}
