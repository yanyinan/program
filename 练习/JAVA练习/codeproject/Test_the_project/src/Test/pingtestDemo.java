package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class pingtestDemo {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.jnu.encoding"));
        String name = "云创动力";
        String url = "www.kaifamiao.dev";
        System.out.println(pingStart(name, url));
    }

    /**
     * ping 开关
     * @param name
     * @param url
     */
    public static int pingStart(String name, String url) {
        String line = null;
        String data = "";
        String[] datagroup = new String[0];
        String temp = "";
        temp += name + "(" + url + ")\n";
        int n = 0;
        try {
            Process pro = Runtime.getRuntime().exec("ping " + url);
            BufferedReader buf = new BufferedReader(new InputStreamReader(
                    pro.getInputStream(), "GBK"));
            while ((line = buf.readLine()) != null) {
                data += line + "\n";
            }
            datagroup = data.split("\\n");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return DataIntegration(datagroup,temp);
    }

    /**
     * 数据整合
     * @param datagroup
     * @param temp
     */
    public static int DataIntegration(String[] datagroup, String temp) {
        int n = 0;
        if (datagroup.length > 1) {
            n++;
            temp += datagroup[8] + "\n";
            temp += datagroup[10] + "\n";
        } else {
            temp += "链接失败";
        }
        System.out.println(temp);
//        System.out.println(n);
        return n;
    }
}
