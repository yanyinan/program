package IOtest;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class IoTest01 {
    public static void main(String[] args) throws IOException {
        FileInputStream file =new FileInputStream("C:\\Users\\26481\\Desktop\\test.txt");
        System.out.println((char) file.read());
        //跳过
        file.skip(4);
        System.out.println((char) file.read());
        //可读
        System.out.println(file.available());

        file.close();

    }
}
