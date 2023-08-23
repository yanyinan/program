package Generateluckynumbers;

import java.util.Arrays;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * 随机生成 20 个 1~ 40 之间的不重复幸运数字存储到数组中。 要求:
 * 。数组中的数字乱序
 */
import java.util.Arrays;
import java.util.Random;

public class GenerateLuckyNumber {
    public static int[] luckyNumber() {
        int[] n = new int[20];

        // 生成不重复的数字
        Random rand = new Random();
        for (int i = 0; i < n.length; i++) {
            int randomNumber = rand.nextInt(40) + 1;
            while (contains(n, randomNumber)) {
                randomNumber = rand.nextInt(40) + 1;
            }
            n[i] = randomNumber;
        }

        // 打乱数组顺序
        shuffleArray(n);

        return n;
    }

    public static void main(String[] args) {
        int[] luckyNumbers = luckyNumber();
        System.out.println(Arrays.toString(luckyNumbers));
    }

    // 判断数组中是否包含某个数字
    public static boolean contains(int[] array, int number) {
        for (int value : array) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }

    // Fisher-Yates 洗牌算法
    public static void shuffleArray(int[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}

