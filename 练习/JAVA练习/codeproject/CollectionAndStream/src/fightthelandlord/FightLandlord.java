package fightthelandlord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ## 斗地主
 * <p>
 * 有一个集合保存扑克牌的花色(四种)，另一个集合保存扑克牌点数(13个)。创建一个新的集合保存所有的扑克牌(54张，包含 大小王)。将扑克牌分为四份（3个玩家，1份底牌），排序后输出四份手牌。
 * <p>
 * ```java
 * List<String> flower; // 存花色
 * List<String> points; // 存点数
 * <p>
 * List<String> poker; // 扑克牌
 * <p>
 * List<String> player1; // 玩家一
 * List<String> player2; // 玩家二
 * List<String> player3; // 玩家三
 * List<String> bottom; // 底牌
 * ```
 *
 * @author:nanzhou
 * @date:
 */
public class FightLandlord {

    public static void main(String[] args) {
        PokerCards pokerCards = new PokerCards();
        List<String> pokerList = pokerCards.getSuits().stream()
                .flatMap(suit -> pokerCards.getRanks().stream().map(rank -> suit + rank))
                .collect(Collectors.toList());
        pokerList.add("Joker");
        pokerList.add("joker");
        System.out.println(pokerList);
        Collections.shuffle(pokerList);
        System.out.println(pokerList);
        // 玩家一
        List<String> player1 = new ArrayList<>();
        // 玩家二
        List<String> player2 = new ArrayList<>();
        // 玩家三
        List<String> player3 = new ArrayList<>();
        // 底牌
        List<String> bottom = new ArrayList<>();
        for (int i = 0; i < pokerList.size(); i++) {
            if (pokerList.size() - 3 > i) {
                switch (i % 3) {
                    case 0 -> player2.add(pokerList.get(i));
                    case 1 -> player1.add(pokerList.get(i));
                    default -> player3.add(pokerList.get(i));
                }
            } else {
                bottom.add(pokerList.get(i));
            }
        }
        player1.stream().sorted().forEach(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println("Player1" + player1);
        System.out.println("Player1" + player2);
        System.out.println("Player1" + player3);
        System.out.println("Bottom" + bottom);

    }
}

class PokerCards {
    private static final List<String> suits = new ArrayList<>();
    private static final List<String> ranks = new ArrayList<>();
    static {
        // 黑桃 (Spade)
        suits.add("\u2660");
        // 红心 (Heart)
        suits.add("\u2665");
        // 梅花 (Club)
        suits.add("\u2663");
        // 方块 (Diamond)
        suits.add("\u2666");

        ranks.add("2");
        ranks.add("A");
        ranks.add("K");
        ranks.add("Q");
        ranks.add("J");
        ranks.add("10");
        ranks.add("9");
        ranks.add("8");
        ranks.add("7");
        ranks.add("6");
        ranks.add("5");
        ranks.add("4");
        ranks.add("3");
    }
    public PokerCards() {

    }
    public List<String> getRanks() {
        return ranks;
    }

    public List<String> getSuits() {
        return suits;
    }
}