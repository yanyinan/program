package soket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class chatTest {
    static final int SINGLE_TRANSFER_NUM = 1;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8888);

             ) {
            while (true) {
                Socket server = serverSocket.accept();
                InputStream inputStream = server.getInputStream();
                OutputStream outputStream = server.getOutputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String info = null;
                while ((info = bufferedReader.readLine()) != null) {
                    System.out.println(info);
                }

                //反馈
                String reply = "传输成功";
                outputStream.write(reply.getBytes());
                bufferedReader.close();

            }
        }
    }

}

