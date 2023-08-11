import java.util.Scanner;

/**
 * @title:Palindromic
 * @author:nanzhou
 * @date:2023.8.11
 */
//## 回文数
//        编写一个方法，接受一个整数作为参数，判断它是否为回文数（正着读和倒着读都一样）
public class Palindromic {
    public static boolean palindRomic(int num) {
        if (num < 0) {
            return false;
        } else {
            int temp = 0;
            while (num > temp) {
                temp = temp * 10 + num % 10;
                num /= 10;
            }
            return num == temp | num == temp / 10;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(palindRomic(input.nextInt()));
    }
}
