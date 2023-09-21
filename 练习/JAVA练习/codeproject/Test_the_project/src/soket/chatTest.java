package soket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class chatTest {
    static final int SINGLE_TRANSFER_NUM = 1;
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            String message = "";
            while (true){
                Socket server = serverSocket.accept();
                InputStream inputStream = server.getInputStream();
                OutputStream outputStream = server.getOutputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String info = null;
                while ((info = bufferedReader.readLine()) != null) {
                    System.out.println("对方发送了"+info);
                }
                //反馈
                message = input.nextLine();
                outputStream.write(message.getBytes());
                server.shutdownOutput();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

