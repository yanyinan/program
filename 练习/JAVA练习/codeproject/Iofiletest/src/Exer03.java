import java.io.File;
import java.util.*;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Exer03 {
    public static void main(String[] args) {
        File file = new File("D:\\now\\note\\练习\\JAVA练习\\codeproject\\Iofiletest\\src\\Exer03test");
        File[] files = file.listFiles(File::isFile);
        Map<String,Integer> strings = new HashMap<>();
        for (File f : files){
            String key = f.getName().substring(f.getName().lastIndexOf("."));
            strings.put(key, strings.getOrDefault(key,0)+1);
        }
        strings.forEach((key,value)-> System.out.println(" 后缀 "+value+" 个"));
    }
}
