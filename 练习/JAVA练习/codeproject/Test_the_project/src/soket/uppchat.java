package soket;

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
        String Ip = InetAddress.getAllByName("Localhost");
        int port = 8888;
        Socket send = new Socket(Ip,port)
    }
}
