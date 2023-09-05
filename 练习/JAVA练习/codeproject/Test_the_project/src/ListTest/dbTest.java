package ListTest;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class dbTest {
    public static void main(String[] args) {
        DdLinkList test = new DdLinkList();

        test.add("q");
        test.add("z");
        test.add("x");
        test.add("c");
        test.add("g");
//        System.out.println(test.get(2));
//        test.add(2,"1");
//        test.remove(2);
//        System.out.println(test.remove(5));
        System.out.println(test);
        System.out.println(test.remove("g"));
        System.out.println(test);
//        System.out.println(test.get(4));
//        System.out.println(test.size());
//        System.out.println(test.subList(0,3));
//        System.out.println(test.indexOf("q"));
//        System.out.println(test.get(1));
    }

}
