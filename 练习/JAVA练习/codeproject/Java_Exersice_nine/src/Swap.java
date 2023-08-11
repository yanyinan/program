import java.util.Arrays;

/**
 * @title:Swap
 * @author:nanzhou
 * @date:2023.8.11
 */
//## 交换元素位置
//        编写一个方法，接受一个整数数组和两个索引作为参数，交换数组中指定索引位置的两个元素。
public class Swap {
    public static int[] swa(int[] arr, int m, int n) {
        arr[m] += arr[n];
        arr[n] = arr[m] - arr[n];
        arr[m] -= arr[n];
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(swa(arr, 2, 5)));
    }
}
