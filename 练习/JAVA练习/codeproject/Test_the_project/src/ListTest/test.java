package ListTest;

import java.util.List;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class test {
    public static void main(String[] args) {
//        ListTry myList = new ListTry();
//        // Testing add method
//        myList.add("Element 1");
//        myList.add("Element 2");
//        myList.add("Element 3");
//
//        System.out.println("Size: " + myList.size()); // Should print 3
//
//        // Testing get method
//        System.out.println("Element at index 1: " + myList.get(1)); // Should print "Element 2"
//
//        // Testing remove method
//        myList.remove(1);
//        System.out.println("Size after removing: " + myList.size()); // Should print 2
////        System.out.println(myList.subList(1, 2));
//        // Testing subList method
//        ListTry subList = (ListTry) myList.subList(0, 1);
//        System.out.println("Sublist size: " + subList.size()); // Should print 1

        LinkList linked = new LinkList();
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");
//        System.out.println(linked.size());
//        System.out.println(linked.remove(1));
//        Object[] o = linked.toArray();
//        for (Object element : o) {
//            System.out.println(element);
//        }
//        System.out.println("print");
//        linked.clear();
//        Object[] o1 = linked.toArray();
//        for (Object element : o1) {
//            System.out.println(element);
//        }
//        linked.set(1,"ad");
//        Object[] o1 = linked.toArray();
//        for (Object element : o1) {
//            System.out.println(element);
//        }
//        System.out.println(linked.get(1));
//        System.out.println(linked.indexOf("a"));

        Object[] o1 = linked.subList(1,2).toArray();
        for (Object element : o1) {
            System.out.println(element);
        }
//        System.out.println(linked.size());
//        System.out.println(linked.get(1));
//        System.out.println(linked.subList(0,2));

    }
}
