package soket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class SocketDemo02 {
//    public static void main(String[] args) throws IOException {
//// 1. 创建接收端Socket对象(MulticastSocket)
//        MulticastSocket ms = new MulticastSocket(10000);
//// 2. 创建一个箱子,用于接收数据
//        DatagramPacket dp = new DatagramPacket(new byte[1024],1024);
//// 3. 把当前计算机绑定一个组播地址,表示添加到这一组中.
//        ms.joinGroup(InetAddress.getByName("224.0.1.0"));
//// 4. 将数据接收到箱子中
//        ms.receive(dp);
//// 5. 解析数据包,并打印数据
//        byte[] data = dp.getData();
//        int length = dp.getLength();
//        System.out.println(new String(data,0,length));
//// 6. 释放资源
//        ms.close();
//    }

    public static void main(String[] args) throws IOException {
        // 1. 创建接收端的Socket对象(DatagramSocket)
        DatagramSocket ds = new DatagramSocket(10000);
        // 2. 创建一个数据包，用于接收数据
        DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
        // 3. 调用DatagramSocket对象的方法接收数据
        ds.receive(dp);
        // 4. 解析数据包，并把数据在控制台显示
        byte[] data = dp.getData();
        int length = dp.getLength();
        System.out.println(new String(data, 0, length));
        // 5. 关闭接收端
        ds.close();
    }
}

