```java
/**
 * @author ${Nanzhou}
 * @date ${2023.8.1}
*/
/**
*Number_of_roses
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
/**
*Swap the values of two variables
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
/**
*Three_side_lengths
*/
 //通过用户输入三个数(三条边长)，判断是否能够组成一个三角形。（是 输出 true，不是 输出false)

import java.util.Scanner;

public class Three_side_lengths {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x= input.nextInt(); 
		int y= input.nextInt();
		int z= input.nextInt();
        input.close();
		int max = (x > y) ? x : y;
		max = (max > z) ? max : z;
		System.out.printf("%d,%d,%d", x, y, z); 
		boolean to = Math.pow(x, 2) + Math.pow(y, 2) == Math.pow(z, 2)|| Math.pow(z, 2) + Math.pow(y, 2) == Math.pow(x, 2)||Math.pow(x, 2) + Math.pow(z, 2) == Math.pow(y, 2) ? true : false;
		System.out.println(to);
    }
}

```

