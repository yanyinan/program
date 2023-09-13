package IOtest;

import java.io.FileInputStream;
import java.io.IOException;


/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class IoTest03 {
    public static void main(String[] args) {
        try (FileInputStream files = new FileInputStream("C:\\Users\\26481\\Desktop\\test.txt")) {
            byte[] bytes = files.readAllBytes();
            //readAllBytes() 读取所有的字节（最大为 Integer.MAX_VALUE 个字节）
            System.out.println(new String(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

