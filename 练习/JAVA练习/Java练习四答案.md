## 洪乞丐干10天，收入是多少？ 

天朝有一个乞丐姓洪，去天桥要钱 

第一天要了1块钱 

第二天要了2块钱

 第三天要了4块钱 

第四天要了8块钱

 以此类推 

```java
/**
 * @title:beggar
 * @author:nanzhou
 * @date:2023.8.4
 */
/*## 洪乞丐干10天，收入是多少？
     天朝有一个乞丐姓洪，去天桥要钱
     第一天要了1块钱
     第二天要了2块钱
     第三天要了4块钱
     第四天要了8块钱
     以此类推*/
public class Beggar {
    public static void main(String[] args) {
        int money = 1,
                total_money = 0;
        int days = 10;
        for (int i = 1;i <= days;i++){
            total_money = total_money + money;
            money *=2;
        }
        System.out.println(total_money);
    }
}

```



## 李四跑步 

李四每天跑步 

第一周周一跑 100 米，周二到周天每天比前一天多 100 米。 往后每周以比前一周周一多 100 米。

请问 李四 n（控制台输入） 天后跑了多少米 

```java
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
            System.out.println(i);
            sum = sum + i % 7 + i / 7;
        }
        System.out.println(n + "天一共跑了" + sum * 100);
    }
}

```

## 输入一个数字，和位数，判断这个数是否回文数字1221 就 是回文数字

```java

/**
 * @title:回文数
 * @author:nanzhou
 * @date:
 */
//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//例如，121 是回文，而 123 不是。
public class Palindromic_number {
    public boolean isPalindrome(int x) {
        //排除不可能数值
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }else{
            //数值对半
            int num = 0;
            while( x > num){
                num = num * 10 + x % 10;
                x /= 10;
            }
            //根据位数返回相应的值
            return x == num || num / 10 == x;
        }

    }
}

```

##  一个循环，打印输出一个由字符构成的正方形图案，其中 边长由用户输入确定。要求字符按照以下顺序循环使 用：'#' , '@', '*'。

![image-20230804193425577](https://s2.loli.net/2023/08/04/8wFKjuTGobQIS5X.png)

```java
import java.util.Scanner;

/**
 * @title:square
 * @author:nanzhou
 * @date:2023.8.4
 */
//一个循环，打印输出一个由字符构成的正方形图案，其中 边长由用户输入确定。要求字符按照以下顺序循环使 用：'#' , '@', '*'。
public class Square {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 | j == 0) | (i == n - 1 | j == n - 1)) {
                    if ((i == 0 | i == n - 1) && (j == 0 | j == n - 1)) {
                        System.out.print("#");
                    } else {
                        System.out.print("@");
                    }
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}

```

