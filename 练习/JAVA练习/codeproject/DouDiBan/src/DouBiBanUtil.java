import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class DouBiBanUtil {
    static Scanner scanner = new Scanner(System.in);
    static int countPlayer1 = 0;
    static int countPlayer2 = 0;
    static int cardNumPlayer1 = 0;
    static int cardNumPlayer2 = 0;
    static List<PokerCardsList.PokerCard> player1 = new ArrayList<>();
    static List<PokerCardsList.PokerCard> player2 = new ArrayList<>();
    //还可拿
    static final int num = 8;
    /**
     * 游戏启动
     */
    public static void start() {
        Poker fight = new Poker(false,"DouBiBan");
        prepare(fight.PlayingCardPrePreparation());
    }
    /**
     * 游戏准备
     *
     * @param pokerCards
     * @return
     */
    private static void prepare(List<PokerCardsList.PokerCard> pokerCards) {
        /**
         * player1 电脑
         * player2 玩家
         */
        System.out.println(gameStart(player1, player2, pokerCards));
    }

    private static String gameStart(List<PokerCardsList.PokerCard> player1, List<PokerCardsList.PokerCard> player2, List<PokerCardsList.PokerCard> pokerCards) {
        fristtake(pokerCards);
        boolean flag1 = false;
        boolean flag2 = false;
        //Todo 轮流发牌问题，如何选择拿
        for (int i = 1; i < pokerCards.size(); i++) {
            System.out.println("player1,输入1拿，其他跳过");
            if (scanner.nextInt() == 1){ flag1 = true;}
            if (flag1) {
                player1.add(pokerCards.get(i));
                System.out.println(player1.get(cardNumPlayer1).getCard());
                countPlayer1 += player1.get(cardNumPlayer1).getOder();
                System.out.println("目前点数为"+countPlayer1);
                cardNumPlayer1++;
                flag1 = false;
                //check
                if (check(countPlayer1, countPlayer2, cardNumPlayer1, cardNumPlayer2) != null) {
                    return check(countPlayer1, countPlayer2, cardNumPlayer1, cardNumPlayer2);
                }
            }
            if (flag1 = false){
                System.out.println("player2,输入2拿，其他跳过");
                if (scanner.nextInt() == 2){flag2 = true;}
                if (flag2){
                    player2.add(pokerCards.get(i));
                    System.out.println(player2.get(cardNumPlayer2).getCard());
                    countPlayer2 += player2.get(cardNumPlayer2).getOder();
                    System.out.println("  目前点数为"+countPlayer2);
                    cardNumPlayer2++;
                    if (check(countPlayer1, countPlayer2, cardNumPlayer1, cardNumPlayer2) != null) {
                        return check(countPlayer1, countPlayer2, cardNumPlayer1, cardNumPlayer2);
                    }
                }else {
                    return  "对局结束";
                }
            }
//                System.out.println("player2,输入1拿，其他跳过");
//                if (scanner.nextInt() == 2) {
//                    player2.add(pokerCards.get(i));
//                    System.out.println(player2.get(cardNumPlayer2).getCard());
//                    countPlayer2 += player2.get(cardNumPlayer2).getOder();
//                    cardNumPlayer2++;
//                    if (check(countPlayer1, countPlayer2, cardNumPlayer1, cardNumPlayer2) != null) {
//                        return check(countPlayer1, countPlayer2, cardNumPlayer1, cardNumPlayer2);
//                    }
//                }
//            }
        }
        return "对局结束";

    }

    private static void fristtake(List<PokerCardsList.PokerCard> pokerCards) {
        System.out.println("player2拿");
        player2.add(pokerCards.get(0));
        System.out.println(player2.get(cardNumPlayer2).getCard());
        countPlayer2 += player2.get(cardNumPlayer2).getOder();
        System.out.println("目前点数为"+countPlayer2);
        cardNumPlayer2++;
    }

    private static String check(int countPlayer1, int countPlayer2, int cardNumPlayer1, int cardNumPlayer2) {
        if (countPlayer2 > 105) {
            return "玩家1获胜,点数为" + countPlayer1 + "，手中牌数为" + cardNumPlayer1 + "玩家2点数为" + countPlayer2 + "，手中牌数为" + cardNumPlayer2;
        } else if (countPlayer1 > 105) {
            return "玩家2获胜,点数为" + countPlayer2 + "，手中牌数为" + cardNumPlayer2 + "玩家1点数为" + countPlayer1 + "，手中牌数为" + cardNumPlayer1;
        }
        return null;
    }
}
