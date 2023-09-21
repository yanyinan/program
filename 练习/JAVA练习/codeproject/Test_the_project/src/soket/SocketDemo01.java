package soket;

import com.google.gson.JsonObject;

import java.io.*;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Base64;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class SocketDemo01 {
    static final int SINGLE_TRANSFER_NUM = 1;
    public static void main(String[] args) {
        File file = new File("C:\\Users\\26481\\Pictures\\linux.jpg");
        try(Socket client = new Socket("localhost",8888);
            OutputStream outputStream = client.getOutputStream();
            InputStream inputStream = client.getInputStream();
            FileInputStream fileInputStream = new FileInputStream(file);) {
//            多次次传输
//            设置单次传输的容器以及长度
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
                outputStream.write(stringTransferJson.getBytes());

            }
//            outputStream.write(fileInputStream.readAllBytes());

            //阻塞等待接收
            client.shutdownOutput();

            //接收反馈
            String reply = null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((reply = bufferedReader.readLine()) != null){
                System.out.println(reply);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
