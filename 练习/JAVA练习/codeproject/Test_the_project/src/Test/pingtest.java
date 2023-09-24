package Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class pingtest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        int n = 1;
        while (true){
            System.out.println("\n\n第" + (n++) + "次请求");
            poolExecutor.submit(new pingRunable());
            Thread.sleep(6000);
        }

    }
}
class pingRunable implements Runnable{

    @Override
    public void run() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        File file = new File("C:\\Users\\26481\\Desktop\\git_up\\progrmstudynote\\练习\\JAVA练习\\codeproject\\Test_the_project\\src\\Test\\test.json");
        try (FileInputStream fileInputStream = new FileInputStream(file);) {
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
            String line = null;
            String data = "";
            while ((line = br.readLine()) != null) {
                data += line;
            }
            JSONObject jsonObject = JSON.parseObject(data);
            JSONArray websites = jsonObject.getJSONArray("websites");
            //计数器
            int n =0;
            for (int i = 0; i < websites.size(); i++) {
                JSONObject website = websites.getJSONObject(i);
                PingCallble pingCallble = new PingCallble();
                String name = website.getString("name");
                String url = website.getString("url");
                pingCallble.setName(name);
                pingCallble.setUrl(url);
                FutureTask<String[]> futureTask = new FutureTask<>(pingCallble);
                poolExecutor.submit(futureTask);
                System.out.println(futureTask.get()[0]);
                n+= Integer.parseInt(futureTask.get()[1]);
            }
            System.out.println("\n本次OK: " + n + "次\n本次ERROR: " + (websites.size() - n) + "\n成功率： " + ((double) n / websites.size() * 100) + "%");
        } catch (ExecutionException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
class PingCallble implements Callable<String[]> {
    private String name = "";
    private String url = "";

    @Override
    public String[] call() throws Exception {
        String temp = iserver(url);
        int n = 0;
        if ( Integer.parseInt(temp.split(" ")[0])==200) {
            n ++;
        }else {
            temp = "ERROR "+temp.split(" ")[1];
        }
        String[] strings = {name + "\t(" + url + ")\t" + temp, String.valueOf(n)};
        return strings;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    private static String iserver(String s) {
        s = s.split("https://")[1];
        try (Socket socket = new Socket(s, 80);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            // 记录开始时间
            long startTime = System.currentTimeMillis();
            out.println("GET / HTTP/1.1");
            out.println("Host: " + s);
            out.println("Connection: Close");
            out.println();
            // 发送HTTP请求并读取响应数据
            String statusLine = in.readLine();
            statusLine = statusLine.split(" ")[1];
            // 记录结束时间
            long endTime = System.currentTimeMillis();

            // 计算访问速度（单位为字节/秒）
            double speed = (double) (endTime - startTime) / statusLine.length();

            return String.format("%s %.2f秒", statusLine, speed);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//class PingCallble implements Callable<Integer> {
//
//    private String name = "";
//    private String url = "";
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    @Override
//    public Integer call() throws Exception {
//        return pingStart(name,url);
//    }
//
//    /**
//     * ping 开关
//     *
//     * @param name
//     * @param url
//     */
//    private int pingStart(String name, String url) {
//        String line = null;
//        String data = "";
//        String[] datagram = new String[0];
//        String temp = "";
//        temp += name + "(" + url + ")\n";
//        int n = 0;
//        try {
//            Process pro = Runtime.getRuntime().exec("ping " + url);
//            BufferedReader buf = new BufferedReader(new InputStreamReader(
//                    pro.getInputStream(), "GBK"));
//            while ((line = buf.readLine()) != null) {
//                data += line + "\n";
//            }
//            datagram = data.split("\\n");
//
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return DataIntegration(datagram, temp);
//    }
//
//    /**
//     * 数据整合
//     *
//     * @param datagram 待整合字符串数组
//     * @param temp     字符串
//     * @return
//     */
//    private int DataIntegration(String[] datagram, String temp) {
//        int n = 0;
//        if (datagram.length > 1) {
//            n++;
//            temp += datagram[8] + "\n";
//            temp += datagram[10] + "\n";
//        } else {
//            temp += "链接失败";
//        }
//        System.out.println(temp);
//        return n;
//    }
//}

