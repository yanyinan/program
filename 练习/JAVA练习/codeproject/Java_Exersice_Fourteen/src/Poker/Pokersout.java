package Poker;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * Poker
 * //定义两个数组，一个数组存储扑克牌花色，另一个数组存储扑克牌（A~K），输出52张扑克牌（除大小王）
 * //♥A、♥2...
 */
public class Pokersout {
    public static void sout() {
        Character[] assortment = {'♥', '♠', '♣', '♦'};
        String[] poker = {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "J", "Q", "K"
        };
        for (char i : assortment) {
            for (String j : poker) {
                System.out.print(i+j+"\t");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Pokersout.sout();
    }
}
