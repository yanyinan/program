package Test;

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
//
//            }
//        }
        System.out.print(Arrays.toString(arr));
    }
}
