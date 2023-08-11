import java.util.Arrays;
import java.util.Scanner;

/**
 * @title:Array_test1
 * @author:nanzhou
 * @date:2030.8.10
 */
//插入一个值到指定位置
public class Array_test1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println();
        int[] newarr = new int[arr.length+1];
        int[] temp = new int[1];
        Scanner input = new Scanner(System.in);
        System.out.println("插入位置");
        int n = input.nextInt();
        System.out.println("插入数据");
        temp[0] = input.nextInt();
        System.arraycopy(arr,0,newarr,0,n-1);
        System.arraycopy(temp,0,newarr,n-1,1);
        System.arraycopy(arr,n-1,newarr,n,newarr.length-n);
        System.out.println(Arrays.toString(newarr));
    }
}
