import java.util.Arrays;
import java.util.Scanner;

/**
 * @title:insert
 * @author:nanzhou
 * @date:
 */
//##  添加数组元素
//        给定一个整数数组，输入位置 n 和值 k。将值 k 插入到数组的第 n 位并输出新数组的每一 个元素。
//        例如：
//        有数组：
//
//        ```java
//        int[] arr = {2, 3, 1, 8, 3, 9, 6};
//        ```
//
//        输入 n 为 3 , k 为 10 ，新数组为 [2, 3, 10, 1, 8, 3, 9, 6]
public class insert {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        System.out.println("要插入的位置");
        int index = input.nextInt(); // 要插入的位置
        System.out.println("要插入的元素");
        int[] element = {input.nextInt()}; // 要插入的元素
        int[] newarr = new int[arr.length+1];
        System.arraycopy(arr,0,newarr,0,index);
        System.arraycopy(element,0,newarr,index,1);
        System.arraycopy(arr,index,newarr,index+1,arr.length-index);
        System.out.println(Arrays.toString(newarr));

    }
}