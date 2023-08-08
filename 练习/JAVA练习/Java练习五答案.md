## 1.定义一个含有五个元素的数组,并为每个元素赋值,求数组中所有元素的最小值 操作步骤：

-  1.定义5个元素数组
-  2.可以使用初始化数组的两种方式之一为数组元素赋值
-  3.遍历数组求数组中的最小值 

```java
/**
 * @title:Min_array
 * @author:nanzhou
 * @date:2023.08.07
 */
//## 1.定义一个含有五个元素的数组,并为每个元素赋值,求数组中所有元素的最小值 操作步骤：
//
//        -  1.定义5个元素数组
//        -  2.可以使用初始化数组的两种方式之一为数组元素赋值
//        -  3.遍历数组求数组中的最小值
public class Min_array {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int min_arr = arr[0];
        for (int arrtemp : arr){
            if (arrtemp < min_arr){
                min_arr = arrtemp;
            }
        }
        System.out.println(min_arr);
    }
}
```

## 2、创建一个长度为6的整数数组。

请编写代码，随机生成六个0（包含）-100（不包 含）之间的整数存放到数组中，然后计算出数组中所有元素的和并打印。

```java
import java.util.Random;

/**
 * @title:Random_6_array
 * @author:nanzhou
 * @date:2023.08.07
 */
//## 2、创建一个长度为6的整数数组。
//        请编写代码，
//        随机生成六个0（包含）-100（不包 含）之间的整数存放到数组中，
//        然后计算出数组中所有元素的和并打印。
public class Random_6_array {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[6];
        int sum = 0;
        for( int arr_temp : arr){
            arr_temp = random.nextInt(100);
            sum = sum + arr_temp;
        }
        System.out.println(sum);
    }
}

```



##  3．需求：求出数组中索引与索引对应的元素都是奇数的元素分析：

-  1、遍历数组
-  2、判断索引是否是奇数（索引 % 2 != 0）
-  3、判断索引对应的元素是否是奇数(arr[索引] % 2 != 0) 
-  4、满足条件输出结果
```java
/**
 * @title:Corresponding_odd_number
 * @author:nanzhou
 * @date:2023.08.07
 */
//##  3．需求：求出数组中索引与索引对应的元素都是奇数的元素分析：
//
//        -  1、遍历数组
//        -  2、判断索引是否是奇数（索引 % 2 != 0）
//        -  3、判断索引对应的元素是否是奇数(arr[索引] % 2 != 0)
//        -  4、满足条件输出结果
public class Corresponding_odd_number {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7};
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0 && arr[i] % 2 != 0) {
                System.out.println(i + "  " + arr[i]);
            }
        }

    }
}
```


##  4.按要求在main方法中完成以下功能：

-  a. 定义一个长度为5的int型数组arr，提示用户输入5个1-60之间的数字作为数组元素
-  b. 生成2-10（范围包含2和10）之间的随机数`num c`. 遍历数组`arr`,筛选出数组中不是`num`倍数的元素并输出

> PS：输入的数组元素范围包括1和60，不需要代码判断
```java
import java.util.Random;
import java.util.Scanner;

/**
 * @title:A_multiple_of_num
 * @author:nanzhou
 * @date:2023.08.07
 */
//##  4.按要求在main方法中完成以下功能：
//
//        -  a. 定义一个长度为5的int型数组arr，提示用户输入5个1-60之间的数字作为数组元素
//        -  b. 生成2-10（范围包含2和10）之间的随机数`num c`. 遍历数组`arr`,
//              筛选出数组中不是`num`倍数的元素并输出
//
//        > PS：输入的数组元素范围包括1和60，不需要代码判断
public class A_multiple_of_num {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.println("接下来请依次输入1-60之间的数字作为数组元素");
        for (int i = 0; i < arr.length; i++) {
            int temp = input.nextInt();
            arr[i] = temp;
        }
        Random Random = new Random();
        int num = Random.nextInt(9) + 2;
        System.out.println("随机数"+num);
        for (int i = 0;i < arr.length;i++) {
            if (arr[i] % num != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}

```


## 5.有一个数组int[] arr = {9,1,3,4,54,56,23,22,20,43,45,78};,要求打印数组中能被6整除的 元素。

```java
/**
 * @title:Divisible_by_6
 * @author:nanzhou
 * @date:2023.08.07
 */
//5.有一个数组int[] arr = {9,1,3,4,54,56,23,22,20,43,45,78};
//要求打印数组中能被6整除的元素。
public class Divisible_by_6 {
    public static void main(String[] args) {
        int[] arr = {9,1,3,4,54,56,23,22,20,43,45,78};
        for (int i = 0 ;i < arr.length;i++){
            if (arr[i] % 6 == 0){
                System.out.println(arr[i]);
            }
        }
    }
}

```

##  6.定义一个长度为20的数组，元素为20-40的随机数，要求判断指定元素在数组中出现 的次数，指定元素为键盘录入范围为20-40之间。

```java
import java.util.Random;
import java.util.Scanner;

/**
 * @title:Number_of_occurrences
 * @author:nanzhou
 * @date:2023.08.07
 */
//6.定义一个长度为20的数组，元素为20-40的随机数，
//要求判断指定元素在数组中出现 的次数，指定元素为键盘录入范围为20-40之间。
public class Number_of_occurrences {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random Random = new Random();
        for( int i = 0; i < arr.length;i++){
            arr[i] = Random.nextInt(20)+20;
        }
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int sum = 0;
        for (int arr_temp :arr){
            if (num == arr_temp){
                sum ++;
            }
        }
        System.out.println(sum);
    }
}

```

##  7. 现有一个整数数组，数组中的每个元素都是[0-9]之间的数字，从数组的最大索引位 置开始到最小索引位置，依次表示整数的个位、十位、百位。。。依次类推。请编写 程序计算，这个数组所表示的整数值。例如：

```java
数组：{2, 1, 3, 5, 4}
表示的整数为：21354 // 注：是整数类型的两万一千三百五十四，不是字符串拼起来的。
```

```java
/**
 * @title:Program_calculations
 * @author:nanzhou
 * @date:2023.08.07
 */
public class Program_calculations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] *Math.pow(10,(arr.length-i-1));
        }
        System.out.println(sum);
    }
}
```

## 8、定义一个数组其中包含多个数字。用自己的方式最终实现，奇数放在数组的左边， 偶数放在数组的右边。（可以创建其他数组，不必须在原数组中改变）
```java
import java.util.Arrays;

/**
 * @title:Odd_left_even_right
 * @author:nanzhou
 * @date:2023.8.7
 */
//定义一个数组其中包含多个数字。用自己的方式最终实现，奇数放在数组的左边， 偶数放在数组的右边。（可以创建其他数组，不必须在原数组中改变）
public class Odd_left_even_right {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr_copy = new int[arr.length];
        for (int i = 0,x = 0,y = 0; i < arr.length; i++) {
            if (arr[i] % 2==0){
               arr_copy[arr.length-y-1] = arr[i];
               y++;
            }else {
                arr_copy[x] = arr[i];
                x++;
            }
        }
        System.out.println( Arrays.toString(arr_copy));
    }
}
             
```


## 9、在唱歌比赛中，有6名评委给选手打分，分数范围是[0 - 100]之间的整数。选手的 最后得分为：去掉最高分、最低分后的4个评委的平均分，请完成上述过程并计算 出选手的得分。
```java
import java.util.Scanner;

/**
 * @title:The_judges_score
 * @author:nanzhou
 * @date:2023.8.7
 */
//在唱歌比赛中，有6名评委给选手打分，分数范围是[0 - 100]之间的整数。
//        选手的 最后得分为：去掉最高分、最低分后的4个评委的平均分，
//        请完成上述过程并计算 出选手的得分。
public class The_judges_score {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];
        int max = 0,min = 0,sum = 0;
        for (int i = 0; i < arr.length; i++){
            arr[i] = input.nextInt();
            if (max < arr[i]){
                max = arr[i];
            } else if (min > arr[i]) {
                min = arr[i];
            }
            sum += arr[i];
        }
        System.out.println((sum-max-min)/4);
    }
}

```


## 10、现有一个int 数组，数组中有十个元素。将数组反转后输出。
```java
import java.util.Arrays;

/**
 * @title:Invert_he_output
 * @author:nanzhou
 * @date:2023.8.7
 */
//现有一个int 数组，数组中有十个元素。将数组反转后输出。
public class Invert_he_output {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        System.out.println("反转后的数组为：" + Arrays.toString(arr));
    }
}

```

