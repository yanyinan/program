/**
 * @title:1-100以内的素数和
 * @author:nanzhou
 * @date:2023.8.7
 */
public class Examtest1 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i >> 1; j++) {
                if (i % j == 0 && j != 1) {
                    break;
                } else if (j == i >> 1) {
                    sum = sum + i;
                }
            }
        }System.out.println(sum);
    }
}
