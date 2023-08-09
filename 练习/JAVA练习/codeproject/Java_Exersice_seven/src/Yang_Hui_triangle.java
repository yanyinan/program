import java.util.Scanner;

/**
 * @title:Yang_Hui_triangle
 * @author:nanzhou
 * @date:2023.8.9
 */
//需求: 打印杨辉三角形(行数可以键盘录入)
//        分析: 看这种图像的规律
//        A:任何一行的第一列和最后一列都是1
//        B:从第三行开始，每一个数据是它上一行的前一列和它上一行的本列之和。
//        步骤:
//        / / //// /
//        首先定义一个二维数组。行数如果是n，我们把列数也先定义为n。A:这个n的数据来自于键盘录入。
//        给这个二维数组任何一行的第一列和最后一列赋值为1B:按照规律给其他元素赋值从第三行开始，每一个数据是它上一行的前一列和它上一行的本列之和。D: 遍历这个二维数组,
//    杨辉三角的基本性质是：第n行第m个数可表示为C_{n-1}^{m-1},其中C表示组合数。杨辉三角的每一行都是等差数列，首项为1,公差为1/2^(n-1)。
public class Yang_Hui_triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}