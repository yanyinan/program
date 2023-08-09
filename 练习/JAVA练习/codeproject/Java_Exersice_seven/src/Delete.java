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
//        int[] newnums = new int[nums.length-1];
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 33) {
//                newnums[count++] = nums[i];
//            }
//        }
//        2. `System `类中的 `arraycopy `方法实现
        int[] newnums = Arrays.stream(nums).filter(x -> x != 33).toArray();
        System.out.println(Arrays.toString(newnums));
    }
}
