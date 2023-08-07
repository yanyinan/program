import java.util.Scanner;

/**
 * @title:斐波那契数
 * @author:nanzhou
 * @date:2023.8.7
 */
public class Examtest3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = 0,j = 1;
        int n = input.nextInt();
        for (int num = 1;num <= n;num ++){
            if(num == 1){
                System.out.println(j);
            }else {
                int temp = i;
                i = j;
                j = temp +j;
                System.out.println(j);
            }
        }
    }
}
