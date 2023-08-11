import java.util.Arrays;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
//## 数组元素左移
//        编写一个方法，接受一个整数数组和一个正整数 k 作为参数，将数组中的元素左移 k 个位置。
public class Moveleft {
    public static int[] moveLeft(int[] arr,int k){
        int[] temparr = new int[arr.length];
        System.arraycopy(arr, k, temparr, 0, arr.length - k);
        System.arraycopy(arr, 0, temparr, arr.length - k, k);
        return temparr;
    }
    public static void main(String[] args) {
        int[] arr = {9, 8, 6, 5, 7, 1, 2, 3};
        int k = 5;
        System.out.println(Arrays.toString(moveLeft(arr,k)));
    }
}
