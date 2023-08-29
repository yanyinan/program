package Test;

/**
 * @title:Correction_of_test_papers(2023.8.12)
 * @author:nanzhou
 * @date:2023.8.13
 */
public class Correction_of_test_papers {
    public static void test7() {
        int x = 0;
        for (; (x == 0) & (++x) > 0; x++) ;
        System.out.println(x);
    }

    public static void test9(){
        int i = 10;
        do {
            i = i / 2;
        }while (i-- >1);
        System.out.println(i);
    }
    public static void main(String[] args) {
//        test7();
        test9();
    }
}
