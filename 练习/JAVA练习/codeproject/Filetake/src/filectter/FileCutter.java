package filectter;

import java.io.*;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class FileCutter {
    /**
     * 将指定文件切割为不超过 size 大小的 N 份后，依次序放入到 directory 目录中
     * @param original 被拆分的原始文件
     * @param size 表示被拆分后的单个文件的最大体积
     * @param directory 表示将拆分后的多个文件放入到哪个目录中
     * @return 返回切割后的文件数目
     */
    public int split(final File original, final long size, final File directory) {
        //参数校验
        //被拆分文件参数校验
        if (original == null){
            throw new NullPointerException("参数为空");
        }
        //参数地址是否指向文件
        if (!original.isFile()){
            throw new NullPointerException("未查询到指定文件");
        }
        //目录参数是否为空
        if (directory == null){
            throw new NullPointerException("目录参数为空");
        }
        //校验目录是否存在，不存在创建
        if (!directory.exists()){
            directory.mkdirs();
        }
        // 表示拆分后文件个数的变量
        int n = 0;
        try (FileInputStream file = new FileInputStream(original)){
            //byte[]中最多存储 Integer.MAX_VALUE - 8
            int readSize;
            //判断范围
            if (size <= Integer.MAX_VALUE - 8){
                //单文件大小一个数组能读取到范围
                //初始化bytes
                byte[] bytes = new byte[(int) size];
                //是否读取完
                while (file.available() != 0){
                    //切割文件

                    //1、自定义命名切割文件（合并时需进行排序）
//                    String template = n+".mp4";
//                    File out = new File(directory,template);

                    //2、时间命名切割文件
                    File out = new File(directory,System.currentTimeMillis()+"_file_cuter");
                    //初始化输出流
                    FileOutputStream fis = new FileOutputStream(out);

                    //读取
                    readSize  = file.read(bytes);
                    //写入
                    fis.write(bytes,0, readSize);
                    //文件累加
                    n++;
                    //关闭输出流
                    fis.close();
                }
            }else {
                //一次读取不能完整读取一个文件
                //初始化bytes(此处可初始化内存优化)
                byte[] bytes = new byte[Integer.MAX_VALUE - 8];
                //是否读完
                while ( file.available() != 0){
                    //时间命名切割文件
                    File out = new File(directory,System.currentTimeMillis()+"_file_cuter");
                    //输出流初始化
                    FileOutputStream fis = new FileOutputStream(out);
                    //是否读完
                    while (file.available() != 0){
                        //读取、写入、文件计数累加
                        readSize = file.read(bytes);
                        fis.write(bytes,0,readSize);
                        n++;

                    }
                    //关闭输入流
                    fis.close();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        返回拆分后的文件个数
        return n;
    }

    public static void main(String[] args) {
        FileCutter fc = new FileCutter();
        // 被拆分的文件
        File f = new File("D:\\小练习\\test\\Alec Benjamin - 你的目光 (The Way You Felt).mp4");
        // 表示每个文件体积最大为1MB
        int mb = 1;
        long size = 1024 * 1024 * mb;
        // 拆分后的小文件的存放目录
        File dir = new File("D:\\小练习\\test");
        System.out.println(fc.split(f, size, dir));
    }
}