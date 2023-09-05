package Calculation;

import java.util.HashSet;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * ## 对称差集运算
 *
 * 有两个List集合, 计算两个集合的对称差集元素。
 */
public class SymmetricDifference {
    public static void main(String[] args) {
        HashSet set1 = new HashSet<>();
        HashSet set2 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set2.add("b");
        set2.add("c");
        set2.add("d");
        HashSet result = new HashSet<>(set1);
        HashSet result2 = new HashSet<>(set1);
        result2.addAll(set1);
        result2.retainAll(set2);
        result.addAll(set2);
        result.removeAll(result2);
        System.out.println(result);
    }
}
