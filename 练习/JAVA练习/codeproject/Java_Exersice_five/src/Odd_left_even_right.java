import java.util.Arrays;

/**
 * @title:Odd_left_even_right
 * @author:nanzhou
 * @date:2023.8.7
 */
//定义一个数组其中包含多个数字。用自己的方式最终实现，奇数放在数组的左边， 偶数放在数组的右边。（可以创建其他数组，不必须在原数组中改变）
public class Odd_left_even_right {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr_copy = new int[arr.length];
        for (int i = 0,x = 0,y = 0; i < arr.length; i++) {
            if (arr[i] % 2==0){
               arr_copy[arr.length-y-1] = arr[i];
               y++;
            }else {
                arr_copy[x] = arr[i];
                x++;
            }
        }
        System.out.println( Arrays.toString(arr_copy));
    }
}
