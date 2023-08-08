import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @title:Nth_largest
 * @author:nanzhou
 * @date:2023.8.8
 */
//##  第n大
//        给定一个整数数组，输入一个值 n, 输出数组中第 n 大的数。
//        例如：
//        有数组：
//        ```java
//        int[] arr = {2, 3, 1, 8, 3, 9, 6};
//        ```
//        输入 n 的值为 4，输出 3
public class Nth_largest {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 8, 3, 9, 6};
        int[] arr2 = arr;
        for (int i = 1; i < arr2.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp > arr2[j]) {
                arr2[j + 1] = arr2[j];
                j--;
            }
            arr2[j + 1] = temp;
        }
        Scanner input = new Scanner(System.in);
        System.out.println(arr2[input.nextInt() - 1]);
        input.close();
    }
}
