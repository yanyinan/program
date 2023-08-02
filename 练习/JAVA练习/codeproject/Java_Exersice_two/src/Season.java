import java.util.Scanner;

/**
 * @title:季节
 * @author:nanzhou
 * @date:2023.08.02
 */
/* 季节
         编写一个程序，根据用户输入的月份（1 到 12），输出该月份所属的季节。
         假设春季是 3 到 5 月，夏季是 6 到 8 月，秋季是 9 到 11 月，冬季是 12、1 和 2月。如果输入的月份超 出了范围，输出"输入错误"。*/
public class Season {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("月份");
        int month = input.nextInt();
        input.close();
        if (month >= 0 && month <= 12) {
            switch (month) {
                case 3, 4, 5:
                    System.out.println("春季");
                    break;
                case 6, 7, 8:
                    System.out.println("夏季");
                    break;
                case 9, 10, 11:
                    System.out.println("秋季");
                    break;
                default:
                    System.out.println("冬季");
                    break;
            }
        } else {
            System.out.println("输入错误");
        }
    }
}

