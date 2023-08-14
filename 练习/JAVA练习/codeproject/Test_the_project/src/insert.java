import java.util.Arrays;
import java.util.Scanner;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
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