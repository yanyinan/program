import java.util.Arrays;
import java.util.Objects;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Stackaccess extends Stack {
    private static final int DEFAULT_CAPACITY = 10;//设置初始数组长度
    private static Object[] objects = new Object[DEFAULT_CAPACITY];
    int size = 0;
    /**
     * 将元素压入栈顶
     * 入栈
     * @param element 要压入的元素
     */
    @Override
    public void push(Object element) {
        expansion();
        objects[size] = element;
        size++;
    }

    /**
     * 弹出栈顶元素并返回
     * 把栈顶元素删除，并返回
     * 出栈
     *
     * @return 弹出的栈顶元素, 如果栈为空返回 null
     */
    @Override
    public Object pop() {
        if (size == 0) {
            //判断是否为空
            return null;
        } else {
            Object obj = objects[--size];
            objects[size] = null;
            return obj;
        }
    }

    /**
     * 返回栈顶元素，但不弹出
     *
     * @return 栈顶元素
     */
    @Override
    public Object peek() {

        return objects[size - 1];
    }

    /**
     * 检查栈是否为空
     *
     * @return 如果栈为空则返回true，否则返回false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回队列中的元素个数
     *
     * @return 队列中元素的个数
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 扩容
     */
    private void expansion() {
        if (size == objects.length) {
            int newCapacity = objects.length + objects.length / 2;
            objects = Arrays.copyOf(objects, newCapacity);
        }
    }

    /**
     * 重写toString方法
     */

    @Override
    public String toString() {
        Object[] tempArrays = new Object[size];
        System.arraycopy(objects, 0, tempArrays, 0, size);
        return Arrays.toString(tempArrays);
    }

    /**
     * 重写equals方法
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        // 判断大小是否相等
        Stackaccess other = (Stackaccess) obj; // 对象类型匹配，进行类型转换
        if (other.size() != this.size()) {
            return false;
        }
        // 比较两个栈的底层数组是否相等。
        return Arrays.equals(objects, objects);
    }

    /**
     * 重写hashCode方法
     */
    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(objects), size);
    }
}