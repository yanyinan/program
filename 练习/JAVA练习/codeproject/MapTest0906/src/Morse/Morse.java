package Morse;


import java.util.HashMap;
import java.util.Map;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * ## 摩尔斯密码
 *
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如:
 *
 * 'a' 对应 ".-" ，
 * 'b' 对应 "-..." ，
 * 'c' 对应 "-.-." ，以此类推。
 * 为了方便，所有 26 个英文字母的摩尔斯密码表如下：
 *
 * ```
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * ```
 *
 * 给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
 *
 * 例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻译 。
 * 对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量
 *
 * 示例 1：
 *
 * ```
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * 共有 2 种不同翻译, "--...-." 和 "--...--."
 * ```
 *
 *
 *
 *
 * 示例 2：
 *
 * ```
 * 输入：words = ["a"]
 * 输出：1
 * ```
 *
 * **提示：**
 *
 * - `1 <= words.length <= 100`
 * - `1 <= words[i].length <= 12`
 * - `words[i]` 由小写英文字母组成
 */
public class Morse {
    private static final Map<Character, String> morseCodeMap = new HashMap<>();//密码本容器
    static {//静态初始化莫尔斯编码
        morseCodeMap.put('a', ".-");
        morseCodeMap.put('b', "-...");
        morseCodeMap.put('c', "-.-.");
        morseCodeMap.put('d', "-..");
        morseCodeMap.put('e', ".");
        morseCodeMap.put('f', "..-.");
        morseCodeMap.put('g', "--.");
        morseCodeMap.put('h', "....");
        morseCodeMap.put('i', "..");
        morseCodeMap.put('j', ".---");
        morseCodeMap.put('k', "-.-");
        morseCodeMap.put('l', ".-..");
        morseCodeMap.put('m', "--");
        morseCodeMap.put('n', "-.");
        morseCodeMap.put('o', "---");
        morseCodeMap.put('p', ".--.");
        morseCodeMap.put('q', "--.-");
        morseCodeMap.put('r', ".-.");
        morseCodeMap.put('s', "...");
        morseCodeMap.put('t', "-");
        morseCodeMap.put('u', "..-");
        morseCodeMap.put('v', "...-");
        morseCodeMap.put('w', ".--");
        morseCodeMap.put('x', "-..-");
        morseCodeMap.put('y', "-.--");
        morseCodeMap.put('z', "--..");
        morseCodeMap.put(' ', "/"); // 空格用"/"表示
    }

    /**
     *输出相同个数
     * @param words 单词本
     * @return 长度相同个数
     */
    private static int MorseMach(String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char[] chars =  words[i].toCharArray();
            String strTemp = "";
            for(char ch :chars){
                strTemp += morseCodeMap.get(ch);
            }
            map.put(strTemp,map.getOrDefault(strTemp,0)+1);
        }
//        System.out.println(map);
        return map.size();
    }
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(MorseMach(words));
    }
}
