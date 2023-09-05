package Calculation;

import java.util.HashSet;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * ## 差集运算
 *
 * 有两个List集合, 计算第一个集合对第二个集合的差集元素。
 */
public class difference {
    public static void main(String[] args) {
        HashSet set1 = new HashSet<>();
        HashSet set2 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set2.add("b");
        set2.add("c");
        set2.add("d");
        HashSet result = new HashSet<>();
        result.clear();
        result.addAll(set1);
        result.removeAll(set2);
        System.out.println(result);
    }
}
