import java.util.Arrays;

/**
 * @title:Array_sorting
 * @author:nanzhou
 * @date:2023.8.9
 */
//## 数组排序
//
//        设存在以下数组:
//
//        ```java
//// 设 names 数组中存放学生姓名
//        String[] names = {"安琪拉", "王昭君", "蔡文姬", "妲己", "张良"};
//// 设 courses 数组中依次存放三门课程的名称
//        String[] courses = {"C++", "Java", "Python"};
//// 设 scores 数组中依次存储的是 names 数组中各个学生的 C++ 、Java 、Python 课程的成绩
//        int[][] scores = {
//        {90, 89, 75},
//        {59, 40, 100},
//        {100, 99, 80},
//        {80, 61, 61},
//        {60, 100, 99},
//        };
//        ```
//
//        采用以下程序可以输出每个学生的姓名以及该学生各门课程的成绩:采用以下程序可以输出每个学生的姓名以及该学生各门课程的成绩:
//
//        ```java
//        for (int i = 0; i < scores.length; i++) {
//        System.out.print(names[i] + " => "); // 输出学生姓名
//        for (int j = 0; j < scores[i].length; j++) {
//        System.out.print(courses[j] + ":");// 输出课程名称
//        System.out.print(scores[i][j]); // 输出课程成绩
//        if (j < scores[i].length - 1) {
//        System.out.print(" , ");
//        }
//        }
//        System.out.println();
//        }
//
//        ```
//
//        1. 设计程序按照各个学生的 Java 成绩进行排序 ( 降序 )
//
//        2. 设计程序，根据学生总成绩进行排序(降序排列)，并输出学生姓名、每门课程的名称和 该学生的成绩、该学生的总成绩
public class Array_sorting {
    public static void main(String[] args) {
        // 设 names 数组中存放学生姓名
        String[] names = {"安琪拉", "王昭君", "蔡文姬", "妲己", "张良"};

        // 设 courses 数组中依次存放三门课程的名称
        String[] courses = {"C++", "Java", "Python"};

        // 设 scores 数组中依次存储的是 names 数组中各个学生的 C++ 、Java 、Python 课程的成绩
        int[][] scores = {
                {90, 89, 75},
                {59, 40, 100},
                {100, 99, 80},
                {80, 61, 61},
                {60, 100, 99},
        };

        for (int i = 0; i < scores.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j][1] > scores[max][1]) {
                    max = j;
                }
            }
            int[] temp = scores[i];
            scores[i] = scores[max];
            scores[max] = temp;
        }
        for (int[] i: scores) {
            System.out.println(Arrays.toString(i));
        }

    }
}
