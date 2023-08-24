package Exceltablecolumnnames;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * Excel表列名称
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 *
 * 例如：
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1：
 *
 * 输入：columnNumber = 1
 * 输出："A"
 * 示例 2：
 *
 * 输入：columnNumber = 28
 * 输出："AB"
 * 示例 3：
 *
 * 输入：columnNumber = 701
 * 输出："ZY"
 * 示例 4：
 *
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 */
public class Excel {
    /**
     * 回它在 Excel 表中相对应的列名称
     * 思路26进制
     * @param columnNumber 列数
     * @return 返回列名称
     */
    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;  // 将列数从基于1的索引转换为基于0的索引
            int remainder = columnNumber % 26;
            char c = (char) (remainder + 'A');  // 获取对应的字母，A对应0，B对应1，依此类推
            result.insert(0, c);  // 将字母插入到结果字符串的开头
            columnNumber /= 26;  // 除以26，以准备处理下一位
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(convertToTitle(728));
    }
}
