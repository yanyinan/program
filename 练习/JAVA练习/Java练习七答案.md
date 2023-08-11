## 翻转数组

 设存在以下数组:

```java
char[][] chunxiao = {
{ '春' , '眠' , '不' , '觉' , '晓' } ,
{ '处' , '处' , '闻' , '啼' , '鸟' } ,
{ '夜' , '来' , '风' , '雨' , '声' } ,
{ '花' ,  '落' , '知' , '多' , '少' }
} ;
```

将其输出成如下形式

![image-20230809190550417](https://s2.loli.net/2023/08/09/IQA1aO7LxopH2Xq.png)

- 尝试设计一组循环语句，将以上形式的输出结果翻转为以下形式(旋转 90 度):

![image-20230809190648728](https://s2.loli.net/2023/08/09/yVhPK6s8GTr2cFe.png)

> 思考: 如果是一首词该如何旋转输出： 
>
> 十年生死两茫茫，
>
> 不思量，
>
> 自难忘。
>
>  千里孤坟，
>
> 无处话凄凉。 
>
> 纵使相逢应不识，
>
> 尘满面，
>
> 鬓如霜。
>
>  夜来幽梦忽还乡，
>
> 小轩窗，
>
> 正梳妆。
>
>  相顾无言，
>
> 惟有泪千行。 
>
> 料得年年肠断处，
>
> 明月夜，
>
> 短松冈。

```java
/**
 * @title:Flip_the_array
 * @author:nanzhou
 * @date:2023.8.9
 */
// 设存在以下数组:
//
//         ```java
//         char[][] chunxiao = {
//         { '春' , '眠' , '不' , '觉' , '晓' } ,
//         { '处' , '处' , '闻' , '啼' , '鸟' } ,
//         { '夜' , '来' , '风' , '雨' , '声' } ,
//         { '花' ,  '落' , '知' , '多' , '少' }
//         } ;
//         ```
//
//         将其输出成如下形式
//
//         ![image-20230809190550417](https://s2.loli.net/2023/08/09/IQA1aO7LxopH2Xq.png)
//
//         - 尝试设计一组循环语句，将以上形式的输出结果翻转为以下形式(旋转 90 度):
public class Flip_the_array {
    public static void main(String[] args) {
//        char[][] chunxiao = {
//                {'春', '眠', '不', '觉', '晓', '，'},
//                {'处', '处', '闻', '啼', '鸟', '。'},
//                {'夜', '来', '风', '雨', '声', ','},
//                {'花', '落', '知', '多', '少', '。'}
//        };
        char[][] chunxiao = {
                {'十', '年', '生', '死', '两', '茫', '茫', ','},
                {'不', '思', '量', ','},
                {'自', '难', '忘', '。'},
                {'千', '里', '孤', '坟', ','},
                {'无', '处', '话', '凄', '凉', '。'},
                {'纵', '使', '相', '逢', '应', '不', '识', ','},
                {'尘', '满', '面', ','},
                {'鬓', '如', '霜', '。'},
                {'夜', '来', '幽', '梦', '忽', '还', '乡', ','},
                {'小', '轩', '窗', ','},
                {'正', '梳', '妆', '。'},
                {'相', '顾', '无', '言', ','},
                {'惟', '有', '泪', '千', '行', '。'},
                {'料', '得', '年', '年', '肠', '断', '处','，'},
                {'明', '月', '夜', '，'},
                {'短', '松', '冈', '。'}
        };
        System.out.println("正序输出");
        for (int i = 0; i < chunxiao.length; i++) {
            for (int j = 0; j < chunxiao[i].length; j++) {
                System.out.print(chunxiao[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("旋转90");
        int maxLength = 0;
        int maxIndex = -1;
        for (int i = 0; i < chunxiao.length; i++) {
            int length = 0;
            for (int j = 0; j < chunxiao[i].length; j++) {
                length += chunxiao[i][j];
            }
            if (length > maxLength) {
                maxLength = length;
                maxIndex = i;
            }
        }
            for (int i = 0; i < chunxiao[maxIndex].length ; i++) {
                for (int j = chunxiao.length - 1; j >= 0; j--) {
                    if (i >= chunxiao[j].length) {
                        System.out.print("\t");
                    } else
                        System.out.print(chunxiao[j][i] + "\t");
                }
                System.out.println();
            }
        }

}



```



## 数组排序

设存在以下数组:

```java
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
```

采用以下程序可以输出每个学生的姓名以及该学生各门课程的成绩:采用以下程序可以输出每个学生的姓名以及该学生各门课程的成绩:

```java
	for (int i = 0; i < scores.length; i++) {
            System.out.print(names[i] + " => "); // 输出学生姓名
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(courses[j] + ":");// 输出课程名称
                System.out.print(scores[i][j]); // 输出课程成绩
                if (j < scores[i].length - 1) {
                    System.out.print(" , ");
                }
            }
            System.out.println();
        }
```

1. 设计程序按照各个学生的 Java 成绩进行排序 ( 降序 ) 

   ```java
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
               String temp1 = names[i];
               names[i] = names[max];
               names[max] = temp1;
           }
           for (int i = 0; i < names.length; i++) {
               System.out.print(names[i] + ": ");
               for (int j = 0; j < scores[i].length; j++) {
                   System.out.print(courses[j] + "=" + scores[i][j] + "\t");
               }
               System.out.println();
           }
   
       }
   }
   
   
   ```

   

2. 设计程序，根据学生总成绩进行排序(降序排列)，并输出学生姓名、每门课程的名称和 该学生的成绩、该学生的总成绩

   ```java
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
   public class Array_sorting2 {
       public static void main(String[] args) {
           // 设 names 数组中存放学生姓名
           String[] names = { "安琪拉" , "王昭君" , "蔡文姬" , "妲己" , "张良" };
   
           // 设 courses 数组中依次存放三门课程的名称
           String[] courses = { "C++" , "Java" , "Python" };
           // 设 scores 数组中依次存储的是 names 数组中各个学生的 C++ 、Java 、Python 课程的成绩
           int[][] scores = {
                   { 90 , 89 , 75 } ,
                   { 59 , 40 , 100 } ,
                   { 100 , 99 , 80 } ,
                   { 80 , 61 , 61 } ,
                   { 60 , 100 , 99 }
           };
   
           int[][] sum = new int[scores.length][2];
           for (int i = 0; i < scores.length; i++){
               sum[i][0] = Arrays.stream(scores[i]).sum();
               sum[i][1] = i;
           }
           // 插入排序,按照总成绩
           for (int i = 1; i < sum.length; i++) {
               int index = i - 1;
               int[] num = sum[i];
               while (index >= 0 && sum[index][0] < num[0]) {
                   sum[index + 1] = sum[index];
                   index--;
               }
               sum[index+1] = num;
           }
   
           for (int[] i: sum) {
               System.out.println(names[i[1]]+"=>" + courses[0]+scores[i[1]][0] +'\t'+ courses[1]+scores[i[1]][1] +'\t'+ courses[2]+scores[i[1]][2] +'\t'+ i[0]);
           }
   
       }
   }
   
   ```

   

## 杨辉三角 

编写一个程序，生成一个给定行数的杨辉三角

```java
import java.util.Scanner;

/**
 * @title:Yang_Hui_triangle
 * @author:nanzhou
 * @date:2023.8.9
 */
//需求: 打印杨辉三角形(行数可以键盘录入)
//        分析: 看这种图像的规律
//        A:任何一行的第一列和最后一列都是1
//        B:从第三行开始，每一个数据是它上一行的前一列和它上一行的本列之和。
//        步骤:
//        / / //// /
//        首先定义一个二维数组。行数如果是n，我们把列数也先定义为n。A:这个n的数据来自于键盘录入。
//        给这个二维数组任何一行的第一列和最后一列赋值为1B:按照规律给其他元素赋值从第三行开始，每一个数据是它上一行的前一列和它上一行的本列之和。D: 遍历这个二维数组,
//    杨辉三角的基本性质是：第n行第m个数可表示为C_{n-1}^{m-1},其中C表示组合数。杨辉三角的每一行都是等差数列，首项为1,公差为1/2^(n-1)。
public class Yang_Hui_triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
```

## 复制数组【拓展】

有如下数组 `nums `，请通过删除掉其中的 33 ，得到一个新的数组` newNums`

```
int[] nums = {2, 11, 33, 44, 55, 66, 277}
//newNums = {2, 11, 44,55, 66, 277}
```

使用多种方式实现： 

1. `for` 循环（自己写方法实现）

   ```java
   import java.util.Arrays;
   
   /**
    * @title:Delete
    * @author:nanzhou
    * @date:2023.8.9
    */
   //## 复制数组【拓展】
   //
   //        有如下数组 `nums `，请通过删除掉其中的 33 ，得到一个新的数组` newNums`
   //
   //        ```
   //        int[] nums = {2, 11, 33, 44, 55, 66, 277}
   //        //newNums = {2, 11, 44,55, 66, 277}
   //        ```
   //
   //        使用多种方式实现：
   //
   //        1. `for` 循环（自己写方法实现）
   //        2. `System `类中的 `arraycopy `方法实现
   
   public class Delete {
       public static void main(String[] args) {
           int[] nums = {2, 11, 33, 44, 55, 66, 277};
           //        1. `for` 循环（自己写方法实现）
           int[] newnums = new int[nums.length-1];
           int count = 0;
           for (int i = 0; i < nums.length; i++) {
               if (nums[i] != 33) {
                   newnums[count++] = nums[i];
               }
           }
       }
   }
   
   ```

   

2. `System `类中的 `arraycopy `方法实现

   ```java
   import java.util.Arrays;
   
   /**
    * @title:Delete
    * @author:nanzhou
    * @date:2023.8.9
    */
   //## 复制数组【拓展】
   //
   //        有如下数组 `nums `，请通过删除掉其中的 33 ，得到一个新的数组` newNums`
   //
   //        ```
   //        int[] nums = {2, 11, 33, 44, 55, 66, 277}
   //        //newNums = {2, 11, 44,55, 66, 277}
   //        ```
   //
   //        使用多种方式实现：
   //
   //        1. `for` 循环（自己写方法实现）
   //        2. `System `类中的 `arraycopy `方法实现
   
   public class Delete {
       public static void main(String[] args) {
           int[] nums = {2, 11, 33, 44, 55, 66, 277};
   //        2. `System `类中的 `arraycopy `方法实现
           System.arraycopy(nums,0,newNums,0,2);
   		System.arraycopy(nums,3,newNums,2,4);
   		// 3. ` Arrays.stream(nums) `方法实现
           int[] newnums = Arrays.stream(nums).filter(x -> x != 33).toArray();
           System.out.println(Arrays.toString(newnums));
       }
   }
   
   ```
   
   