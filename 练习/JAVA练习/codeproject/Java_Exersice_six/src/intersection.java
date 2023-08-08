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
