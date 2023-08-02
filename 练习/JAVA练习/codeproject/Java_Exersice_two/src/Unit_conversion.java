import java.util.Scanner;

/**
 * @title:单位转换
 * @author:nanzhou
 * @date:2023.08.02
 */
/*单位转换
        编写一个程序，根据用户输入的温度单位("C"表示摄氏度，"F"表示华氏度)和温度，将其 转换为另一种单位后输出。
        注: 摄氏度转换为华氏度的公式(摄氏度 * 9 / 5)+32，以及华氏度转换为摄氏度的公式(华 氏度-32) * 5 / 9*/
public class Unit_conversion {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入待转换温度");
        double temperature = input.nextDouble();
        System.out.println("请输入温度单位，摄氏度为C.华氏度为F");
        String unit = input.next();
        input.close();
        switch (unit) {
            case "c", "C" -> {
                double result = temperature * 9 / 5 + 32;
                System.out.printf("华氏度温度为：%f F \n", result);
            }
            case "f", "F" -> {
                double result = (temperature - 32 ) / 9 * 5;
                System.out.printf("摄氏度温度为：%f C \n", result);
            }
            default -> System.out.println("输入错误");
        }

    }
}
