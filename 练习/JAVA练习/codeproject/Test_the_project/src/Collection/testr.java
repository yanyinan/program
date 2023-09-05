package Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class testr {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("s");
        for (String str : list) {
            if ("c".equals(str)) {
                list.remove(str);
            }
//            System.out.println(str);
        }
        System.out.println(list);
    }
}
