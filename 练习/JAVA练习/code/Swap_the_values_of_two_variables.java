
/**
*Swap the values of two variables
 * @author ${Nanzhou}
 * @date ${2023.8.1}
//定义两个整变量，交换两个变量的值。
//通过位运算(异或运算)
//通过加法计算
//定义临时(中间)变量
*/


import java.util.Scanner;

public class Swap_the_values_of_two_variables {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m= input.nextInt(); 
		int n= input.nextInt();
        input.close();
		int x ;
		x = m ^ n;
		m = x ^ m;
		n = x ^ n;
		System.out.println("m = " + m);
		System.out.println("x = " + x);
        System.out.println("n = " + n);
    }
}
