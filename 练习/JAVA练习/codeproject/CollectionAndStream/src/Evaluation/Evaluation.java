package Evaluation;

import java.util.Arrays;

/**
 *  * ## 求值
 *  *
 *  * 有一个整数集合，分别完成以下操作：
 *  *
 *  * - 所有元素之和
 *  * - 最大值
 *  * - 最小值
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Evaluation {

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        //sum
       /* System.out.println(Arrays.stream(num).reduce(0, (a, b) -> a + b));*/
        System.out.println(Arrays.stream(num).sum());
        //min
        System.out.println(Arrays.stream(num).min());
        //max
        /*System.out.println(Arrays.stream(num).max().getAsInt());*/
        System.out.println(Arrays.stream(num).max());
    }
}
