package soket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class SocketDemo03test {
    public static void main(String[] args) throws SocketException {
        DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
        DatagramSocket socket = new DatagramSocket(8888);
        try {
            while (true){
                socket.receive(packet);
                String str = new String(packet.getData(), 0, packet.getLength());
                System.out.println(str);
                byte[] bytes = "接收成功".getBytes();
                String[] strings = str.split(" ");
                System.out.println(Integer.parseInt(strings[2]));
                System.out.println(InetAddress.getByName(strings[1].split("10")[1]));
//                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(strings[1].split("/")[1]), Integer.parseInt(strings[2]));
//                socket.send(dp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            socket.close();
        }

    }
}
