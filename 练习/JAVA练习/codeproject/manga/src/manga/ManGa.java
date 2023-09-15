package manga;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class ManGa {
    public static void main(String[] args) {
        String url ="https://baozimh.org";
        String urllast = "/manga/chengweikesulushenzhu-yijiansanlian";
        String Url = url + urllast;
        maga(Url, "text",url);
    }

    private static void maga(String url, String name, String urlname) {
        //发送请求
        HttpResponse response = HttpRequest.get(url).execute();
        //响应结果
        String result = response.toString();
//        System.out.println(result);

        //Jsoup 解析 html
        Document document = Jsoup.parse(result);

        //根据元素标记查找元素
        String classElement = document.getElementsByClass("flex justify-center w-full space-x-2 pt-unit-md").toString();
        Document document1 = Jsoup.parse(classElement);
        String classElement1 = document1.getElementsByClass("w-1/2").get(1).toString();
        Document document2 = Jsoup.parse(classElement1);
        Elements classElement2 = document2.getElementsByTag("a");
        String StartUrl = urlname+classElement2.attr("href");
        startmaga(StartUrl);

    }

    private static void startmaga(String startUrl) {
        //发送请求
        HttpResponse startResponse = HttpRequest.get(startUrl).execute();
        //响应结果
        String startResult = startResponse.body();
        //Jsoup 解析 html
        Document document = Jsoup.parse(startResult);

        Element main = document.getElementsByTag("main").get(0);
//        //根据元素标记查找元素
//        String d = document.getElementsByClass("touch-manipulation").toString();
        System.out.println(main);
    }
}
