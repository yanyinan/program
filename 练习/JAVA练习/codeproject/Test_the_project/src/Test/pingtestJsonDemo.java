package Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.util.List;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class pingtestJsonDemo {
    public static void main(String[] args) {

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
                String name = website.getString("name");
                String url = website.getString("url").split("https://")[1];
                System.out.println("name: " + name + ", url: " + url);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
