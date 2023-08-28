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
    int size;
    /**
     * 将元素插入队尾
     * @param element 要插入的元素
     */
    @Override
    public void enqueue(Object element) {
        //判断是否需要扩容
        if (size + 1 > objects.length) expansion();
        //插入
        objects[size] = element;
        //计数
        size ++;
    }
    /**
     * 扩容
     */
    private void expansion() {
        //容量
        int oldCapacity = objects.length;
        //新容量
        int newCapacity = objects.length << 2;
        //判断容量是否正常增加
        if (newCapacity < oldCapacity) newCapacity = Integer.MAX_VALUE;
        //扩容
        objects = Arrays.copyOf(objects, newCapacity);
    }

    /**
     * 移除并返回队首元素
     * 删除第一个元素，并返回
     * @return 队首元素, 如果队列为空时，返回 null
     */
    @Override
    public Object dequeue() {
        if (size == 0) {
            //判空
            return null;
        } else {
            //移除返回
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

    /**
     * 重写toString
     * @return
     */
    @Override
    public String toString() {
        Object[] tempArrays = new Object[size];
        System.arraycopy(objects, 0, tempArrays, 0, size);
        return Arrays.toString(tempArrays);
    }

    /**
     * 重写equals
     * @param obj
     * @return
     */
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

    /**
     * 重写hashcode
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(objects), size);
    }
}