package soket;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Base64;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class SocketDemo03test {
    static final int SINGLE_TRANSFER_NUM = 1;
    public static void main(String[] args) throws SocketException {

        File file = new File("C:\\Users\\26481\\Pictures\\copy.txt");
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file);

                DatagramSocket socket = new DatagramSocket(8888);
        ) {

            //Todo 多次接收解码并写入
            while (true){
                //设置单次传输的容器以及长度
                byte[] singleTransfer = new byte[1024 * SINGLE_TRANSFER_NUM*11];
                DatagramPacket packet = new DatagramPacket(singleTransfer, singleTransfer.length);
                socket.receive(packet);
                String data = new String(packet.getData(),0,packet.getLength());
                //Todo 解析Json
                JSONObject jsonObject = JSONObject.parseObject(data);
//                Gson gson = new Gson();
//                JsonObject jsonObject = gson.fromJson(data,JsonObject.class);

                if (jsonObject.getBoolean("end")){
                    break;
                }
                String string = jsonObject.getString("data");
                byte[] bytes1 = Base64.getDecoder().decode(string);
                //写入流
                fileOutputStream.write(bytes1);
//                fileOutputStream.write(data.getBytes());

            }
            //Todo 反馈接收成功
//            while (true) {
//                socket.receive(packet);
////                socket.getInetAddress();
//                fileOutputStream.write(packet.getData(), 0, packet.getLength());
//                fileOutputStream.close();
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
