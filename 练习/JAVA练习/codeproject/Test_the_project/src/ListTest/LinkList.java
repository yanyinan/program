package ListTest;

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

    @Override
    public Object[] toArray() {
        return new Object[0];
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
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return point.value;
            }
            point = point.next;
        }
        return null;
    }

    /**
     * 修改指定元素位置元素
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return
     */
    @Override
    public Object set(int index, Object element) {
        if (!legalIndex(index)) return null;
        Node point = first;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                Node tempPoint = new Node(element,null);
                tempPoint.next = point.next.next;
                point.next = tempPoint;
                return point.value;
            }
            point = point.next;
        }
        return null;
    }

    /**
     * 指定位置添加指定元素
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, Object element) {
        if (!legalIndex(index)) ;
        else {
            Node point = first;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    Node tempPoint = (Node) element;
                    tempPoint.next = point.next;
                    point.next = tempPoint;
                }
                point = point.next;
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
        if (legalIndex(index)) return null;
        Node point = first;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                Object temp = point.value;
                point.next = point.next.next;
                return temp;
            }
            point = point.next;
        }
        size--;
        return null;
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
     * @return
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
     /**
     * 截取给定范围的元素
     * @param fromIndex low endpoint (inclusive) of the subList （起始）
     * @param toIndex high endpoint (exclusive) of the subList （结尾）
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

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    /**
     * 下标是否合法
     * @param index
     * @return
     */
    private boolean legalIndex(int index){
        if (index < 0 || index > size - 1) return false;
        else return true;
    }

    /**
     * 重写 toString
     * @return
     */
    @Override
    public String toString(){
        if (first == null){
            return "Linked[]";
        } else {
            StringBuilder sb = new StringBuilder("Linked[");
            Node c = first;
            while (c.next != null){
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
         *  node 的值是否一样
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj){
            if (obj == null){
                return false;
            }

            if (obj == this){
                return true;
            }

            if (obj instanceof Node node){
                if (this.value == null){
                    return node.value == null;
                } else {
                    return value.equals(node.value);
                }
            }
            return false;
        }
    }
}
