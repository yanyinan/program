## 求和

设计一个方法，用于计算整数的和

```java
import java.util.Scanner;

/**
 * @title:Sueforpeace
 * @author:nanzhou
 * @date:2023.8.11
 */
//## 求和 设计一个方法，用于计算整数的和
public class Sueforpeace {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(sueForpeace(1,2,3));
    }

    public static int sueForpeace(int... num) {
        int sum = num[0];
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }
        return sum;
    }
}
```

## 阶乘

编写一个方法，接受一个正整数作为参数，并返回它的阶乘

```java
/**
 * @title:Factorial
 * @author:nanzhou
 * @date:2023.08.11
 */
//## 阶乘 编写一个方法，接受一个正整数作为参数，并返回它的阶乘
public class Factorial {
    public static  int factorial(int num){
        int nums =1;
        for (int i = num; i >0 ; i--) {
            nums *=i;
        }
        return nums;
    }
    public static void main(String[] args) {
        System.out.println(factorial(3));
    }
}
```

## 判断素数

编写一个方法，接受一个整数作为参数，并判断它是否为素数（质数）

```java
import java.util.Scanner;

/**
 * @title:Prime
 * @author:nanzhou
 * @date:2023.8.11
 */
public class Prime {
    public static boolean prime(int num) {
        if (num == 0) {
            return false;
        } else {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(prime(input.nextInt()));
    }
}

```

## 翻转数组

编写一个方法，接受一个字符数组，将其翻转并输出。

```java
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @title:Flip
 * @author:nanzhou
 * @date:2023.8.11
 */
public class Flip {
    public static char[] flipChar(char[] arr) {
        char[] newarr = new char[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            newarr[i] = arr[i];
        }
        System.out.println(Arrays.toString(newarr));
        return newarr;
    }

    public static void main(String[] args) {
        char[] arr = {'1', '2', '3'};
        arr = flipChar(arr);
    }
}

```



## 回文数

编写一个方法，接受一个整数作为参数，判断它是否为回文数（正着读和倒着读都一样）

```java
import java.util.Scanner;

/**
 * @title:Palindromic
 * @author:nanzhou
 * @date:2023.8.11
 */
//## 回文数
//        编写一个方法，接受一个整数作为参数，判断它是否为回文数（正着读和倒着读都一样）
public class Palindromic {
    public static boolean palindRomic(int num) {
        if (num < 0) {
            return false;
        } else {
            int temp = 0;
            while (num > temp) {
                temp = temp * 10 + num % 10;
                num /= 10;
            }
            return num == temp | num == temp / 10;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(palindRomic(input.nextInt()));
    }
}

```

## 交换元素位置

编写一个方法，接受一个整数数组和两个索引作为参数，交换数组中指定索引位置的两个元素。

```java
import java.util.Arrays;

/**
 * @title:Swap
 * @author:nanzhou
 * @date:2023.8.11
 */
//## 交换元素位置
//        编写一个方法，接受一个整数数组和两个索引作为参数，交换数组中指定索引位置的两个元素。
public class Swap {
    public static int[] swa(int[] arr, int m, int n) {
        arr[m] += arr[n];
        arr[n] = arr[m] - arr[n];
        arr[m] -= arr[n];
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(swa(arr, 2, 5)));
    }
}

```



## 数组元素左移

编写一个方法，接受一个整数数组和一个正整数 k 作为参数，将数组中的元素左移 k 个位置。

```java
import java.util.Arrays;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
//## 数组元素左移
//        编写一个方法，接受一个整数数组和一个正整数 k 作为参数，将数组中的元素左移 k 个位置。
public class Moveleft {
    public static int[] moveLeft(int[] arr,int k){
        int[] temparr = new int[arr.length];
        System.arraycopy(arr, k, temparr, 0, arr.length - k);
        System.arraycopy(arr, 0, temparr, arr.length - k, k);
        return temparr;
    }
    public static void main(String[] args) {
        int[] arr = {9, 8, 6, 5, 7, 1, 2, 3};
        int k = 5;
        System.out.println(Arrays.toString(moveLeft(arr,k)));
    }
}

```

