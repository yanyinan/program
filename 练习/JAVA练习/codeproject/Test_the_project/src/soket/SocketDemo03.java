package soket;

import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.Base64;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class SocketDemo03 {
    static final int SINGLE_TRANSFER_NUM = 1;

    public static void main(String[] args) {
        InetAddress address;
        //指定文件流
        File file = new File("C:\\Users\\26481\\Pictures\\linux.png");
        try (DatagramSocket datagramSocket = new DatagramSocket();
             FileInputStream fileInputStream = new FileInputStream(file);) {

            //指定 IP
//            address = InetAddress.getByName("10.0.4.196");
            //指定本地 IP
            address = InetAddress.getLocalHost();

            //指定端口
            int port = 8888;

            //次传输
            //设置单次传输的容器以及长度
            byte[] singleTransfer = new byte[1024 * SINGLE_TRANSFER_NUM];
            int transferlength = 0;
            //多次传输读取判断
            while ((transferlength = fileInputStream.read(singleTransfer)) != -1) {
                //使用Json文件格式进行传输（传输内容包括：发送端口 Ip 传输内容 是否结束）
                //创建 Json 对象
                JsonObject transferJson = new JsonObject();
                //加载数据
                transferJson.addProperty("end", false);
                transferJson.addProperty("data", Base64.getEncoder().encodeToString(Arrays.copyOf(singleTransfer, transferlength)));
//                transferJson.addProperty("Ip", String.valueOf(address));
//                transferJson.addProperty("port",port);
                String stringTransferJson = transferJson.toString();
                //发送
                DatagramPacket packet = new DatagramPacket(stringTransferJson.getBytes(), stringTransferJson.getBytes().length, address, port);
                datagramSocket.send(packet);
            }
            // 告诉服务端发送结束
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("end", true);
            jsonObject.addProperty("data", "");
            String string = jsonObject.toString();
            DatagramPacket packet = new DatagramPacket(string.getBytes(), string.getBytes().length, address, port);
            datagramSocket.send(packet);
            System.out.println("发送成功");
            //Todo 传输反馈

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
