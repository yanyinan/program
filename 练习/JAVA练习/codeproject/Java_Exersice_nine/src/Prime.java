import java.util.Scanner;

/**
 * @title:Prime
 * @author:nanzhou
 * @date:2023.8.11
 */
public class Prime {
    public static boolean prime(int num) {
        if (num == 0) {
            return false;
        } else {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(prime(input.nextInt()));
    }
}
