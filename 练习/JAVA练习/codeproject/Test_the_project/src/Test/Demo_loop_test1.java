package Test;

import java.util.Arrays;

/**
 * @title:Demo_loop_test1-Bubbling_sorting(冒泡排序)
 * @author:nanzhou
 * @date:2023.8.8
 */
public class Demo_loop_test1 {
    public static void main(String[] args) {
        int[] arr = {5,1,2,4,9,3};
        for (int i = 0;i < arr.length;i++){//控制外层循环
            for (int j = 0;j < arr.length-1-i;j++){//控制内层循环并排序交换位置
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
