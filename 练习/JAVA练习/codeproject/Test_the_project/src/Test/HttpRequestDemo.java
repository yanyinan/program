package Test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;

public class HttpRequestDemo {
    public static void main(String[] args) {
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
            int n = 0;
            for (int i = 0; i < websites.size(); i++) {
                JSONObject website = websites.getJSONObject(i);
                PingCallble pingCallble = new PingCallble();
                String name = website.getString("name");
                String url = website.getString("url").split("https://")[1];
                int temp = iserver(url);
                if (temp==200) {
                    n++;
                }
                System.out.println(name + "\thttps://" + url + "\t" + temp);
            }
            

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Integer iserver(String s) {
        try (Socket socket = new Socket(s, 80);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            out.println("GET / HTTP/1.1");
            out.println("Host: " + s);
            out.println("Connection: Close");
            out.println();
            String statusLine = in.readLine();
            statusLine = statusLine.split(" ")[1];
            return Integer.parseInt(statusLine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


