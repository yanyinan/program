package RemoveCollection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * ## 移除集合元素
 *
 * 使用Set集合存储多个字符串,移除其中长度为奇数的字符串
 */
public class Remove {
    public static void main(String[] args) {
        TreeSet<String> treeSet =new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        treeSet.add("a");
        treeSet.add("aa");
        treeSet.add("aaa");
        System.out.println(treeSet);
        hashSetremove(treeSet);
        System.out.println(treeSet);
    }

    private static void hashSetremove(TreeSet<String> hashSet) {
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            String temp = iterator.next();
            if (temp.length() % 2 != 0) {
                iterator.remove();
            }
        }
    }
}
