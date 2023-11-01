import java.util.Scanner;
/**
 * @title:
 * @author:nanzhou
 * @date:
 */
//简单运算
//描述
//        输入两个正整数a和b，输出这两个正整数的和，差，积，商，模（若a>b则输出a-b，a/b，a%b的值反之输出b-a，b/a，b%a的值，不考虑小数，请使用int类型）
//        输入描述：
//        两个正整数
//        输出描述：
//        它们的和，差，积，商，模。每个值之间用空格隔开

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        //write your code here......
        if(a<b)
            a=a+b-(b=a);//交换
        System.out.printf("%d %d %d %d %d",a+b,a-b,a*b,a/b,a%b);

    }
}