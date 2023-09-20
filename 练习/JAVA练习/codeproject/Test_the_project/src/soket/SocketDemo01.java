package soket;

import java.io.*;
import java.net.Socket;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class SocketDemo01 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",8087);
        OutputStream outputStream = client.getOutputStream();
        InputStream inputStream = client.getInputStream();
        String info = "用户名：adim";
        outputStream.write(info.getBytes());
        client.shutdownOutput();
        String reply = null;
        BufferedReader bufferedReader = new BufferedReader();
        while ((reply = bufferedReader.readLine()) != null){
            System.out.println("客户端，服务器响应的内容"+reply);
        }


    }
}
