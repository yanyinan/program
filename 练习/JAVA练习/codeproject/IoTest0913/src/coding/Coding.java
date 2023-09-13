package coding;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Coding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        File src = new File("E:\\bag\\IoTest0913\\src\\test\\test.txt");
        File origin = new File("E:\\bag\\IoTest0913\\src\\test\\testing.txt");

        transferEncodingByByte(src, Charset.forName("utf8"), origin, Charset.forName("gbk"));
    }

    /**
     *
     *  将 src 转换为 originCharset 编码的文件保存到 origin文件中
     *    步骤：
     *      1. 创建转换流对象，构造方法中传递字节输入流和指定的编码表名称
     *      2. 读取文本内容，转换为 originCharset 编码的字节数组
     *      3. 使用输出流将其输出到 origin
     *
     * @param src  源文件
     * @param srcCharset  源文件的编码
     * @param origin     目标文件
     * @param originCharset  目标文件的编码
     * @return
     */
    public static boolean transferEncoding(File src, String srcCharset, File origin, String originCharset){
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(src), srcCharset);
             FileOutputStream fos = new FileOutputStream(origin);){


            char[] chars = new char[1024];

            int size;
            while ( (size = isr.read(chars)) != -1){
                // 获取指定编码的字节（内容）
                byte[] bytes = new String(chars, 0, size).getBytes(originCharset);

                fos.write(bytes);
            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static boolean transferEncodingByByte(File src, Charset srcCharset, File origin, Charset originCharset){
        try(FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(origin);
        ) {

            byte[] bytes = new byte[1024];
            int size;
            while((size = fis.read(bytes)) != -1){
                /*
                  核心: 拿到所表示内容的字符串，然后获取其指定编码的 byte 数组就行可以了
                 */
                String s = new String(bytes, 0, size, srcCharset);

                byte[] bytes1 = s.getBytes(originCharset);
                fos.write(bytes1);
            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
