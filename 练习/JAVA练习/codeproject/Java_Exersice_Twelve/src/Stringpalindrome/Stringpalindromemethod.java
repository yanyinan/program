package Stringpalindrome;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * 回文字符串
 * 请定义一个方法用于判断一个字符串是否是对称的字符串，并在主方法中测试方法。例如："abcba"、"上海自来水来自海上"均为对称字符串
 */
public class Stringpalindromemethod {
    public boolean palindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
