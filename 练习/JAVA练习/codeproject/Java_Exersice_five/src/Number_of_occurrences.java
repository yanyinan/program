import java.util.Random;
import java.util.Scanner;

/**
 * @title:Number_of_occurrences
 * @author:nanzhou
 * @date:2023.08.07
 */
//6.定义一个长度为20的数组，元素为20-40的随机数，
//要求判断指定元素在数组中出现 的次数，指定元素为键盘录入范围为20-40之间。
public class Number_of_occurrences {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random Random = new Random();
        for( int i = 0; i < arr.length;i++){
            arr[i] = Random.nextInt(20)+20;
        }
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int sum = 0;
        for (int arr_temp :arr){
            if (num == arr_temp){
                sum ++;
            }
        }
        System.out.println(sum);
    }
}
