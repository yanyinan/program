import java.util.Scanner;

/**
 * @title:找出范围内的素数
 * @author:nanzhou
 * @date:
 */
public class Demotest1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入待求范围");
        System.out.print("请输入左范围");
        int numst = input.nextInt();
        System.out.print("请输入右范围");
        int numde = input.nextInt();
        input.close();
        for (int i = numst, num = 0; i <= numde; i++) {
            for (int j = 1; j <= i >> 1; j++) {
                if (i % j == 0 && j != 1) {
                    break;
                } else if (j == i >> 1) {
                    num++;
                    System.out.println("第" + num + "个素数" + i);
                }
            }
        }
    }
}
