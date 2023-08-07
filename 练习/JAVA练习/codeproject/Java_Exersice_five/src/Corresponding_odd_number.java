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
