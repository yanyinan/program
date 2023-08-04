import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 3; i++, System.out.println()) {
            for (int j = 9; j >= i; System.out.print(" " ), j--) ;
            for (int j = 1; j <= i; System.out.print(" *" ), j++) ;
        }
        for (int i = 4; i <= 5; i++, System.out.println()) {
            for (int j = 9; j >= i; System.out.print(" " ), j--) ;
            for (int j = 1; j <= i; System.out.print(" *" ), j++) ;
        }
        for (int i = 4; i <= 7; i++, System.out.println()) {
            for (int j = 9; j >= i; System.out.print(" " ), j--) ;
            for (int j = 1; j <= i; System.out.print(" *" ), j++) ;
        }
        for (int i = 4; i <= 8; i++, System.out.println()) {
            for (int j = 9; j >= i; System.out.print(" " ), j--) ;
            for (int j = 1; j <= i; System.out.print(" *" ), j++) ;
        }
        for (int i = 1; i <= 5; i++, System.out.println()) {
//            for (int j = 4; j >= i; System.out.print(" " ), j--) ;
            for (int j = 1; j <= 6; System.out.print(" " ), j++) ;
            for (int j = 1; j <= 4; System.out.print(" *" ), j++) ;

        }

//        for (int i = 1; i <= 8; i++, System.out.println()) {
//            for (int j = 1; j <= i+1; System.out.print(" " ), j++) ;
//            for (int j = 8; j >= i; System.out.print(" *" ), j--) ;
//        }

    }
}