import java.util.Arrays;
import java.util.Scanner;

/**
 * @title:Find_the_element
 * @author:nanzhou
 * @date:2023.8.8
 */
//## 查找元素
//        给定一个整数数组，输入一个值 n ，输出 n 在数组中的下标(如果不存在输出 -1 )
//        例如:
//        ```java
//        int[] arr = {3, 2, 1, 4, 5};
//        ```
//        1. 输入： 3
//        输出： 0
//        2. 输入：6
//        输出： -1
public class Find_the_element {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5};
        System.out.println(Arrays.toString(arr));
        Scanner input = new Scanner(System.in);
        int flag = -1,x =input.nextInt();
        for (int i = 0;i < arr.length;i++){
            if (x == arr[i]){
                flag = i;
                break;
            }
        }
        System.out.println(flag);
    }
}
