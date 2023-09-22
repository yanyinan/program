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
        String name = "云创动力";
        String url = "www.kaifamiao.dev";
        work(name,url);
    }

    private static void work(String name, String url) {
        String line = null;
        String data = "";
        try {
            Process pro = Runtime.getRuntime().exec("ping " + url);
            BufferedReader buf = new BufferedReader(new InputStreamReader(
                    pro.getInputStream(), "GBK"));
            while ((line = buf.readLine()) != null) {
                data += line + "\n";
            }
            String[] datagroup = data.split("\\n");
            System.out.println(name + "(" + url + ")");
            if (datagroup.length > 1) {
                System.out.println(data.split("\\n")[8]);
                System.out.println(data.split("\\n")[10]);
            } else {
                System.out.println("链接失败");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
