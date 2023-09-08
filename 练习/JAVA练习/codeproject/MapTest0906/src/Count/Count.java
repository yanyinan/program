package Count;

import java.util.*;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * ## 统计数量
 *
 * 输入一个字符串，统计字符串中每个字符出现的次数并输出
 */
public class Count {
    public static void main(String[] args) {
        // 初始化一个字符串
//        String str = "Hello, World!";
        String str ="Java collections are a data structure used to store " +
                "and manipulate a group of objects. The Java Collection Framewor" +
                "k consists primarily of two types of containers: Collection and Map. " +
                "The Collection interface is an abstract class that has many implementations, " +
                "such as List, Set, and Queue. The Map interface is used to store key-value pairs." +
                " Java collections provide methods to manipulate elements in the collection, such as " +
                "adding, removing, finding, and sorting. The implementation classes of collections (such as" +
                " ArrayList, HashSet, and LinkedHashMap) also provide rich methods to manipulate data.";
        // 将字符串转换为HashMap<Character,Integer>
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
//            if (hashMap.containsKey(c)){
//                hashMap.put(c,hashMap.get(c)+1);
//            }else hashMap.put(c,1);
        }
//        System.out.println(hashMap);
        Set<Character> set = hashMap.keySet();
        set.forEach(character -> System.out.println("字符 " + character + " 有 " + hashMap.get(character)));
//        Iterator<Character> setIterator = set.iterator();
//        while (setIterator.hasNext()){
//            char next = setIterator.next();
//            System.out.println("字符 " + next + " 有 " + hashMap.get(next));
//        }
    }
}
