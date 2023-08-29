package Test;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Test0828 {
    public static String reverseLeftWords(String s, int n) {
        return  s.substring(n, s.length() + 1) + s.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(Test0828.reverseLeftWords("reverseLeftWords",5));
    }
}
