package Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.concurrent.*;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class pingtest {

    public static void main(String[] args)  {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        File file = new File("C:\\Users\\26481\\Desktop\\git_up\\progrmstudynote\\练习\\JAVA练习\\codeproject\\Test_the_project\\src\\Test\\test.json");
        try(FileInputStream fileInputStream = new FileInputStream(file);){
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
            String line = null;
            String data ="";
            while ((line = br.readLine()) != null) {
                data+=line;
            }
            JSONObject jsonObject = JSON.parseObject(data);
            JSONArray websites = jsonObject.getJSONArray("websites");
            for (int i = 0; i < websites.size(); i++) {
                JSONObject website = websites.getJSONObject(i);
                PingCallble pingCallble = new PingCallble();
                String name = website.getString("name");
                String url = website.getString("url").split("https://")[1];
                pingCallble.setName(name);
                pingCallble.setUrl(url);
//                FutureTask<Integer> futureTask = new FutureTask<>(pingCallble);
                poolExecutor.submit(pingCallble);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
class PingCallble implements Callable<Integer> {

    private String name = "";
    private String url = "";

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Integer call() throws Exception {
        return pingStart(name,url);
    }

    /**
     * ping 开关
     *
     * @param name
     * @param url
     */
    private int pingStart(String name, String url) {
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
        return DataIntegration(datagram, temp);
    }

    /**
     * 数据整合
     *
     * @param datagram 待整合字符串数组
     * @param temp     字符串
     * @return
     */
    private int DataIntegration(String[] datagram, String temp) {
        int n = 0;
        if (datagram.length > 1) {
            n++;
            temp += datagram[8] + "\n";
            temp += datagram[10] + "\n";
        } else {
            temp += "链接失败";
        }
        System.out.println(temp);
        return n;
    }
}

