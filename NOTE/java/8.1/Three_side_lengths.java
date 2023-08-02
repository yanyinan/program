/**
*Three_side_lengths
 * @author ${Nanzhou}
 * @date ${2023.8.1}

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
		boolean to = x + y == z|| z + y) == x||x + z == y ? true : false;
		System.out.println(to);
    }
}
