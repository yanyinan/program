import java.util.Date;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Datetest1 {
    public static void main(String[] args) {
        Date date = new Date(99, 1, 1);
        System.out.println(date);
        long time = date.getTime();
        System.out.println(time);
        Date date1 = new Date(164088600000L);
        System.out.println(date1);

    }
}
