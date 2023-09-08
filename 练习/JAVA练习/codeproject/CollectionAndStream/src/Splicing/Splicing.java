package Splicing;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ## 拼接
 *
 * 给定一个字符串数组,使用 Stream 把所有字符串拼接成一个字符串。
 *
 * ```java
 * String[] arr = {"a", "b", "c"};
 * 输出: abc
 * ```
 */
public class Splicing {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};

        //外部变量存储
//        StringBuilder temp = new StringBuilder();
//        Arrays.stream(arr).forEach(e -> {
//            temp.append(e); // 在Lambda表达式中修改外部变量
//        });
//        System.out.println(temp.toString());

        //错误示例
//        String temp = ""; //字符串不能改变
//        Arrays.stream(arr).forEach(e -> temp = temp + e);
//        System.out.println(temp);

        //reduce方法
//        System.out.println(Arrays.stream(arr).reduce("", (a, n) -> a + n));


        //Collectors.joining() 方法
//        String result = Arrays.stream(arr).collect(Collectors.joining());
//        System.out.println(result);
    }
}
