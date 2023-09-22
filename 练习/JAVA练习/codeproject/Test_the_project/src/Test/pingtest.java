package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class pingtest {

    public static void main(String[] args) {
        //查看一下当前系统的编码方式
        //因为是调用系统的ping命令 返回结果是使用系统的编码的
        System.out.println(System.getProperty("sun.jnu.encoding"));
        ;

        String line = null;
        try {
            Process pro = Runtime.getRuntime().exec("ping " + "https://www.ycdledu,com");
            BufferedReader buf = new BufferedReader(new InputStreamReader(
                    pro.getInputStream(), "GBK"));
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
