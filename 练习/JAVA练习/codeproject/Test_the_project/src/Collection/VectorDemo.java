package Collection;

import java.util.Comparator;
import java.util.Vector;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class VectorDemo {
    public static void main(String[] args) {
        // 初始容量为 10 的 Vector 对象
        Vector vector = new Vector();

//        vector = new Vector(15);

        System.out.println(vector.size());

        vector.add("a");

        vector.add("b");

        vector.add("a");

//        vector.add(null);

        vector.add(1, "c");

        System.out.println(vector); // a c b a

//        vector.sort(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                String str1 = (String) o1;
//                String str2 = (String) o2;
//
//                return str1.compareTo(str2);
//            }
//        });

        sort(vector, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String str1 = (String) o1;
                String str2 = (String) o2;

                return str1.compareTo(str2);
            }
        });

        System.out.println(vector);
    }

    public static void sort(Vector list, Comparator comparator) {

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                // 比较器
                int result = comparator.compare(list.get(j), list.get(j + 1));
                if (result > 0) {
                    Object temp = list.get(j);

                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }

            }
        }
    }
}
