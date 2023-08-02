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