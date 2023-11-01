package lico;

import java.util.HashSet;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("d"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            int n = 0;
            for (int j = i; j < chars.length; j++) {
                set.add(chars[j]);

                int temp = n + 1;
                if (set.size() != temp) {
                    break;
                }
                n = temp;
                if (n >= num) {
                    num = n;
                }

            }set.clear();
        }
        return num;
    }
}
