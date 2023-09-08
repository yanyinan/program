package fightthelandlord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Poker {
    /**
     * 暂存poker
     */
    private PokerCardsList poker;
    /**
     * 洗牌次数
     */
    private final int pokerNum = 3;

    /**
     * 无限定大小王构造
     */
    public Poker(String gameSytle) {
        this(true, gameSytle);
    }

    /**
     * 限定大小王构造
     *
     * @param kingFlag true 为有，反之为无
     */
    public Poker(Boolean kingFlag, String gameSytle) {
        if (kingFlag) {
            poker = new PokerCardsList(gameSytle);
        } else {
            poker = new PokerCardsList(false, gameSytle);
        }

    }

    /**
     * 扑克牌预准备
     *
     * @return 返回洗牌后牌堆
     */
    public List<PokerCardsList.PokerCard> PlayingCardPrePreparation() {
        // 扑克牌
        List<PokerCardsList.PokerCard> pokerCardsLists = this.poker.getPokers();
        // 洗牌
        for (int i = 0; i < pokerNum; i++) {
            Collections.shuffle(pokerCardsLists);
        }
        return pokerCardsLists;
    }
}

/**
 * 牌堆
 */
class PokerCardsList {
    /**
     * 花色
     */
    private static final List<String> suits = new ArrayList<>();
    /**
     * 点数
     */
    private static final List<String> ranks = new ArrayList<>();

    //初始化基本牌
    static {
        /**
         * 花色
         */
        // 黑桃 (Spade)
        suits.add("\u2660");
        // 红心 (Heart)
        suits.add("\u2665");
        // 梅花 (Club)
        suits.add("\u2663");
        // 方块 (Diamond)
        suits.add("\u2666");

    }

    /**
     * 暂存牌
     */
    private List<PokerCard> pokers;

    public PokerCardsList(String gameSytle) {
        this(true, gameSytle);
    }

    /**
     * 参数构造
     *
     * @param kingFlag
     */
    public PokerCardsList(Boolean kingFlag, String gameSytle) {
        /**
         * 牌序列
         */
        //Todo 根据需求添加序列
        if ("Fight".equals(gameSytle)) {
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
        } else if ("DouDiBan".equals(gameSytle)) {
            ranks.add("A");
            ranks.add("2");
            ranks.add("3");
            ranks.add("4");
            ranks.add("5");
            ranks.add("6");
            ranks.add("7");
            ranks.add("8");
            ranks.add("9");
            ranks.add("10");
            ranks.add("J");
            ranks.add("Q");
            ranks.add("K");
        }

        pokers = new ArrayList<>();
        AtomicInteger i = new AtomicInteger(0);
        suits.stream().forEach(s -> {
            AtomicInteger j = new AtomicInteger(0);
            ranks.forEach(r -> {
                //Todo 根据需求添加order
                int temp = j.getAndIncrement();
                if ("Fight".equals(gameSytle)) {
                    temp = 4 * j.getAndIncrement() + i.getAndIncrement() + j.get() + 2;
                } else if ("DouDiBan".equals(gameSytle)) {
                    temp = (j.getAndIncrement() + 1) % 10;
                }
                pokers.add(new PokerCard(s, r, temp));
            });
        });
        if (kingFlag) {
            pokers.add(new PokerCard(null, "大王", 0));
            pokers.add(new PokerCard(null, "小王", 1));
        }
    }

    /**
     * 返回填充牌堆
     *
     * @return 完成填充牌堆
     */
    public List<PokerCard> getPokers() {
        return pokers;
    }

    /**
     * 牌面
     */
    class PokerCard {
        //花色
        private String color;
        //点数
        private String point;
        //序列
        private Integer oder;

        //构造
        public PokerCard(String color, String point, Integer oder) {
            this.color = color;
            this.point = point;
            this.oder = oder;
        }

        //获取花色
        public String getColor() {
            return color;
        }

        //获取点数
        public String getPoint() {
            return point;
        }

        //获取序列
        public Integer getOder() {
            return oder;
        }

        //牌面
        public String getCard() {
            return color == null ? point : color + point;
        }
    }
}

