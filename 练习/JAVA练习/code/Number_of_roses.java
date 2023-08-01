
/**
*Number_of_roses
 * @author ${Nanzhou}
 * @date ${2023.8.1}

*/
//通过控制台输入一个 4 位整数，输出是否是四叶玫瑰数。（是 输出 true，不是 输出false)
import java.util.Scanner;

public class Number_of_roses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); 
        int a, b, c, d;
        a = n / 1000; 
        b = (n / 100) % 10; 
		c = (n / 10) % 10; 
        d = n % 10; 
        input.close();
		boolean to = Math.pow(a, 4) + Math.pow(b, 4) + Math.pow(c, 4) + Math.pow(d, 4) == n ? true : false;
       // System.out.printf("%d,%d,%d,%d", a, b, c,d); 
		System.out.println(to);
		
    }
}
