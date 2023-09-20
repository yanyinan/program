package soket;

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
        InetAddress address = null;
        try {
            datagramSocket = new DatagramSocket();

//            address = InetAddress.getByName("10.0.4.139");
            address = InetAddress.getLocalHost();
            int port = 8888;

            String s = "魏春锡"+" "+ address +" "+port;
            byte[] bytes = s.getBytes();
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);
            datagramSocket.send(dp);
            System.out.println("发送成功");
            DatagramSocket socket = new DatagramSocket(8191);
            DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
            socket.receive(packet);
            String str = new String(packet.getData(), 0, packet.getLength());
            System.out.println(str);
            socket.close();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            datagramSocket.close();
        }



    }
}
