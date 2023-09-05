package StatisticalCharacters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * ## 统计字符出现的次数
 *
 * 使用集合统计一段文本中各个字符出现的次数。
 */
public class Statistical {
    public static void main(String[] args) {
        // 初始化一个字符串
//        String str = "Hello, World!";
        String str ="Java collections are a data structure used to store and manipulate a group of objects. The Java Collection Framework consists primarily of two types of containers: Collection and Map. The Collection interface is an abstract class that has many implementations, such as List, Set, and Queue. The Map interface is used to store key-value pairs. Java collections provide methods to manipulate elements in the collection, such as adding, removing, finding, and sorting. The implementation classes of collections (such as ArrayList, HashSet, and LinkedHashMap) also provide rich methods to manipulate data.";
        // 将字符串转换为字符ArrayList
        List<Character> charList = new ArrayList<>();
        for (char c : str.toCharArray()) {
            charList.add(c);
        }
//        // 输出转换后的ArrayList
//        System.out.println(charList);
        HashSet<Character> hashSet = new HashSet<>(charList);
        for (Character i:hashSet){
            Iterator<Character> iterator = charList.iterator();
            int count = 0;
            while (iterator.hasNext()){
                Character character = iterator.next();
                if (i == character){count++;}
            }
            System.out.println(i + "的个数为" + count);
        }
    }
}
