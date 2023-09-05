package ListTest;

import org.w3c.dom.Node;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class LinkList implements List {
    //头指针
    private Node first;
    //容器元素个数
    private int size;

    /**
     * 返回链表长度
     *
     * @return 返回链表长度
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 判断是否为空
     *
     * @return 空为 true 反之 false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断元素是否被包含
     *
     * @param o element whose presence in this list is to be tested 被判断元素
     * @return 包含返回 true ，反之 false
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;//调用indexOf(o)
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size]; // 创建一个Object类型的数组
        Node c = first; // 从链表的头部开始遍历
        int index = 0; // 数组索引
        while (c != null) {
            objects[index++] = c.value; // 将当前节点的值赋给数组中相应位置
            c = c.next; // 移动到下一个节点
        }
        return objects; // 返回填充好的数组
    }

    /**
     * 链表添加元素
     *
     * @param o element whose presence in this collection is to be ensured
     * @return 添加成功返回 true
     */
    @Override
    public boolean add(Object o) {
        Node current = new Node(o, null); // 当前要添加的 节点
        if (first == null) {//判断首节点是否为空
            first = current;
        } else {
            Node c = first;
            while (c.next != null) {//判断为空的 next
                c = c.next;
            }
            c.next = current;
            c.next = current;
        }
        size++;//计数加1
        return true;
    }

    /**
     * 移除给定元素
     *
     * @param o element to be removed from this list, if present 被移除元素
     * @return 成功返回true
     */
    @Override
    public boolean remove(Object o) {
        if (first == null) {
            return false; // 空链表，无法删除
        }
        Node sentinel = new Node(null, first); // 哨兵节点
        Node prev = sentinel;
        Node curr = first;
        while (curr != null) {
            if (curr.value.equals(o)) {
                prev.next = curr.next; // 删除当前节点
                curr.next = null; // 断开删除节点的连接
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false; // 没有找到要删除的节点
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
     * 清空链表
     */
    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    /**
     * 获取指定位数元素
     *
     * @param index index of the element to return 指定位数
     * @return 找到返回 元素， 反之返回 null
     */
    @Override
    public Object get(int index) {
        if (!legalIndex(index)) return null;
        Node point = first;
        for (int i = 0; i < index; i++) {
            point = point.next;
        }
        return point.value;
    }

    /**
     * 修改指定元素位置元素
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     */
    @Override
    public Object set(int index, Object element) {
        if (!legalIndex(index)) return null;
        Node c = first;
        // 找到 index 位的节点  0 不需要 next   1 进行 .next
        for (int i = 0; i < index; i++) {
            c = c.next;
        }
        Object old = c.value; // 旧值
        c.value = element;
        return old;
    }

    /**
     * 指定位置添加指定元素
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > size + 1) {
        } else {
            if (index == 0) {
                first = new Node(element, first);
            } else {
                Node pre = first;
                Node c = first.next;
                // 原来这个位置的元素. 找到 index 位的 Node 节点
                for (int i = 1; i < index; i++) {
                    pre = c;
                    c = c.next;
                }
                // 插入值
                pre.next = new Node(element, c);
            }
            size++;
        }
    }

    /**
     * 移除指定位置元素
     *
     * @param index the index of the element to be removed
     * @return 返回该位置元素
     */
    @Override
    public Object remove(int index) {
        if (!legalIndex(index)) return null;
        Node point = first;
        if (index == 0) {
            point = point.next;
            size--;
            return point.value;
        } else {
            for (int i = 1; i < index - 1; i++) {
                point = point.next;
            }
            Node temp = point.next;
            point.next = point.next.next;
            temp.next = null;
            size--;
            return temp.value;
        }
    }

    /**
     * 找到指定元素的位置（从前向后）
     *
     * @param o element to search for
     * @return
     */
    @Override
    public int indexOf(Object o) {
        Node point = first;
        for (int i = 0; i < size; i++) {
            if (point.value.equals(o)) {
                return i;
            }
            point = point.next;
        }
        return -1;
    }

    /**
     * 找到指定元素的位置（从后往前走）
     *
     * @param o element to search for
     * @return flag
     */
    @Override
    public int lastIndexOf(Object o) {
        Node point = first;
        int flag = -1;
        for (int i = 0; i < size; i++) {
            if (point.value.equals(o)) {
                flag = i;
            }
            point = point.next;
        }
        return flag;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    /**
     * /**
     * 截取给定范围的元素
     *
     * @param fromIndex low endpoint (inclusive) of the subList （起始）
     * @param toIndex   high endpoint (exclusive) of the subList （结尾）
     * @return 下标合法，返回给定范围元素 不合法返回 null
     */
    @Override
    public List subList(int fromIndex, int toIndex) {
        if (!legalIndex(fromIndex) || !legalIndex(toIndex)) return null;
        Node point = first;
        LinkList linkTemp = new LinkList();
        for (int i = 0; i <= toIndex; i++) {
            if (i >= fromIndex) {
                linkTemp.add(point.value);
            }
            point = point.next;
        }
        return linkTemp;
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

    /**
     *
     * @param a the array into which the elements of this list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return 返回数组
     */
    @Override
    public Object[] toArray(Object[] a) {

        return null;
    }

    /**
     * 下标是否合法
     *
     * @param index
     * @return
     */
    private boolean legalIndex(int index) {
        if (index < 0 || index > size - 1) return false;
        else return true;
    }

    /**
     * 重写 toString
     *
     * @return
     */
    @Override
    public String toString() {
        if (first == null) {
            return "Linked[]";
        } else {
            StringBuilder sb = new StringBuilder("Linked[");
            Node c = first;
            while (c.next != null) {
                sb.append(c.value); // 当前节点的值
                sb.append(", ");
                c = c.next; // 指向下一个元素
            }
            sb.append(c.value); // 最后一个元素的值

            sb.append("]");
            return sb.toString();
        }

    }

    /**
     * 链表中的 节点对象
     */
    private class Node {
        /*
            元素的值
         */
        private Object value;

        /**
         * 下一个 节点
         */
        private Node next;

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }

        /**
         * 判断 node 节点是否一样
         * node 的值是否一样
         *
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (obj == this) {
                return true;
            }

            if (obj instanceof Node node) {
                if (this.value == null) {
                    return node.value == null;
                } else {
                    return value.equals(node.value);
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
