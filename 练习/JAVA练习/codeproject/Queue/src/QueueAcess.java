import java.util.Arrays;
import java.util.Objects;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class QueueAcess extends Queue{
    private static final int DEFAULT_CAPACITY = 10;
    private static Object[] objects = new Object[DEFAULT_CAPACITY];
    int size = 0;
    /**
     * 将元素插入队尾
     * @param element 要插入的元素
     */
    @Override
    public void enqueue(Object element) {
        expansion();
        objects[size] = element;
        size ++;
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
     * 移除并返回队首元素
     * 删除第一个元素，并返回
     * @return 队首元素, 如果队列为空时，返回 null
     */
    @Override
    public Object dequeue() {
        if (size == 0) {
            return null;
        } else {
            Object obj = objects[0];
            size --;
            System.arraycopy(objects, 1, objects, 0, size);
            return obj;
        }
    }

    /**
     * 返回队首元素，但不移除
     * @return 队首元素
     */
    @Override
    Object peek() {
        return objects[0];
    }

    /**
     * 检查队列是否为空
     * @return 如果队列为空则返回true，否则返回false
     */
    @Override
    boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回队列中的元素个数
     * @return 队列中元素的个数
     */
    @Override
    int size() {
        return size;
    }

    @Override
    public String toString() {
        Object[] tempArrays = new Object[size];
        System.arraycopy(objects, 0, tempArrays, 0, size);
        return Arrays.toString(tempArrays);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        // 判断大小是否相等
        QueueAcess other = (QueueAcess) obj; // 对象类型匹配，进行类型转换
        if (other.size() != this.size()) {
            return false;
        }
        // 比较两个栈的底层数组是否相等。
        return Arrays.equals(this.objects, other.objects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(objects), size);
    }
}