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
