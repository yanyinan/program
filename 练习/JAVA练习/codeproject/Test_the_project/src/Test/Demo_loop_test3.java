package Test;

import java.util.Arrays;

/**
 * @title:Demo_loop_test3-Insert_Sort(插入排序)
 * @author:nanzhou
 * @date:2023.8.8
 */
public class Demo_loop_test3 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 4, 1,9, 3};
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
