/**
 * @title:空心三角形
 * @author:nanzhou
 * @date:2023.08.04
 */
public class Demotest2 {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 1; i <= n; i++, System.out.println()) {
            for (int j = 9; j >= i; System.out.print("\t"), j--) ;
            for (int j = 1; j <= i; j++) {
                if (j == 1 | j == i | i == n ) {
                    System.out.print(" *");
                }
                if (i == j){}else {
                System.out.print("\t\t");}
            }
            ;
        }

    }
}
