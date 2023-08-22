package Countcounts;

import java.util.Scanner;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Countnumber countnumber = new Countnumber();
        int[] count = countnumber.countCounts(input.next());
        System.out.println("字母个数：" + count[0] + "，数字个数：" + count[1]);
    }
}
