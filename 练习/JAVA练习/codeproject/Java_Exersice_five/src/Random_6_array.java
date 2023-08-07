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
