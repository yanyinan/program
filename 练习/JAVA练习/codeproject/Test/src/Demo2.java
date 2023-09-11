import java.util.*;
import java.util.stream.Collectors;

/**
 * ### 题目2
 * 给定两个字符串 `s` 和 `t` ，编写一个函数来判断 `t` 是否是 `s` 的字母异位词。
 * **注意：**若 `s` 和 `t` 中每个字符出现的次数都相同，则称 `s` 和 `t` 互为字母异位词。
 * **示例 1:**
 * ```
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * ```
 * **示例 2:**
 * ```
 * 输入: s = "rat", t = "car"
 * 输出: false
 * ```
 * **提示:**

 * - `s` 和 `t` 仅包含小写字母:
 * @author:nanzhou
 * @date:
 */
public class Demo2 {
    public static void main(String[] args) {
        String str = "anagram";
        String str1 = "nagaram";
        System.out.println(check(jude(str), jude(str1)));
        System.out.println(checkSet(str, str1));
    }
    private static Boolean checkSet(String jude,String jude1) {
        if (jude == null || jude1 == null) {
            throw new RuntimeException();
        }
        List<String> set = new ArrayList<>();
        List<String> set1 = new ArrayList<>();
        Collections.addAll(set,jude.split(""));
        Collections.addAll(set1,jude1.split(""));
        set1.removeAll(set);
        return  set1.isEmpty();
    }
    private static Boolean check(HashMap<Character, Integer> jude, HashMap<Character, Integer> jude1) {
        if (jude == null || jude1 == null) {
            throw new RuntimeException();
        }
        Set<Character> judeset = jude.keySet();
        boolean flag = true;
        for (Character e : judeset) {
            if (!jude.get(e).equals(jude1.get(e))) {
                flag = false;
            }
        }
        return flag;
    }

    private static HashMap<Character, Integer> jude(String str) {
        HashMap<Character,Integer> strMap = new HashMap<>();
        char[] temp = str.toCharArray();
        for (Character e :temp){
            strMap.put(e, strMap.getOrDefault(e,0 )+1);
        }
        System.out.println(strMap);
        return strMap;
    }
}
