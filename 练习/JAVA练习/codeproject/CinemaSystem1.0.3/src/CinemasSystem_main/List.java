package CinemasSystem_main;

import java.util.Arrays;
import java.util.Objects;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class List {
    /**
     * 存储元素容器
     */
    private Object[] list;//存储容器
    private int size;//记录元素个数
    private final int DEFAULT_SIZE = 10;//默认容量

    /**
     * 无参构造
     */
    public List() {
        list = new Object[DEFAULT_SIZE];
    }

    /**
     * 定义容器大小传参构造
     *
     * @param size 容器大小
     */
    public List(int size) {
//        判断数组大小是否合法
        if (size < 0) {
            size = DEFAULT_SIZE;
        }
        list = new Object[size];
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    /**
     * 添加元素
     *
     * @param obj 需要添加的元素
     */
    public void addList(Object obj) {
        if (size + 1 > list.length) {//如果容器满载
            growList();//扩容
        }
        list[size++] = obj;
    }

    /**
     * 容器扩容
     */
    private void growList() {
        list = Arrays.copyOf(list, list.length * 2 + 2);
    }

    /**
     * 删除指定下标容器元素
     *
     * @param index 待删除容器元素
     * @return 当前删除元素
     */
    public Object removeList(int index) {
        if (index < 0 && index > size) {
            return null;
        }
        Object removelist = list[index];
        System.arraycopy(list, index, list, index + 1, list.length - index - 1);
        list[--size] = null;
        return removelist;
    }

    /**
     * 删除指定元素
     *
     * @param obj 待删除元素
     * @return true 表示成功， false 失败
     */
    public boolean removeList(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj == null) {
                removeList(i);
                return true;
            } else {
                if (obj.equals(list[i])) {
                    removeList(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 根据下标获取元素
     *
     * @param index 元素下标
     * @return 该位置的元素，如果下标不合法，返回null
     */
    public Object getList(int index) {
        // 检查下标是否合法
        if (index < 0 || index >= size) {
            // 不合法， 报错 IndexOutOfBoundsException
            System.out.println("下标不合法");
            return null;
        }
        return list[index];
    }

    /**
     * 获取指定元素的下标
     *
     * @param obj 要查找的元素
     * @return 查找成功返回下标，失败返回-1
     */
    public int getList(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj == null) {
                return i;
            } else {
                if (obj.equals(list[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String str = "共有 " + size + " 个元素，分别是： \n";

        for (int i = 0; i < size; i++) {
            str += list[i];
            str += "\n";
        }
        return str;
    }
}
