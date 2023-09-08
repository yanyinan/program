import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class FightUtil {
    /**
     * 游戏启动
     */
    public static void start() {
        Poker fight = new Poker(true,"Fight");
        prepare(fight.PlayingCardPrePreparation()).forEach(e -> System.out.println(e));
    }

    /**
     * 游戏准备
     * @param pokerCardsLists
     * @return
     */
    public static List<List<String>> prepare(List<PokerCardsList.PokerCard> pokerCardsLists) {
        /**
         * 三个玩家和底牌
         */
        List<PokerCardsList.PokerCard> player1 = new ArrayList<>();
        List<PokerCardsList.PokerCard> player2 = new ArrayList<>();
        List<PokerCardsList.PokerCard> player3 = new ArrayList<>();
        List<PokerCardsList.PokerCard> bottom = new ArrayList<>();
        deal(player1, player2, player3, bottom, pokerCardsLists);
        return PokerSort(player1, player2, player3, bottom, pokerCardsLists);
    }

    /**
     * 发牌
     * @param player1         玩家1
     * @param player2         玩家2
     * @param player3         玩家3
     * @param bottom          底牌
     * @param pokerCardsLists 乱序牌堆
     * @return
     */
    private static List<List<String>> PokerSort(List<PokerCardsList.PokerCard> player1, List<PokerCardsList.PokerCard> player2, List<PokerCardsList.PokerCard> player3, List<PokerCardsList.PokerCard> bottom, List<PokerCardsList.PokerCard> pokerCardsLists) {
        List<String> p1 = player1.stream()
                .sorted((a, b) -> a.getOder() - b.getOder())
                .map(a -> a.getCard())
                .collect(Collectors.toList());
        List<String> p2 = player2.stream()
                .sorted((a, b) -> a.getOder() - b.getOder())
                .map(a -> a.getCard())
                .collect(Collectors.toList());
        List<String> p3 = player3.stream()
                .sorted((a, b) -> a.getOder() - b.getOder())
                .map(a -> a.getCard())
                .collect(Collectors.toList());
        List<String> bot = bottom.stream()
                .map(a -> a.getCard())
                .collect(Collectors.toList());
        // 结果
        List<List<String>> result = List.of(p1, p2, p3, bot);
        return result;
    }

    /**
     * 发牌
     *
     * @param player1         玩家1
     * @param player2         玩家2
     * @param player3         玩家3
     * @param bottom          底牌
     * @param pokerCardsLists 乱序牌堆
     */
    private static void deal(List<PokerCardsList.PokerCard> player1, List<PokerCardsList.PokerCard> player2, List<PokerCardsList.PokerCard> player3, List<PokerCardsList.PokerCard> bottom, List<PokerCardsList.PokerCard> pokerCardsLists) {
        for (int i = 0; i < pokerCardsLists.size(); i++) {
            if (pokerCardsLists.size() - 3 > i) {
                switch (i % 3) {
                    case 0 -> player1.add(pokerCardsLists.get(i));
                    case 1 -> player2.add(pokerCardsLists.get(i));
                    default -> player3.add(pokerCardsLists.get(i));
                }
            } else {
                bottom.add(pokerCardsLists.get(i));
            }
        }
    }
}
