import java.util.Scanner;
/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double d= scanner.nextDouble();
        //write your code here......
        int i = (int) (d * 100);
        int temp = i%100;
        if (temp > 50){
            i = i/100+1;
        }else {i = i/100;}
        System.out.println(i);
    }
}