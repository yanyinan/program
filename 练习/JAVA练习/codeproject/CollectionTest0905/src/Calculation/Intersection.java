package Calculation;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

import java.util.HashSet;

/**
 * ## 交集计算
 *
 * 有两个List集合, 计算两个集合的交集元素。
 */
public class Intersection {
    public static void main(String[] args) {
        HashSet set1 = new HashSet<>();
        HashSet set2 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set2.add("b");
        set2.add("c");
        HashSet result = new HashSet<>();
        result.clear();
        result.addAll(set1);
        result.retainAll(set2);
        System.out.println(result);
    }
}
