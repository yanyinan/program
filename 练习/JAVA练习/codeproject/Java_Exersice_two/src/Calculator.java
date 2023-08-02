import java.awt.*;
import java.util.Scanner;

/**
 * @title:计算器
 * @author:nanzhou
 * @date:2023.08.02
 */
/*计算器
        编写一个简单的计算器程序，要求用户输入两个数和操作符（+、-、*、/），然后根据操作符进行相应的运算，
        并输出结果。如果输入的运算符不是有效的运算符，则输出"无效的运算符"。*/
public class Calculator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入两个需要计算的值");
        double m = input.nextDouble();
        double n = input.nextDouble();
        System.out.println("请选择操作符（+、-、*、/）");
        String operator = input.next();
        input.close();
        double result = 0;
        switch (operator){
            case "+":
                result = m + n;
                break;
            case "-":
                result = m - n;
                break;
            case "*":
                result = m * n;
                break;
            case "/":
                result = m / n;
                break;
            default:
                System.out.println("无效的运算符号");
                break;
        }
        System.out.println(result);
    }
}
