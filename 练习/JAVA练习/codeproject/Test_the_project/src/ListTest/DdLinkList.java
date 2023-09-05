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
public class DdLinkList implements List {
    //头节点
    private DdNode first;
    //尾节点
    private DdNode last;
    //容器元素个数
    private int size;

    /**
     * 返回容器元素个数
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 判断容器内是否为空
     * @return true 为空，反之为 false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
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
     * 添加元素
     * @param o element whose presence in this collection is to be ensured
     * @return
     */
    @Override
    public boolean add(Object o) {
        DdNode point = new DdNode(o, last, null);
        if (first == null) {
            first = point;
        } else {
            last.next = point;
        }
        last = point;
        size++;
        return true;
//        if (first == null) {
//            // 如果链表为空，将新节点设置为第一个节点
//            first = point;
//        } else {
//            DdNode temp = first;
//            while (temp.next != null) {//判断为空的 next
//                temp = temp.next;
//            }
//            temp.next = point;
//            last = point; // 将新节点链接到最后一个节点的next
//        }
//        size++;
//        return true;
    }

    /**
     * 删除指定元素
     * @param o element to be removed from this list, if present
     * @return
     */
    @Override
    public boolean remove(Object o) {
        DdNode nodetemp = first;  // 初始化当前节点为链表的第一个节点
        if (contains(o)) {  // 如果链表中包含指定元素
            while (!nodetemp.value.equals(o))  // 遍历链表，找到与指定元素相等的节点
                nodetemp = nodetemp.next;
            if (nodetemp.equals(first)) {  // 如果找到的节点是链表的第一个节点
                DdNode next = nodetemp.next;  // 获取下一个节点
                first = next;  // 将第一个节点指向下一个节点
                nodetemp.pre = null;  // 将前一个节点置空引用
                nodetemp.next = null;  // 将下一个节点置空引用
            }else if (nodetemp.equals(last)){
                last = last.pre;
                last.next.pre = null;
                last.next = null;
            } else {  // 如果找到的节点不是链表的第一个节点
                nodetemp.pre.next = nodetemp.next;  // 前一个节点指向后一个节点
                nodetemp.next.pre = nodetemp.pre;;  // 后一个节点指向前一个节点
                nodetemp.pre = null;  // 将前一个节点置空引用
                nodetemp.next = null;  // 将下一个节点置空引用
            }
            return true;  // 删除成功，返回true
        }else {
            return false;  // 如果链表中不包含指定元素，删除失败，返回false
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
        first = null;
        last = null;
        size = 0;
    }

    /**
     * 得到指定位置元素
     * @param index index of the element to return
     * @return 返回指定位置元素
     */
    @Override
    public Object get(int index) {
        LegalIndex(index);
        DdNode nodetemp = indexNode(index);
//        int mid = size /2;//中间节点位置
//        if (index < mid){//前半位置
//            nodetemp = first;
//            for (int i = 0; i < index; i++) {
//                nodetemp = nodetemp.next;
//            }
//        }else {//后半位置
//            nodetemp = last;
//            for (int i = size-1; i >index ; i--) {
//                nodetemp = nodetemp.pre;
//            }
//        }
        return nodetemp.value;
    }

    /**
     * 返回指定位置节点
     * @param index 指定下标
     * @return 返回指定节点
     */
    private DdNode indexNode(int index){
        LegalIndex(index);
        DdNode nodetemp ;
        int mid = size / 2; // 中间节点位置
        if (index < mid) { // 前半位置
            nodetemp =  first; // 首节点操作
            for (int i = 0; i < index ; i++) {
                nodetemp = nodetemp.next;
            }
        } else { // 后半位置
            nodetemp = last;//尾节点
            for (int i = size - 1; i > index; i--) {
                nodetemp = nodetemp.pre;
            }
        }
        return nodetemp;
    }

    /**
     * 设置指定下标为指定元素
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return 返回被修改值
     */
    @Override
    public Object set(int index, Object element) {
        LegalIndex(index);
        Object old = indexNode(index).value;
        indexNode(index).value = element;
        return old;
    }

    /**
     * 指定下标添加元素
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, Object element) {
        LegalIndex(index);
        DdNode nodetemp = indexNode(index);//调用indexNode方法找到指定下标断点
        DdNode pre = nodetemp; // 获取前一个节点
        DdNode next = nodetemp.next; // 获取当前节点
        DdNode ddNode = new DdNode(element, pre, next); // 创建新节点
        pre.next = ddNode; // 更新前一个节点的 next 指向新节点
        next.pre = ddNode; // 更新当前节点的 pre 指向新节点
        size++; // 增加链表大小计数器
    }

    /**
     * 删除指定下标元素
     * @param index the index of the element to be removed
     * @return 返回被删除元素
     */
    @Override
    public Object remove(int index) {
        LegalIndex(index);
        DdNode nodetemp = indexNode(index);//调用indexNode方法找到指定下标断点
        Object old = nodetemp.value;//返回值
        if (nodetemp.equals(first)) {  // 如果找到的节点是链表的第一个节点
            DdNode next = nodetemp.next;  // 获取下一个节点
            first = next;  // 将第一个节点指向下一个节点
            nodetemp.pre = null;  // 将前一个节点置空引用
            nodetemp.next = null;  // 将下一个节点置空引用
        } else if (nodetemp.equals(last)) {
            last = last.pre;
            last.next.pre = null;
            last.next = null;
        } else {
            DdNode pre = nodetemp.pre; // 获取前一个节点
            DdNode next = nodetemp.next; // 获取下个节点
            pre.next = next; //  pre 指向后节点
            next.pre = pre; //  next 指向前节点
            nodetemp.pre = null;//置空引用
            nodetemp.next = null;
        }
        size--; // 链表大小计数器
        return old;
    }

    /**
     * 判断指定元素下标（从前向后）
     * @param o element to search for
     * @return 有返回下标，无返回 -1
     */
    @Override
    public int indexOf(Object o) {
        DdNode nodetemp = first;
        for (int i = 0; i < size; i++) {
            if (nodetemp.value.equals(o)) return i;
            nodetemp = nodetemp.next;
        }
        return -1;
    }
    /**
     * 判断指定元素下标（从后向前）
     * @param o element to search for
     * @return 有返回下标，无返回 -1
     */
    @Override
    public int lastIndexOf(Object o) {
        DdNode nodetemp = last;
        for (int i = size; i >= 0; i--) {
            if (nodetemp.value.equals(o)) return i;
            nodetemp = nodetemp.pre;
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
        LegalIndex(fromIndex);
        LegalIndex(toIndex);
        DdNode point = indexNode(fromIndex);
        DdLinkList str = new DdLinkList();
        for (int i = 0; i < toIndex-fromIndex; i++) {
            str.add(point.value);
            point = point.next;
        }
        return str;
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
     * 下标合法
     * @param index 下标
     */
    private void LegalIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    
    /**
     * 重写toString
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        DdNode c = first;
        while (c != null) {
            sb.append(c.value);
            if (c.next != null) {
                sb.append(", ");
            }
            c = c.next;
        }
        sb.append(" }");
        return sb.toString();
    }
    private class DdNode{
        //元素
        private Object value;
        //前一个结点
        private DdNode pre;
        //后一个节点
        private DdNode next;

        public DdNode(Object value, DdNode pre, DdNode next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
        /**
         * 判断 node 节点是否一样
         * node 的值是否一样
         *
         * @param obj 比较对象
         * @return boolean
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (obj == this) {
                return true;
            }

            if (obj instanceof DdLinkList.DdNode node) {
                if (this.value == null) {
                    return node.value == null;
                } else {
                    return value.equals(node.value);
                }
            }
            return false;
        }

        /**
         * 重写toString方法
         * @return String
         */
        @Override
        public String toString() {
            return "DdNode{" +
                    "value=" + value +
                    ", pre=" + pre +
                    ", next=" + next +
                    '}';
        }
    }
}
