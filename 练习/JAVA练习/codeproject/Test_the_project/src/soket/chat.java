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
        try{
            String message = "";
            while (true) {
                Socket client = new Socket("localhost",9999);
                InputStream inputStream = client.getInputStream();
                OutputStream outputStream = client.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                message = input.nextLine();
                writer.write(message);
                writer.newLine();
                writer.flush();

                client.shutdownOutput();

                //接收反馈
                String reply = null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while ((reply = bufferedReader.readLine()) != null) {
                    System.out.println("对方回复" + reply);
                }
                client.shutdownInput();
//                client.close();

            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
