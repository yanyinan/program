
import java.io.File;
import java.io.IOException;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Exer01 {
    public static void main(String[] args) {
        try {
//            File file = new File("text/io.txt");
            File file = new File("test/test/test/test/test");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.createNewFile()) {
                System.out.println("文件创建成功： " + file.getName());
            } else {
                System.out.println("文件已存在.");
            }
        } catch (IOException e) {
            System.out.println("创建文件时发生错误.");
            e.printStackTrace();
        }
    }
}
