import java.util.Arrays;

/**
 * @title:Invert_he_output
 * @author:nanzhou
 * @date:2023.8.7
 */
//现有一个int 数组，数组中有十个元素。将数组反转后输出。
public class Invert_he_output {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        System.out.println("反转后的数组为：" + Arrays.toString(arr));
    }
}
