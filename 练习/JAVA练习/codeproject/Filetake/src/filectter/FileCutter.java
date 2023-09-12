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
        // 表示拆分后文件个数的变量
        int n = 0;
        try {
            byte[] bytes = new byte[(int) size];
            FileInputStream file = new FileInputStream(original);
            FileOutputStream fileos = null;
            int temp ;
            while ((temp = file.read(bytes))>0){
                String tempname = directory+"/"+n+".mp4";
                new File(tempname).createNewFile();
                fileos = new FileOutputStream(tempname);
                fileos.write(bytes,0,temp);
                n++;
            }
            file.close();
            fileos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        返回拆分后的文件个数
        return n;
    }
    public static void main(String[] args) {
        FileCutter fc = new FileCutter();
        // 被拆分的文件
        File f = new File("D:\\小练习\\test\\coverr-a-man-makes-a-ponytail-4655-1080p.mp4");
        // 表示每个文件体积最大为1MB
        long size = 1024 * 1024 * 1;
        // 拆分后的小文件的存放目录
        File dir = new File("D:\\小练习\\test");
        fc.split(f, size, dir);
    }
}