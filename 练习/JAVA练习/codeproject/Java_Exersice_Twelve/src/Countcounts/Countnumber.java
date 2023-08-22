package Countcounts;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

import java.util.Scanner;

/**
 * 统计个数
 * 请编写程序，由键盘录入一个字符串，统计字符串中英文字母和数字分别有多少个。比如：Hello12345World中字母：10个，数字：5个。
 */
public class Countnumber {
    public int[] countCounts(String str){
        int[] count = {0,0};
        String temp = str.toLowerCase();
        for (int i = 0; i < temp.length(); i++) {
            char tempstr = temp.charAt(i);
            if (tempstr >= 97 && tempstr <= 122){
                count[0]++;
            }else if (tempstr >= 48 && tempstr <= 57){
                count[1]++;
            }
        }
        return count;
    }


}
