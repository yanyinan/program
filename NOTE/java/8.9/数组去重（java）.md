# 数组去重（java）

## 目前博主所了解的四种方法如下：

### 重不取，不重取

> 遍历数组，当遇到与后面的值有重复的跳过，反之取值

```java
loop:
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                   if (arr[i] == arr[j]) {
                    continue loop;
                }
            }
            System.out.println(arr[i]);
        }            
```



### 方法取

> 使用` Arrays.stream(arr).distinct().toArray()`方法

```java
        int[] arr1 = Arrays.stream(arr).distinct().toArray();
        System.out.println(Arrays.toString(arr1));
```

### 排序后当前与后一个不重取

>排序后,遍历数组，当遇到当前值与后一个的值重复跳过，反之取值

```java
// 排序
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1){//最后一个
                System.out.println(arr[i]);
            }else if (arr[i] != arr[i + 1]){
                System.out.println(arr[i]);
            }
        }
```



### 覆盖取

> 遍历数组,如果当前值重复,使用后一个值进行覆盖

```
		for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[i] == arr[j]){
                    arr[j] = arr[j + 1];
                }
            }
       }
```

## 完整示例：

```java
import java.util.Arrays;

/**
 * @title:Value_deduplication
 * @author:nanzhou
 * @date:2023.8.9
 */
public class Value_deduplication {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 3, 2, 1, 4, 0};
//        1、重不取，不重取
//        System.out.println(arr.length);
//        loop:
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] == arr[j]) {
//                    continue loop;
//                }
//            }
//            System.out.println(arr[i]);
//        }
//        2、方法取

//        int[] arr1 = Arrays.stream(arr).distinct().toArray();
//        System.out.println(Arrays.toString(arr1));

//       3、排序后当前与后一个不重取

//        // 排序
//        for (int i = 0; i < arr.length - 1; i++) {
//            int min = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[min]){
//                    min = j;
//                }
//            }
//            int temp = arr[i];
//            arr[i] = arr[min];
//            arr[min] = temp;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            if (i == arr.length - 1){//最后一个
//                System.out.println(arr[i]);
//            }else if (arr[i] != arr[i + 1]){
//                System.out.println(arr[i]);
//            }
//        }
//        4、覆盖取
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = i + 1; j < arr.length - 1; j++) {
//                if (arr[i] == arr[j]){
//                    arr[j] = arr[j + 1];
//                }
//            }
//        }
        System.out.print(Arrays.toString(arr));
    }
}

```

