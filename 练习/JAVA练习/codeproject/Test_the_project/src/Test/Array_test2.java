package Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @title:Array_test2
 * @author:nanzhou
 * @date:2023.8.10
 */
//有一个 n * m 的二维数组 (n 表示二维数组的长度，m 表示二维数组每个元素的长度)
//      1。 找出最小值是多少
//      2。计算以最小值为中心其9宫格内所有元素的和如果最小值在边界则不存在的按0 计算
public class Array_test2 {
    public static void main(String[] args) {
        int[][] arr = new int[9][9];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(50);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        int min =arr[0][0];
        int iindex = 0;
        int jindex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (min > arr[i][j]){
                    min = arr[i][j];
                    iindex = i;
                    jindex = j;
                }
            }
        }
        System.out.println(min+" "+iindex+"\t"+jindex);

    }
}
