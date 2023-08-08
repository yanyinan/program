import java.util.Arrays;

/**
 * @title:Array_deduplication
 * @author:nanzhou
 * @date:2023.8.8
 */
//##  数组去重
//给定一个整数数组，编写一个程序，移除数组中的重复元素，
//输出一个去重后的数组。
public class Array_deduplication {
    public static void main(String[] args) {
        int[] arr = {12, 55, 45, 12, 36, 55, 55};
        int[] arr2 = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                arr2[index++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr2));
    }
}