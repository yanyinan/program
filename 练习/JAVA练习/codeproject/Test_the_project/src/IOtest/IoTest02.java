package IOtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public final class IoTest02 {
    public static void main(String[] args) {
        try (FileInputStream files = new FileInputStream("C:\\Users\\26481\\Desktop\\test.txt")) {
            byte[] size = new byte[1024];
            int tempSize;
            while ((tempSize = files.read(size)) > 0) {
//                这三种方式都是用来将字节数组转换为字符串，但是它们之间存在一些细微的差别：
//
//                1. `System.out.println(new String(size, 0, tempSize, Charset.defaultCharset()));`
//                这是Java默认字符集的转换方式。这种方式会使用JVM默认的字符集来解码字节数组，
//                如果JVM的默认字符集无法正确解码字节数组，那么将会抛出一个UnsupportedEncodingException异常。
//
//                2. `System.out.println(new String(size, 0, tempSize, Charset.forName("utf-8")));`
//                这种方式是使用UTF-8字符集进行转换。这种方式的好处是它明确指定了要使用的字符集，因此在处理特殊字符时会更加准确。
//                但是，如果JVM中没有安装UTF-8字符集，那么这种方式也会抛出UnsupportedEncodingException异常。
//
//                3. `System.out.println(new String(size, 0, tempSize, StandardCharsets.UTF_8));`
//                这种方式是使用Java 7引入的新的字符集工具类StandardCharsets来进行转换。
//                这种方式的好处是它可以避免直接使用字符集名称，从而避免了字符集名称在不同平台之间的差异带来的问题。此外，这种方式还可以处理更多的字符集，包括ISO-8859-1等。

                System.out.println(new String(size, 0, tempSize, Charset.defaultCharset()));
                System.out.println(new String(size, 0, tempSize, Charset.forName("utf-8")));
                System.out.println(new String(size, 0, tempSize, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
