package averagenum;

import java.util.Arrays;

/**
 * ## 平均值
 * 有一个整数集合，求每个元素平方的平均值。
 * @author:nanzhou
 * @date:
 */
public class AverageNum {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
//        Average
        System.out.println(Arrays.stream(num).average());
    }
}
