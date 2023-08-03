import java.util.Scanner;

/**
 * @title:月份天数
 * @author:nanzhou
 * @date:2023.08.02
 */

//月份天数
//        编写一个程序，根据输入的年份和月份来输出该月份的天数。要考虑闰年的情况。
public class Number_of_days_in_the_month {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年份");
        int year = input.nextInt();
        System.out.println("请输入月份");
        int month = input.nextInt();
        input.close();
        if (0 >= month || month > 12) {
            System.out.println("月份异常");
        } else {
            int days = switch (month) {
                case 1, 3, 5, 7, 8, 10, 12 -> 31;
                case 2 -> {
                    //判断闰年
                    if ((year % 4 == 0 && year % 100 != 0) | year % 400 == 0) {
                        yield 29;
                    } else {
                        yield 28;
                    }
                }
                case 4, 6, 9, 11 -> 30;
                default -> 0;
            };
            System.out.printf("%d年%d月天数是%d \n",year,month,days);
        }
    }
}
