import java.util.Scanner;

/**
 * @title:奖金
 * @author:nanzhou
 * @date:2023.08.02
 */
/*奖金
        编写一个程序，根据员工的工龄来计算年终奖金。
        >奖金计算规则如下： 工龄小于等于5年，奖金为工资的5%
        工龄大于5年且小于等于10年，奖金为工资的10%
        工龄大于10年，奖金为工资的15% (工资和工龄输入)
        流程图 画出if分支还有switch分支的流程*/
public class Bonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double wages = 3000;
        int year = input.nextInt();
        input.close();
        if (year > 0 && year <= 5) {
            wages = wages + wages * 0.05;
        } else if (year > 5 && year <= 10) {
            wages = wages + wages * 0.1;
        } else {
            wages = wages + wages * 0.15;
        }
        System.out.println("工资为" + wages);
    }
}
