package soket;

import com.google.gson.JsonObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class chat {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        try(Socket client = new Socket("localhost",8888);
            OutputStream outputStream = client.getOutputStream();
            InputStream inputStream = client.getInputStream();
           ) {
            String str = "";
            while (true) {

//                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
//                String message = input.nextLine();
//                writer.write(message);
//                writer.newLine();
//                writer.flush();
//                //发送
                str = input.nextLine();
                outputStream.write(str.getBytes());
                outputStream.flush();
//               //阻塞等待接收
                client.shutdownOutput();


                //接收反馈
                String reply = null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while ((reply = bufferedReader.readLine()) != null) {
                    System.out.println("对方回复" + reply);
                }


//                client.shutdownInput();
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
