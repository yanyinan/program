import java.util.Arrays;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

public class QuickSort2 {


    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 11, 4, 5, 10, 8};
        quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        // 结束标识
        if (start >= end) {
            return;
        }

        int base = arr[start]; // 基准值
        int left = start, right = end;

        while (left < right) {

            while (left < right && arr[right] >= base) {
                right--;
            }

            while (left < right && arr[left] <= base) {
                left++;
            }

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        // 交换基准值的位置
        arr[start] = arr[left];
        arr[left] = base;

        // 对左边元素进行快排
        quickSort(arr, start, left - 1);

        // 对右边元素进行快排
        quickSort(arr, left + 1, end);


    }
}