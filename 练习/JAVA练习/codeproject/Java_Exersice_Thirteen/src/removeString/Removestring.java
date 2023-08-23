package removeString;

import java.util.Scanner;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Removestring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串: ");
        String input = scanner.nextLine();

        String result = removeDuplicates(input);
        System.out.println("去除重复字符后的字符串: " + result);
    }
    public static String removeDuplicates(String input) {
        boolean[] seen = new boolean[65536]; // 假设使用Unicode字符集

        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (!seen[c]) { // 如果字符尚未出现过
                result.append(c); // 将字符添加到结果中
                seen[c] = true; // 标记该字符已出现过
            }
        }
        return result.toString();
    }
}


