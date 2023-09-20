package soket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class SocketDemo03 {
    public static void main(String[] args) {
        InetAddress address;
        //指定文件流
        File file = new File("C:\\Users\\26481\\Pictures\\linux.png");
        try( DatagramSocket datagramSocket = new DatagramSocket();
             FileInputStream fileInputStream = new FileInputStream(file);) {

            //指定 IP
            address = InetAddress.getByName("10.0.4.196");
            //指定当前下标
            //address = InetAddress.getLocalHost();

            //指定端口
            int port = 8888;

            //
            //传输字节数组容器
            byte[] bytes = fileInputStream.readAllBytes();
            //字节数组打包
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);
            //发送
            datagramSocket.send(dp);
            System.out.println("发送成功");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
