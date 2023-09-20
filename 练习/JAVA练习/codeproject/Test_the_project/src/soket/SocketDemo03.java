package soket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class SocketDemo03 {
    static Scanner input  = new Scanner(System.in);
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        InetAddress address;
        try {
            datagramSocket = new DatagramSocket();

            address = InetAddress.getByName("10.0.4.196");
//            address = InetAddress.getLocalHost();
            int port = 8888;

            File file = new File("C:\\Users\\26481\\Pictures\\linux.png");
            FileInputStream fileInputStream = new FileInputStream(file);

            byte[] bytes = fileInputStream.readAllBytes();
            fileInputStream.close();

            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);
            datagramSocket.send(dp);
            System.out.println("发送成功");

            //接受反馈
//            DatagramSocket socket = new DatagramSocket(8191);
//            DatagramPacket packet = new DatagramPacket(new byte[Integer.MAX_VALUE], Integer.MAX_VALUE);
//            socket.receive(packet);
//            String str = new String(packet.getData(), 0, packet.getLength());
//            System.out.println(str);
//            socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            assert datagramSocket != null;
            datagramSocket.close();
        }



    }
}
