## 月份天数

 编写一个程序，根据输入的年份和月份来输出该月份的天数。要考虑闰年的情况。

```java
import java.util.Scanner;

/**
 * @title:月份天数
 * @author:nanzhou
 * @date:
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
                    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                        yield 28;
                    } else {
                        yield 29;
                    }
                }
                case 4, 6, 9, 11 -> 30;
                default -> 0;
            };
            System.out.printf("%d年%d月天数是%d \n",year,month,days);
        }
    }
}

```



##  单位转换

 编写一个程序，根据用户输入的温度单位("C"表示摄氏度，"F"表示华氏度)和温度，将其 转换为另一种单位后输出。

> 注: 摄氏度转换为华氏度的公式(摄氏度 * 9 / 5)+32，以及华氏度转换为摄氏度的公式(华 氏度-32) * 5 / 9 

```java
import java.util.Scanner;

/**
 * @title:
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

```



## 计算器 

编写一个简单的计算器程序，要求用户输入两个数和操作符（+、-、*、/），然后根据操 作符进行相应的运算，并输出结果。如果输入的运算符不是有效的运算符，则输出"无效的 运算符"。 

```java
import java.awt.*;
import java.util.Scanner;

/**
 * @title:计算器
 * @author:nanzhou
 * @date:
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

```



## 季节

 编写一个程序，根据用户输入的月份（1 到 12），输出该月份所属的季节。假设春季是 3 到 5 月，夏季是 6 到 8 月，秋季是 9 到 11 月，冬季是 12、1 和 2月。如果输入的月份超 出了范围，输出"输入错误"。 

```java
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


```



## 星座

 编写一个程序，根据用户输入的月份和日期，输出该日期所在的星座。以下是一个简单的星座日期范围参考： 

> 水瓶座（1月20日到2月18日）
>
> 双鱼座（2月19日到3月20日） 
>
> 白羊座（3月21日到4月19日） 
>
> 金牛座（4月20日到5月20日）
>
> 双子座（5月21日到6月20日）
>
> 巨蟹座（6月21日到7月22日） 
>
> 狮子座（7月23日到8月22日） 
>
> 处女座（8月23日到9月22日） 
>
> 天秤座（9月23日到10月22日） 
>
> 天蝎座（10月23日到11月21日）
>
> 射手座（11月22日到12月21日） 
>
> 魔羯座（12月22日到1月19日） 

```java
import java.util.Scanner;
/**
 * @title:星座
 * @author:nanzhou
 * @date:2023.08.02
 */
/*星座
        编写一个程序，根据用户输入的月份和日期，输出该日期所在的星座*/
public class Constellation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入月份");
        int month = input.nextInt();
        System.out.println("请输入日期");
        String[] a = {"水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座"};
        int day = input.nextInt();
        if (month <= 12 && month > 0 && day > 0) {
            switch (month) {
                case 1, 3, 5, 7, 8, 10, 12:
                    if (day <= 31) {
                        switch (month) {
                            case 1:
                                if (day >= 20) {
                                    System.out.println(a[0]);
                                } else {
                                    System.out.println(a[11]);
                                }
                                break;
                            case 3:
                                if (day >= 19) {
                                    System.out.println(a[2]);
                                } else {
                                    System.out.println(a[1]);
                                }
                                break;
                            case 5:
                                if (day >= 21) {
                                    System.out.println(a[4]);
                                } else {
                                    System.out.println(a[3]);
                                }
                                break;
                            case 7:
                                if (day >= 23) {
                                    System.out.println(a[6]);
                                } else {
                                    System.out.println(a[5]);
                                }
                                break;
                            case 8:
                                if (day >= 23) {
                                    System.out.println(a[7]);
                                } else {
                                    System.out.println(a[6]);
                                }
                                break;
                            case 10:
                                if (day >= 23) {
                                    System.out.println(a[9]);
                                } else {
                                    System.out.println(a[8]);
                                }
                                break;
                            case 12:
                                if (day >= 22) {
                                    System.out.println(a[11]);
                                } else {
                                    System.out.println(a[10]);
                                }
                                break;
                        }
                    } else {
                        System.out.println("日期错误");
                    }
                    break;
                case 4, 6, 9, 11:
                    if (day <= 31) {
                        switch (month) {
                            case 4:
                                if (day >= 20) {
                                    System.out.println(a[3]);
                                } else {
                                    System.out.println(a[2]);
                                }
                                break;
                            case 6:
                                if (day >= 21) {
                                    System.out.println(a[5]);
                                } else {
                                    System.out.println(a[4]);
                                }
                                break;
                            case 9:
                                if (day >= 23) {
                                    System.out.println(a[8]);
                                } else {
                                    System.out.println(a[7]);
                                }
                                break;
                            case 11:
                                if (day >= 23) {
                                    System.out.println(a[10]);
                                } else {
                                    System.out.println(a[9]);
                                }
                                break;
                        }
                    } else {
                        System.out.println("日期错误");
                    }
                    break;
                case 2:
                    if (day <= 29) {
                        System.out.println(a[1]);
                    } else {
                        System.out.println(a[2]);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
```



## 奖金

 编写一个程序，根据员工的工龄来计算年终奖金。

> 奖金计算规则如下： 工龄小于等于5年，奖金为工资的5% 工龄大于5年且小于等于10年，奖金为工资的10% 工龄大于10年，奖金为工资的15% (工资和工龄输入) 

```java
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
//        if (year > 0) {
//            switch (year) {
//                case 0, 1, 2, 3, 4, 5 -> wages = wages + wages * 0.05;
//                case 6, 7, 8, 9, 10 -> wages = wages + wages * 0.1;
//                default -> wages = wages + wages * 0.15;
//            }
//        }
        System.out.println("工资为" + wages);
    }
}

```

## 流程图 

画出if分支还有switch分支的流程

![流程控制](%E6%B5%81%E7%A8%8B%E6%8E%A7%E5%88%B6.png)
