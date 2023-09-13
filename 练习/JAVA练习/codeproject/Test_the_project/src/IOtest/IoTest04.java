package IOtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class IoTest04 {
    public static void main(String[] args) throws FileNotFoundException {
        //常用两种构造
        FileInputStream in = new FileInputStream("C:\\Users\\26481\\Desktop\\test.txt");
        File file = new File("C:\\Users\\26481\\Desktop\\test.txt");
        FileInputStream input = new FileInputStream(file);
    }
}
