## Map基本操作

创建一个Map，完成以下操作：

- 将我国省份和其简称存到 Map 集合中
- 将省份名称中包含"江"的省份从集合中删除
- 遍历输出集合元素

```java
package Province;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Province {
    public static void main(String[] args) {
        // 创建一个Map集合来存储中国省份和其简称
        Map<String, String> provinces = new HashMap<>();

        // 将我国省份和其简称存到 Map 集合中
        provinces.put("北京", "京");
        provinces.put("天津", "津");
        provinces.put("上海", "沪");
        provinces.put("重庆", "渝");
        provinces.put("河北", "冀");
        provinces.put("山西", "晋");
        provinces.put("辽宁", "辽");
        provinces.put("吉林", "吉");
        provinces.put("黑龙江", "黑");
        provinces.put("江苏", "苏");
        provinces.put("浙江", "浙");
        provinces.put("安徽", "皖");
        provinces.put("福建", "闽");
        provinces.put("江西", "赣");
        provinces.put("山东", "鲁");
        provinces.put("河南", "豫");
        provinces.put("湖北", "鄂");
        provinces.put("湖南", "湘");
        provinces.put("广东", "粤");
        provinces.put("海南", "琼");
        provinces.put("四川", "川");
        provinces.put("贵州", "黔");
        provinces.put("云南", "滇");
        provinces.put("陕西", "陕");
        provinces.put("甘肃", "甘");
        provinces.put("青海", "青");
        provinces.put("台湾", "台");
        provinces.put("内蒙古", "蒙");
        provinces.put("广西", "桂");
        provinces.put("西藏", "藏");
        provinces.put("宁夏", "宁");
        provinces.put("新疆", "新");
        provinces.put("香港", "港");
        provinces.put("澳门", "澳");
//        String regex = "^江";
//        Pattern p = Pattern.compile(regex);
////         keySet
//        Set<String> strings = provinces.keySet();
//        Iterator<String> iterator = strings.iterator();
//        // 打印出所有的省份和简称
//        while (iterator.hasNext()) {
//            String key = iterator.next();
//            Matcher matcher = p.matcher(key);
//            if (matcher.find()) {
//                iterator.remove();
////                System.out.println("out");
//            } else {
//                System.out.println("省份：" + key + "，简称：" + provinces.get(key));
//            }
////            System.out.println(key + " = " + provinces.get(key));
//        }
//        keySet
        Set<Map.Entry<String, String>> strings = provinces.entrySet();
        strings.removeIf(stringStringEntry -> stringStringEntry.getKey().contains("江"));
//        System.out.println(provinces);
        strings.forEach(stringStringEntry -> System.out.println("省份：" + stringStringEntry.getKey() + "，简称：" + stringStringEntry.getValue()));
//        provinces.forEach((key,value)->System.out.println("省份：" + key + "，简称：" + value));
//        for (Map.Entry<String,String> e : strings){
//            System.out.println("省份：" + e.getKey() + "，简称：" + e.getValue());
//        }

    }
}



```

## 统计数量

输入一个字符串，统计字符串中每个字符出现的次数并输出

```java
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

```

## 摩尔斯密码

国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如:

'a' 对应 ".-" ，
'b' 对应 "-..." ，
'c' 对应 "-.-." ，以此类推。
为了方便，所有 26 个英文字母的摩尔斯密码表如下：

```
[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
```

给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。

例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻译 。
对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量

示例 1：

```
输入: words = ["gin", "zen", "gig", "msg"]
输出: 2
解释: 
各单词翻译如下:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

共有 2 种不同翻译, "--...-." 和 "--...--."
```




示例 2：

```
输入：words = ["a"]
输出：1
```

**提示：**

- `1 <= words.length <= 100`
- `1 <= words[i].length <= 12`
- `words[i]` 由小写英文字母组成



```java
package Morse;


import java.util.HashMap;
import java.util.Map;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * ## 摩尔斯密码
 *
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如:
 *
 * 'a' 对应 ".-" ，
 * 'b' 对应 "-..." ，
 * 'c' 对应 "-.-." ，以此类推。
 * 为了方便，所有 26 个英文字母的摩尔斯密码表如下：
 *
 * ```
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * ```
 *
 * 给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
 *
 * 例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻译 。
 * 对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量
 *
 * 示例 1：
 *
 * ```
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * 共有 2 种不同翻译, "--...-." 和 "--...--."
 * ```
 *
 *
 *
 *
 * 示例 2：
 *
 * ```
 * 输入：words = ["a"]
 * 输出：1
 * ```
 *
 * **提示：**
 *
 * - `1 <= words.length <= 100`
 * - `1 <= words[i].length <= 12`
 * - `words[i]` 由小写英文字母组成
 */
public class Morse {
    private static final Map<Character, String> morseCodeMap = new HashMap<>();//密码本容器
    static {//静态初始化莫尔斯编码
        morseCodeMap.put('a', ".-");
        morseCodeMap.put('b', "-...");
        morseCodeMap.put('c', "-.-.");
        morseCodeMap.put('d', "-..");
        morseCodeMap.put('e', ".");
        morseCodeMap.put('f', "..-.");
        morseCodeMap.put('g', "--.");
        morseCodeMap.put('h', "....");
        morseCodeMap.put('i', "..");
        morseCodeMap.put('j', ".---");
        morseCodeMap.put('k', "-.-");
        morseCodeMap.put('l', ".-..");
        morseCodeMap.put('m', "--");
        morseCodeMap.put('n', "-.");
        morseCodeMap.put('o', "---");
        morseCodeMap.put('p', ".--.");
        morseCodeMap.put('q', "--.-");
        morseCodeMap.put('r', ".-.");
        morseCodeMap.put('s', "...");
        morseCodeMap.put('t', "-");
        morseCodeMap.put('u', "..-");
        morseCodeMap.put('v', "...-");
        morseCodeMap.put('w', ".--");
        morseCodeMap.put('x', "-..-");
        morseCodeMap.put('y', "-.--");
        morseCodeMap.put('z', "--..");
        morseCodeMap.put(' ', "/"); // 空格用"/"表示
    }

    /**
     *输出相同个数
     * @param words 单词本
     * @return 长度相同个数
     */
    private static int MorseMach(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char[] chars =  words[i].toCharArray();
            String strTemp = "";
            for(char ch :chars){
                strTemp += morseCodeMap.get(ch);
            }
            map.put(strTemp,map.getOrDefault(strTemp,0)+1);
        }
//        System.out.println(map);
        return map.size();
    }
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(MorseMach(words));
    }
}

```

## 以下代码输出的结果是什么？为什么？

```java
public static void main(String[] args) {
    Map<Short, String> map = new HashMap<>();
    for (short i = 0; i < 100; i ++){
        map.put(i, String.valueOf(i));
        map.remove(i - 1);
    }
    System.out.println(map.size());
}
```

解：

代码输出结果为**100**

原因如下：

1. ` Map<Short, String> map = new HashMap<>();`中定义`key`为`short`类型
2. `map.remove(i - 1);`中`i-1`的值在运算中向上转型为`int`
