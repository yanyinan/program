import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Short, String> map = new HashMap<>();
        for (short i = 0; i < 100; i ++){
            map.put(i, String.valueOf(i));
            map.remove((short)(i-1));
        }
        System.out.println(map.size());
    }
}