package Test;

import java.util.Arrays;

/**
 * @title:Demo_loop_test1-Select_Sort(选择排序)
 * @author:nanzhou
 * @date:2023.8.8
 */
public class Demo_loop_test2 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 4, 9, 3};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
