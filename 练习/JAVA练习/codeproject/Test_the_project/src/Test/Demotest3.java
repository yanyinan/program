package Test;

import java.util.Scanner;

/**
 * @title:分解质因数
 * @author:nanzhou
 * @date:
 */
public class Demotest3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.close();
        while (num > 1) {
            for1:
            for (int i = 2; i <= num; i++) {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        continue for1;
                    }
                }
                if (num % i == 0) {
                    System.out.println(i);
                    num /= i;
                    break;
                }
            }
        }
    }
}
