package soket;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class SocketDemo01Server {
    static final int SINGLE_TRANSFER_NUM = 1;
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\26481\\Pictures\\copy.png");
        try (ServerSocket serverSocket = new ServerSocket(1231);
             Socket server = serverSocket.accept();
             InputStream inputStream = server.getInputStream();
             OutputStream outputStream = server.getOutputStream();
             FileOutputStream fileOutputStream = new FileOutputStream(file,true);) {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            while (true){
//                //设置单次传输的容器以及长度
//                byte[] singleTransfer = new byte[1024 * SINGLE_TRANSFER_NUM*11];
//
//                String data = new String();
//                //Todo 解析Json
//                JSONObject jsonObject = JSONObject.parseObject(data);
////                Gson gson = new Gson();
////                JsonObject jsonObject = gson.fromJson(data,JsonObject.class);
//
//                if (jsonObject.getBoolean("end")){
//                    break;
//                }
//                String string = jsonObject.getString("data");
//                byte[] bytes1 = Base64.getDecoder().decode(string);
//                //写入流
//                fileOutputStream.write(bytes1);
//
//            }
            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
//                JSONObject jsonObject = JSONObject.parseObject(info);
//                String string = jsonObject.getString("data");
////                byte[] bytes1 = Base64.getDecoder().decode(string);
////                //写入流
//                fileOutputStream.write(string.getBytes());
                System.out.println(info);
//                fileOutputStream.write(info.getBytes());
            }
            //反馈
            String reply = "传输成功";
            outputStream.write(reply.getBytes());
            bufferedReader.close();
        }

    }
}
