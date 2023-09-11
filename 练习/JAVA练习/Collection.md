## 去重统计

使用一个List集合存储多个元素。计算集合中共有多少个不重复元素并输出。

```java
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
```

## 交集计算

有两个List集合, 计算两个集合的交集元素。



```java
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

```

## 差集运算

有两个List集合, 计算第一个集合对第二个集合的差集元素。

```java
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

```

## 对称差集运算

有两个List集合, 计算两个集合的对称差集元素。

```java
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

```



## 并集

有两个List集合, 计算两个集合的并集元素。

```java
package Calculation;

import java.util.HashSet;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class union {
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
        result.addAll(set2);
        System.out.println(result);
    }
}

```

## 移除集合元素

使用Set集合存储多个字符串,移除其中长度为奇数的字符串

```java
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
```

## 统计字符出现的次数

使用集合统计一段文本中各个字符出现的次数。

```java
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

```

