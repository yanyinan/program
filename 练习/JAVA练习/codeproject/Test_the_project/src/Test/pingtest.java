package Test;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class pingtest {

    public static void main(String[] args) throws InterruptedException {
        PingCallble pingCallble = new PingCallble();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0 ;i<5;i++){
            Thread.sleep(600);
            System.out.println("第" + i + "次执行");
            poolExecutor.submit(pingCallble);
        }


    }
}
class PingCallble implements Callable{

    @Override
    public Object call() throws Exception {
        String name = "云创动力";
        String url = "www.kaifamiao.dev";
        return pingStart(name,url);
    }
    /**
     * ping 开关
     * @param name
     * @param url
     */
    private  int pingStart(String name, String url) {
        String line = null;
        String data = "";
        String[] datagram = new String[0];
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
            datagram = data.split("\\n");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return DataIntegration(datagram,temp);
    }

    /**
     * 数据整合
     * @param datagram 待整合字符串数组
     * @param temp 字符串
     * @return
     */
    private  int DataIntegration(String[] datagram, String temp) {
        int n = 0;
        if (datagram.length > 1) {
            n++;
            temp += datagram[8] + "\n";
            temp += datagram[10] + "\n";
        } else {
            temp += "链接失败";
        }
        System.out.println(temp);
        System.out.println(n);
        return n;
    }

}
