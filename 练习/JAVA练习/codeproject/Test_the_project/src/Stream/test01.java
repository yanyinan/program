package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class test01 {
    public static void main(String[] args) {
        List<String> listTest = new ArrayList<>();
        listTest.add("一指禅");
        listTest.add("二指禅");
        listTest.add("三指禅");
        listTest.add("四指禅");
        listTest.add("五指禅");
        listTest.add("六指禅");
        listTest.add("七指禅");
        Stream<String>  stream = listTest.stream();
//        Stream<String> result = stream.filter(e -> !e.contains("一"));
        Stream<String> stream1 = stream.sorted();
        stream1.forEach(e -> System.out.println(e));
    }
}
