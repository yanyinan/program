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
        try {
            File[] dirfile = dir.listFiles();
            int n = 0;
            FileOutputStream fileos = new FileOutputStream(target.getPath());

            long siz = 1024 * 1024 * 1;
            for (File file : dirfile) {
                String tempname = dir + "/" + n + ".mp4";

                System.out.println(file.isFile() && file.getName().equals(n+".mp4"));
                if (file.getName().equals(n+".mp4")) {
                    try(FileInputStream fis = new FileInputStream(tempname);) {
                        byte[] bytes = new  byte[(int) siz];
                        int temp ;
                        while ((temp = fis.read(bytes))>1){
                            fileos.write(bytes,0,temp);
                        }
                        size += file.length();
                    }

                }n++;
            }
            fileos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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
        File target = new File("D:\\小练习\\test\\cover-a-man-makes-a-ponytail-4655-1080copy.mp4");
        long n = fc.join(dir, target);
        System.out.println(n);
    }
}