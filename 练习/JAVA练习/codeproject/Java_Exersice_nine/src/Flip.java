
import java.util.Arrays;

/**
 * @title:Flip
 * @author:nanzhou
 * @date:2023.8.11
 */
public class Flip {
    public static char[] flipChar(char[] arr) {
        char[] newarr = new char[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            newarr[i] = arr[i];
        }
        System.out.println(Arrays.toString(newarr));
        return newarr;
    }

    public static void main(String[] args) {
        char[] arr = {'1', '2', '3'};
        arr = flipChar(arr);
    }
}
