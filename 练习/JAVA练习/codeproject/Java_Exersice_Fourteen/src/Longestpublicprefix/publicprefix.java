package Longestpublicprefix;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class publicprefix {
    /**
     * 求公共前缀
     * @param prefix 待操作字符串数组
     * @return 返回公共前缀，空返回空
     */
    public static String LongestPublicPrefix(String[] prefix) {
        int min = prefix[0].length();//设置最短字符串长度，初始值为prefix[0].length()
        for (int i = 1; i < prefix.length; i++) {//找出字符串数组中最短字符串长度
            min = Math.min(min, prefix[i].length());
        }
        String temp = ""; //设置返回初始空值
        loop:
        for (int i = 0; i < min; i++) { //遍历字符串的每个字符
            char str = prefix[0].charAt(i);
            for (int j = 1; j < prefix.length; j++) {//遍历每个字符串
                if (str != prefix[j].charAt(i)) {//如果有字符串的字符不符，跳出循环
                    continue loop;
                }
            }
            temp += str;//所有字符符合拼接公共前缀
        }
        return temp;
    }

    public static void main(String[] args) {

        String[] test1 = {"flower", "flow", "flight"};
        String[] test2 = {"dog", "racecar", "car"};
        String[] test3 = {"apple", "app", "apricot"};
        String[] test4 = {"prefix", "pre", "preserve"};
        String[] test5 = {"abc", "def", "ghi"};
        System.out.println("\"" + publicprefix.LongestPublicPrefix(test4) + "\"");
    }
}
