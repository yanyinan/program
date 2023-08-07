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
