/**
 * @title:水仙花数
 * @author:nanzhou
 * @date:2023.8.7
 */
public class Examtest2 {
    public static void main(String[] args) {
        int num_1, num_2, num_3;
        for (int i = 100;i < 1000; i++){
            num_1 = i / 100;
            num_2 = i / 10 % 10;
            num_3 = i % 10;
            if (Math.pow(num_1,3)+Math.pow(num_2,3)+Math.pow(num_3,3) == i){
                System.out.println(i);
            }
        }
    }
}
