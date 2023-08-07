import java.util.Random;
import java.util.Scanner;

/**
 * @title:A_multiple_of_num
 * @author:nanzhou
 * @date:2023.08.07
 */
//##  4.按要求在main方法中完成以下功能：
//
//        -  a. 定义一个长度为5的int型数组arr，提示用户输入5个1-60之间的数字作为数组元素
//        -  b. 生成2-10（范围包含2和10）之间的随机数`num c`. 遍历数组`arr`,
//              筛选出数组中不是`num`倍数的元素并输出
//
//        > PS：输入的数组元素范围包括1和60，不需要代码判断
public class A_multiple_of_num {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.println("接下来请依次输入1-60之间的数字作为数组元素");
        for (int i = 0; i < arr.length; i++) {
            int temp = input.nextInt();
            arr[i] = temp;
        }

        Random Random = new Random();
        int num = Random.nextInt(9) + 2;
        System.out.println("随机数"+num);
        for (int i = 0;i < arr.length;i++) {
            if (arr[i] % num != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
