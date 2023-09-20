package soket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class SocketDemo01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8087);
        Socket server = serverSocket.accept();

        InputStream inputStream = server.getInputStream();
        OutputStream outputStream = server.getOutputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String info = null;
        while ((info = bufferedReader.readLine()) != null){
            System.out.println("服务端，客户响应的内容"+info);
        }
//        String reply = "登录成功";
//
//        outputStream.write(reply.getBytes());
//
        bufferedReader.close();
        inputStream.close();
        outputStream.close();
        serverSocket.close();
        server.close();
    }
}
