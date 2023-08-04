import java.util.Scanner;

/**
 * @title:square
 * @author:nanzhou
 * @date:2023.8.4
 */
//一个循环，打印输出一个由字符构成的正方形图案，其中 边长由用户输入确定。要求字符按照以下顺序循环使 用：'#' , '@', '*'。
public class Square {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 | j == 0) | (i == n - 1 | j == n - 1)) {
                    if ((i == 0 | i == n - 1) && (j == 0 | j == n - 1)) {
                        System.out.print("#");
                    } else {
                        System.out.print("@");
                    }
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
