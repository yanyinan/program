import java.io.File;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Exer02 {
    public static void main(String[] args) {
        // 要删除的文件夹路径
        String folderPath = "D:\\now\\note\\练习\\JAVA练习\\codeproject\\Iofiletest\\test";
        File folder = new File(folderPath);
        deleteFolderRecursively(folder);
    }

    private static void deleteFolderRecursively(File folder) {
        if (folder.isDirectory()) {
            // 文件夹，递归删除其子文件和子文件夹
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteFolderRecursively(file);
                }
            }
        }
        // 删除空文件夹或文件
        folder.delete();
    }
}
