package soket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class uppchat {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int port = 8888;
        try {
            while (true){
                String Ip = String.valueOf(InetAddress.getLocalHost());
                Socket send = new Socket("localhost",port);
//                InputStream sendInput = send.getInputStream();

                String message = "";
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(send.getOutputStream()));
                message = input.nextLine();
                writer.write(message);
                writer.newLine();
                writer.flush();

                send.shutdownOutput();

                //接收反馈
                String reply = null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(send.getInputStream()));
                while ((reply = bufferedReader.readLine()) != null) {
                    System.out.println("对方回复" + reply);
                }
                send.shutdownInput();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
