package Test;

import java.util.Scanner;

/**
 * @title:回文数
 * @author:nanzhou
 * @date:
 */

public class test {
    /**
     * 打印心形
     */
    public static void main(String[] args) {
        for (float y = (float) 1.5; y > -1.5; y -= 0.1) {
            for (float x = (float) -1.5; x < 1.5; x += 0.05) {
                float a = x * x + y * y - 1;
                if ((a * a * a - x * x * y * y * y) <= 0.0) {
                    System.out.print("**");
                } else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}
