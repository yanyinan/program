import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Exer03 {
    public static void main(String[] args) {
        File file = new File("D:\\now\\note\\练习\\JAVA练习\\codeproject\\Iofiletest\\src\\Exer03test");
        String[] list = file.list();
        Set<String> last = new HashSet<>();
        for (int i = 0; i < list.length; i++) {
            last.add("."+list[i].split("\\.")[1]);
        }
        Iterator<String> it = last.iterator();
        while (it.hasNext()) {
            String temp = it.next();
            // 对每个元素执行的代码
            System.out.println("以 "+temp+" 为后缀的文件有\t"+file.list(((dir, name) -> name.endsWith(temp))).length+"个");
        }
    }
}
