# Stream练习

## 拼接

给定一个字符串数组,使用 Stream 把所有字符串拼接成一个字符串。

```java
String[] arr = {"a", "b", "c"};
输出: abc
```

```java
package Splicing;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ## 拼接
 *
 * 给定一个字符串数组,使用 Stream 把所有字符串拼接成一个字符串。
 *
 * ```java
 * String[] arr = {"a", "b", "c"};
 * 输出: abc
 * ```
 */
public class Splicing {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};

        //外部变量存储
        StringBuilder temp = new StringBuilder();
        Arrays.stream(arr).forEach(e -> {
            temp.append(e); // 在Lambda表达式中修改外部变量
        });
        System.out.println(temp.toString());

        //错误
//        String temp = "";
//        Arrays.stream(arr).forEach(e -> temp = temp + e);
//        System.out.println(temp);

        //数组流
//        String result = Arrays.stream(arr).collect(Collectors.joining());
//        System.out.println(result);
    }
}

```



## 求值

有一个整数集合，分别完成以下操作：

- 所有元素之和
- 最大值
- 最小值

```java
package Evaluation;

import java.util.Arrays;

/**
 *  * ## 求值
 *  *
 *  * 有一个整数集合，分别完成以下操作：
 *  *
 *  * - 所有元素之和
 *  * - 最大值
 *  * - 最小值
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Evaluation {

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        //sum
        System.out.println(Arrays.stream(num).sum());
        //min
        System.out.println(Arrays.stream(num).min());
        //max
        System.out.println(Arrays.stream(num).max());
    }
}

```



## 薪资最低的员工

有一个员工类Employee,里面有name、age和salary字段。请通过 Stream 对多个Employee对象按salary排序,然后取前3个输出。



```java
package LowestSalary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ## 薪资最低的员工
 *
 * 有一个员工类Employee,里面有name、age和salary字段。请通过 Stream 对多个Employee对象按salary排序,然后取前3个输出。
 * @author:nanzhou
 * @date:
 */
public class Lowest {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee employee = new Employee("张三",'男',2000.0);
        Employee employee1 = new Employee("张一",'男',3000.0);
        Employee employee2 = new Employee("张四",'男',4000.0);
        Employee employee3 = new Employee("张把",'男',3000.0);
        Employee employee4 = new Employee("张流",'男',2000.0);
        Employee employee5 = new Employee("张五",'女',1000.0);
        list.add(employee);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
/*        list.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList()).forEach(e-> System.out.println(e.toString()));*/
        list.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .limit(3)
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e.toString()));
    }
}
class Employee{
    String name;
    Character age;
    Double salary;

    public Employee(String name, Character age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getAge() {
        return age;
    }

    public void setAge(Character age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
```



## 平均值

有一个整数集合，求每个元素平方的平均值。



```java
package averagenum;

import java.util.Arrays;

/**
 * ## 平均值
 * 有一个整数集合，求每个元素平方的平均值。
 * @author:nanzhou
 * @date:
 */
public class AverageNum {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
//        Average
        System.out.println(Arrays.stream(num).average());
    }
}

```



# 集合练习

## 斗地主

有一个集合保存扑克牌的花色(四种)，另一个集合保存扑克牌点数(13个)。创建一个新的集合保存所有的扑克牌(54张，包含 大小王)。将扑克牌分为四份（3个玩家，1份底牌），排序后输出四份手牌。

```java
List<String> flower; // 存花色
List<String> points; // 存点数

List<String> poker; // 扑克牌

List<String> player1; // 玩家一
List<String> player2; // 玩家二
List<String> player3; // 玩家三
List<String> bottom; // 底牌
```



```java
package fightthelandlord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ## 斗地主
 * <p>
 * 有一个集合保存扑克牌的花色(四种)，另一个集合保存扑克牌点数(13个)。创建一个新的集合保存所有的扑克牌(54张，包含 大小王)。将扑克牌分为四份（3个玩家，1份底牌），排序后输出四份手牌。
 * <p>
 * ```java
 * List<String> flower; // 存花色
 * List<String> points; // 存点数
 * <p>
 * List<String> poker; // 扑克牌
 * <p>
 * List<String> player1; // 玩家一
 * List<String> player2; // 玩家二
 * List<String> player3; // 玩家三
 * List<String> bottom; // 底牌
 * ```
 *
 * @author:nanzhou
 * @date:
 */
public class FightLandlord {

    public static void main(String[] args) {
        PokerCards pokerCards = new PokerCards();
        List<String> pokerList = pokerCards.getSuits().stream()
                .flatMap(suit -> pokerCards.getRanks().stream().map(rank -> suit + rank))
                .collect(Collectors.toList());
        pokerList.add("Joker");
        pokerList.add("joker");
        /* System.out.println(pokerList);*/
        Collections.shuffle(pokerList);
        // 玩家一
        List<String> player1 = new ArrayList<>();
        // 玩家二
        List<String> player2 = new ArrayList<>();
        // 玩家三
        List<String> player3 = new ArrayList<>();
        // 底牌
        List<String> bottom = new ArrayList<>();
        for (int i = 0; i < pokerList.size(); i++) {
            if (pokerList.size()-3 > i) {
                switch (i % 3) {
                    case 0 -> player2.add(pokerList.get(i));
                    case 1 -> player1.add(pokerList.get(i));
                    default -> player3.add(pokerList.get(i));
                }
            }else {
                bottom.add(pokerList.get(i));
            }

        }
        System.out.println("Player1"+player1);
        System.out.println("Player1"+player2);
        System.out.println("Player1"+player3);
        System.out.println("Bottom"+bottom);

    }
}

class PokerCards {
    private List<String> suits = new ArrayList<>();
    private List<String> ranks = new ArrayList<>();

    public PokerCards() {
        suits.add("\u2665");
        // 红心 (Heart)
        suits.add("\u2660");
        // 黑桃 (Spade)
        suits.add("\u2663");
        // 梅花 (Club)
        suits.add("\u2666");
        // 方块 (Diamond)
        ranks.add("A");
        ranks.add("2");
        ranks.add("3");
        ranks.add("4");
        ranks.add("5");
        ranks.add("6");
        ranks.add("7");
        ranks.add("8");
        ranks.add("9");
        ranks.add("10");
        ranks.add("J");
        ranks.add("Q");
        ranks.add("K");
    }

    public List<String> getRanks() {
        return ranks;
    }

    public List<String> getSuits() {
        return suits;
    }
}
```



## 生日提醒

编写一个生日提醒程序，使用Map来存储人名和对应的生日日期。够根据日期提醒用户哪些人今天过生日？

- 如何筛选显示出最近七天过生日的用户





