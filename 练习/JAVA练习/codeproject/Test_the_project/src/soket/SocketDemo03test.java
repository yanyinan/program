package soket;

import java.io.File;
import java.io.FileOutputStream;
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
        DatagramPacket packet = new DatagramPacket(new byte[1024*11],1024*11);
        try(DatagramSocket socket = new DatagramSocket(8888)) {

            while (true){

                socket.receive(packet);

                File file = new File("C:\\Users\\26481\\Pictures\\copy.png");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(packet.getData(),0, packet.getLength());
                fileOutputStream.close();

//                String str = new String(packet.getData(), 0, packet.getLength());
//
//                System.out.println(str);
//                byte[] bytes = "接收成功".getBytes();
//                String[] strings = str.split(" ");
//                //Todo
//                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName(strings[1].split("/")[1]), 8191);
//                socket.send(dp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
