package Collection;

import java.util.Stack;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Statck {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

//        System.out.println(stack.indexOf(5)); // 0 indexOf 首次出现位置的索引
//        System.out.println(stack.pop()); // 5
//        System.out.println(stack.peek()); // 4

        System.out.println(stack.search(1));
        System.out.println(stack.search(5));
    }
}
