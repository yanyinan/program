package longest;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * 最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 输入： "abefge"
 * 输出： 5
 *
 * abcabcd  --> 4
 * abaca    --> 3
 * aaaaa    --> 1
 * abbbbc   --> 2
 */
public class Longestring {
    public static int subString(String str){
        String max = ""; // 存储最长子串
        int start = 0; // 子串的起始下标
        for (int end = start + 1; end < str.length(); end++) {
            // 子串的范围
            String sub = str.substring(start, end);
            // 当前位置的字符
            String current = str.substring(end, end + 1);
            // 当前位置的字符是否在子串中存在
            if (sub.indexOf(current) != -1){
                // 当前子串和目前最大子串谁大
                if (sub.length() > max.length()) {
                    max = sub;
                }
                // 找下一个子串的开始坐标
                start = str.indexOf(current, start) + 1;

                // 最长子串比剩下的长度还长
                if (max.length() > str.length() - start - 1){
                    break;
                }
            } else if (end == str.length() - 1){ // 不存在并且是最后一个
                sub = str.substring(start); // 一直到最后一个都没有重复的
                // 当前子串和目前最大子串谁大
                if (sub.length() > max.length()) {
                    max = sub;
                }
            }

        }
        return max.length();
    }

    public static void main(String[] args) {
        System.out.println(subString("abc"));
    }
}
