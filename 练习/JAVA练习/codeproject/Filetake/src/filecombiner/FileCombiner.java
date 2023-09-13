package filecombiner;

import java.io.*;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class FileCombiner {
    /**
     * 将指定目录中的多个文件片段依次序合并到同一个文件中，并返回合并后的文件体积
     *
     * @param dir    存放文件片段的目录(即拆分文件后的N个小文件的存放目录)
     * @param target 表示合并后的文件的存放路径
     * @return 返回合并后的文件体积
     */
    public long join(final File dir, final File target) {
        // 声明用于统计合并后的文件体积的变量
        long size = 0;
        //参数校验
        //参数传递为空判断
        if (dir == null) {
            throw new NullPointerException("目录参数为空");
        }
        if (target == null) {
            throw new NullPointerException("传递参数为空");
        }
        //文件目录是否存在，不存在创建
        if (!target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
        }
        //初始化输出流
        try (FileOutputStream files = new FileOutputStream(target)) {
            //合并文件
            File[] dirfile = dir.listFiles((file, name) -> name.endsWith("_file_cuter"));

            //判断合并文件是否为空
            if (dirfile != null) {
                //遍历文件片段
                for (File file : dirfile) {

                    if (file.length() <= Integer.MAX_VALUE - 8) {
                        //一次完全读取
                        //初始化输入流
                        FileInputStream fis = new FileInputStream(file);
                        //读取计数器
                        int temp;
                        //初始化bytes
                        byte[] bytes = new byte[(int) file.length()];
                        //读取写入
                        while ((temp = fis.read(bytes)) > 0) {
                            files.write(bytes, 0, temp);
                        }
                        //关闭输入流
                        fis.close();
                        //大小计数
                        size += file.length();
                    } else {
                        //一次不能完全读取
                        //输入流定义
                        FileInputStream fis = new FileInputStream(file);
                        //读取计数器
                        int temp;
                        //初始化bytes
                        byte[] bytes = new byte[Integer.MAX_VALUE - 8];
                        //判断读取是否完成
                        while (fis.available() > 0) {
                            //读取
                            temp = fis.read(bytes);
                            //写入
                            files.write(bytes, 0, temp);
                        }
                        //关闭输入流
                        fis.close();
                        //大小计数
                        size += file.length();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 返回合并后的文件体积
        return size;
    }

    public static void main(String[] args) {
        FileCombiner fc = new FileCombiner();
        // 文件片段所在的目录
        File dir = new File("D:\\小练习\\test");
        // 合并后的文件存放路径和名
        File target = new File("D:\\小练习\\test\\Alec Benjamin - 你的目光 (The Way You Felt)copy.mp4");
        long n = fc.join(dir, target);
        System.out.println(n);
    }
}