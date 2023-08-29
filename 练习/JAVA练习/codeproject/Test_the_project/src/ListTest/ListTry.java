package ListTest;

import java.util.*;

/**
 * @title:List接口实现动态数组
 * @author:nanzhou
 * @date:
 */
public class ListTry implements List {
    //容器
    private Object[] values;
    //存储元素数量
    private int size;
    //默认容量
    private static final int  DEFAULT_CAPACITY = 10;
    //默认定长增长
    private static final int DEFAULT_INCREMENT = 10;
    private static  int increment = 10;
    /**
     * 无参构造
     */
    public ListTry() {
        this(DEFAULT_CAPACITY, DEFAULT_INCREMENT);
    }

    /**
     * 指定容量有参构造
     * @param CAPACITY 指定容量
     */
    public ListTry(int CAPACITY) {
       this(CAPACITY, DEFAULT_INCREMENT);
    }

    /**
     * 指定容量、默认定长增长 有参构造
     * @param defaultCapacity 指定容量
     * @param defaultIcreament 指定定长增长
     */
    public ListTry(int defaultCapacity, int defaultIcreament) {
        if (defaultCapacity < 0 ) defaultCapacity = DEFAULT_CAPACITY;//给定默认容量小于0，指定容量为DEFAULT_CAPACITY
        if (defaultIcreament <= 0) defaultIcreament = DEFAULT_INCREMENT;//给定默认定长小于0，指定容量为DEFAULT_INCREMENT
        values = new Object[defaultCapacity];//容器初始化
        increment = defaultIcreament;//定长初始化
    }

    /**
     * 存储元素个数
     * @return 返回存储元素个数
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 判断容器内元素是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断容器内是否包含 element
     * @param o element whose presence in this list is to be tested
     * @return
     */
    @Override
    public boolean contains(Object o) {
        return switch (indexOf(o)) {
            case -1 -> false;
            default -> true;
        };
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     * 增加元素
     * @param o element whose presence in this collection is to be ensured （要添加的元素）
     * @return
     */
    @Override
    public boolean add(Object o) {
        expansion(size + 1);
        values[size++] = o;
        return false;
    }

    /**
     * 扩容
     * @param size 当前元素存储个数
     */
    private void expansion(int size) {
        if (size >= values.length) {
            Arrays.copyOf(values,values.length+ increment);
        }
    }

    /**
     * 移除指定元素
     * @param o element to be removed from this list, if present （指定元素）
     * @return 成功返回true，未找到指定元素返回 false
     */
    @Override
    public boolean remove(Object o) {
        int flag = indexOf(o);//判断是否存在
        if (flag != -1){//判断是否存在
            values[flag] = null;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    /**
     * 清空容器
     */
    @Override
    public void clear() {
        values = new Object[]{};
        size = 0;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    /**
     * 修改指定下标元素
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return
     */
    @Override
    public Object set(int index, Object element) {
        values[index] =element;
        return element;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {

        return null;
    }

    /**
     * 找出指定元素下标（从前往后）
     * @param o element to search for
     * @return 找到返回下标，未找到返回-1
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {//遍历元素
            if (values[i] == null && o == null) {//判断元素为null
                return i;
            }else {
                if (values[i].equals(o)){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 找出指定元素下标（从后往前）
     * @param o element to search for
     * @return 找到返回下标，未找到返回-1
     */
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size; i >=0 ; i--) {//遍历元素
            if (values[i] == null && o == null) {//判断元素为null
                return i;
            }else {
                if (values[i].equals(o)){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
