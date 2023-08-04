import java.util.Scanner;

/**
 * @title:Jog
 * @author:nanzhou
 * @date:
 */
//## 李四跑步
//        李四每天跑步
//        第一周周一跑 100 米，周二到周天每天比前一天多 100 米。 往后每周以比前一周周一多 100 米。
//        请问 李四 n（控制台输入） 天后跑了多少米
public class Jog {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i % 7 + i / 7;
        }
        System.out.println(n + "天一共跑了" + sum * 100);
    }
}
