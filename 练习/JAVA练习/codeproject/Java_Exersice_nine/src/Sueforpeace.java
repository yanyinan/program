import java.util.Scanner;

/**
 * @title:Sueforpeace
 * @author:nanzhou
 * @date:2023.8.11
 */
//## 求和 设计一个方法，用于计算整数的和
public class Sueforpeace {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(sueForpeace(1,2,3));
    }

    public static int sueForpeace(int... num) {
        int sum = num[0];
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        return sum;
    }
}
