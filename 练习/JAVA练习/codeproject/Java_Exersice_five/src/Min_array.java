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
