package Validparentheses;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

import java.util.Arrays;

/**
 * 有效括号
 * 给定一个只包括 '('，')' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * <p>
 * ​ 左括号必须用相同类型的右括号闭合。​ 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()()()"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "((()))"
 * 输出: true
 * 示例 4:
 * <p>
 * 输入: "(()())"
 * 输出: true
 * 示例 5:
 * <p>
 * 输入: "((((((()))"  ")()("
 * 输出: false
 */
public class Valid {
    /**
     * 有效括号
     * @param valid 需判断字符串
     * @return 正确返回true，反之返回false
     */
    public static Boolean validParentheses(String valid) {
        int count = 0;//作为判断计数器
        for (char c : valid.toCharArray()) {
            if (c == '(') {//为“（”count计数1
                count++;
            } else if (c == ')') {//为“）”count计数-1
                count--;
                if (count < 0) {//count<0,说明“（”、“）”不成对
                    return false;
                }
            }
        }
        return count == 0;//以count的值是否为0，判断“（”、“）”是否成对
    }

    public static void main(String[] args) {
        System.out.println(Valid.validParentheses("()))(("));
    }
}
