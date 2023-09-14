import java.io.File;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Excer04 {
    public static void main(String[] args) {
        File filesize = new File("D:\\now\\note\\练习\\JAVA练习\\codeproject\\Iofiletest\\src\\Exer03test");
        Long count = calculateFolderSizeRecursively(filesize);
        System.out.println(count);
    }
    private static long calculateFolderSizeRecursively(File folder) {
        long size = 0;
//
//        if (folder.isDirectory()) {
//            // 如果是文件夹，递归计算其子文件和子文件夹的大小
//            File[] files = folder.listFiles();
//            if (files != null) {
//                for (File file : files) {
//                    size += calculateFolderSizeRecursively(file);
//                }
//            } else {
//                // 如果是空文件夹，返回0
//                size = 0;
//            }
//        } else {
//            // 如果是文件，获取其大小
//            size = folder.length();
//        }

        return size;
    }
}
