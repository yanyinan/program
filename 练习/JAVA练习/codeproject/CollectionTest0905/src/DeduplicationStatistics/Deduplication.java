package DeduplicationStatistics;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

import java.util.HashSet;
import java.util.Vector;

/**
 * ## 去重统计
 *
 * 使用一个List集合存储多个元素。计算集合中共有多少个不重复元素并输出。
 */
public class Deduplication {
    public static void main(String[] args) {
        Vector vector = new Vector<>();
        vector.add("s");
        vector.add("c");
        vector.add("ff");
        vector.add("s");
        vector.add("c");
        vector.add("ff");
        HashSet temp = new HashSet<>();
        for (Object i: vector) {
            temp.add(i);
        }
        System.out.println(temp);
        System.out.println(temp.size());
    }
}
