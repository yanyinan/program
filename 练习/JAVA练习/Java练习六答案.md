> 数组输出可以使用 for 循环、for-each循环以及 java.util.Arrays.toString 方法

##  成绩排名

 一个班级有若干学生，每个学生的成绩以整数表示。请实现一个程序，根据学生的成绩对他们进行排名并输出。 

输出格式：

```java
排名 成绩
1   xxx
2   xxx
3   xxx
```

```java
/**
 * @title:Grade_ranking
 * @author:nanzhou
 * @date:2023.8.8
 */
//##  成绩排名
//一个班级有若干学生，每个学生的成绩以整数表示。
//请实现一个程序，根据学生的成绩对 他们进行排名并输出。
public class Grade_ranking {
    public static void main(String[] args) {

        int[] arr = {1, 6, 7, 8,2, 3, 4, 5, 9, 10};

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp > arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        for (int i = -1;i <arr.length ;i++){
            if (i < 0 ){System.out.println("排名\t成绩");}
            else {
                System.out.println(i+1 +"\t" + arr[i]);
            }
        }
    }
}

```

##  数组去重

 给定一个整数数组，编写一个程序，移除数组中的重复元素，输出一个去重后的数组。

```java
import java.util.Arrays;

/**
 * @title:Array_deduplication
 * @author:nanzhou
 * @date:2023.8.8
 */
//##  数组去重
//给定一个整数数组，编写一个程序，移除数组中的重复元素，
//输出一个去重后的数组。
public class Array_deduplication {
    public static void main(String[] args) {
        int[] arr = {12, 55, 45, 12, 36, 55, 55};
        int[] arr2 = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                arr2[index++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr2));
    }
}
```

##  第n大

 给定一个整数数组，输入一个值 n, 输出数组中第 n 大的数。

 例如： 

有数组： 

```java
int[] arr = {2, 3, 1, 8, 3, 9, 6};
```

输入 n 的值为 4，输出 3 

```java
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @title:Nth_largest
 * @author:nanzhou
 * @date:2023.8.8
 */
//##  第n大
//        给定一个整数数组，输入一个值 n, 输出数组中第 n 大的数。
//        例如：
//        有数组：
//        ```java
//        int[] arr = {2, 3, 1, 8, 3, 9, 6};
//        ```
//        输入 n 的值为 4，输出 3
public class Nth_largest {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 8, 3, 9, 6};
        int[] arr2 = arr;
        for (int i = 1; i < arr2.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp > arr2[j]) {
                arr2[j + 1] = arr2[j];
                j--;
            }
            arr2[j + 1] = temp;
        }
        Scanner input = new Scanner(System.in);
        System.out.println(arr2[input.nextInt() - 1]);
        input.close();
    }
}

```



## 去掉第 n 大数

 给定一个整数数组，输入一个值 n, 输出去掉数组中第 n 大的数后的数组。

```java
import java.util.Arrays;
import java.util.Scanner;

/**
 * @title:delteNth_largest
 * @author:nanzhou
 * @date:2023.8.8
 */
public class delteNth_largest {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 8, 3, 9, 6};
        System.out.println(Arrays.toString(arr));
        int[] arr2 = Arrays.copyOfRange(arr,0,arr.length-1);
        for (int i = 1; i < arr2.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp > arr2[j]) {
                arr2[j + 1] = arr2[j];
                j--;
            }
            arr2[j + 1] = temp;
        }
        Scanner input = new Scanner(System.in);
        int i =0,index =input.nextInt() - 1;
        while (i < arr.length){
            if (arr[i]==arr2[index]){
                arr[i] = 0;
            }
            i++;
        }
        System.out.println(Arrays.toString(arr));
        input.close();
    }
}

```



##  添加数组元素 

给定一个整数数组，输入位置 n 和值 k。将值 k 插入到数组的第 n 位并输出新数组的每一 个元素。

 例如：

 有数组：

```java
int[] arr = {2, 3, 1, 8, 3, 9, 6};
```

输入 n 为 3 , k 为 10 ，新数组为 [2, 3, 10, 1, 8, 3, 9, 6] 

```java
import java.util.Arrays;
import java.util.Scanner;

/**
 * @title:insert
 * @author:nanzhou
 * @date:
 */
//##  添加数组元素
//        给定一个整数数组，输入位置 n 和值 k。将值 k 插入到数组的第 n 位并输出新数组的每一 个元素。
//        例如：
//        有数组：
//
//        ```java
//        int[] arr = {2, 3, 1, 8, 3, 9, 6};
//        ```
//
//        输入 n 为 3 , k 为 10 ，新数组为 [2, 3, 10, 1, 8, 3, 9, 6]
public class insert {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        System.out.println("要插入的位置");
        int index = input.nextInt(); // 要插入的位置
        System.out.println("要插入的元素");
        int[] element = {input.nextInt()}; // 要插入的元素
        int[] newarr = new int[arr.length+1];
        System.arraycopy(arr,0,newarr,0,index);
        System.arraycopy(element,0,newarr,index,1);
        System.arraycopy(arr,index,newarr,index+1,arr.length-index);
        System.out.println(Arrays.toString(newarr));

    }
}
```



## 数组的交集 

给定两个各不包含重复元素的数组 arr 和 arr1 ，求 arr 和 arr1 的交集(在 arr 中有， arr1 中也包含的元素集合)，将交集中的元素放到一个数组中并输出。 

例如：

```java
int[] arr = {1, 2, 3};
int[] arr1 = {2, 3};
```

 输出: [2, 3] 

```java
import java.util.Arrays;

/**
 * @title:intersection
 * @author:nanzhou
 * @date:2023.8.8
 */
//## 数组的交集
//
//        给定两个各不包含重复元素的数组 arr 和 arr1 ，求 arr 和 arr1 的交集(在 arr 中有， arr1 中也包含的元素集合)，将交集中的元素放到一个数组中并输出。
//
//        例如：
//
//        ```java
//        int[] arr = {1, 2, 3};
//        int[] arr1 = {2, 3};
//        ```
//
//        输出: [2, 3]
public class intersection {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] arr1 = {2, 3};
        int[] newarr = new int[Math.min(arr1.length, arr.length)];
        int index = 0;
        for (int i = 0;i <arr.length;i++){
            for (int j = 0;j < arr1.length;j++){
                if (arr[i] == arr1[j]){
                    newarr[index++] = arr[i];
                }
            }
        }
        System.out.println(Arrays.toString(newarr));

    }
}

```



## 查找元素

 给定一个整数数组，输入一个值 n ，输出 n 在数组中的下标(如果不存在输出 -1 ) 

例如: 

```java
int[] arr = {3, 2, 1, 4, 5};
```

1. 输入： 3

   输出： 0

2. 输入：6

    输出： -1

```java
import java.util.Arrays;
import java.util.Scanner;

/**
 * @title:Find_the_element
 * @author:nanzhou
 * @date:2023.8.8
 */
//## 查找元素
//        给定一个整数数组，输入一个值 n ，输出 n 在数组中的下标(如果不存在输出 -1 )
//        例如:
//        ```java
//        int[] arr = {3, 2, 1, 4, 5};
//        ```
//        1. 输入： 3
//        输出： 0
//        2. 输入：6
//        输出： -1
public class Find_the_element {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 5};
        System.out.println(Arrays.toString(arr));
        Scanner input = new Scanner(System.in);
        int flag = -1,x =input.nextInt();
        for (int i = 0;i < arr.length;i++){
            if (x == arr[i]){
                flag =0;
                break;
            }
        }
        System.out.println(flag);
    }
}

```

