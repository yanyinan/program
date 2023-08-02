
/**
*Swap the values of two variables
 * @author ${Nanzhou}
 * @date ${2023.8.1}

*/

import java.util.Scanner;

public class Swap_the_values_of_two_variables {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m= input.nextInt(); 
		int n= input.nextInt();
        input.close();
		//通过位运算(异或运算) 
		m = m ^ n;
		n = m ^ n;
		m= m ^ n;
        //通过加法计算
        m = m + n;
        n = m - n;
        m = m - n;
        //定义临时(中间)变量 
        int x = m + n;
        m = n;
        n = x - m;
        System.out.println("m = " + m);
        System.out.println("n = " + n);
    }
}
