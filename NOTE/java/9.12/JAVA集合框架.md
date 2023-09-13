# JAVA集合框架

## 集合框架图

![image-20230913225105800](https://s2.loli.net/2023/09/13/P2FNZaUeJfdKgLu.png)

![image-20230913225124526](https://s2.loli.net/2023/09/13/LRntvAemr4WsxjP.png)

1、所有集合类都位于`java.util`包下。Java的集合类主要由两个接口派生而出：Collection和Map，Collection和Map是Java集合框架的根接口，这两个接口又包含了一些子接口或实现类。

2、集合接口：6个接口（短虚线表示），表示不同集合类型，是集合框架的基础。

3、抽象类：5个抽象类（长虚线表示），对集合接口的部分实现。可扩展为自定义集合类。

4、实现类：8个实现类（实线表示），对接口的具体实现。

5、Collection 接口是一组允许重复的对象。

6、Set 接口继承 Collection，集合元素不重复。

7、List 接口继承 Collection，允许重复，维护元素插入顺序。

8、Map接口是键－值对象，与Collection接口没有什么关系。

**9、Set、List和Map可以看做集合的三大类：**

- List集合是有序集合，集合中的元素可以重复，访问集合中的元素可以根据元素的索引来访问。
- Set集合是无序集合，集合中的元素不可以重复，访问集合中的元素只能根据元素本身来访问（也是集合里元素不允许重复的原因）。
- Map集合中保存Key-value对形式的元素，访问时只能根据每项元素的key来访问其value。

## 分析

1、Collection是一个接口，是高度抽象出来的集合，它包含了集合的基本操作和属性。Collection包含了List和Set两大分支。

- **List是一个有序的队列**，每一个元素都有它的索引。第一个元素的索引值是0。List的实现类有LinkedList, ArrayList, Vector, Stack。
- **Set是一个不允许有重复元素的集合**。Set的实现类有HastSet和TreeSet。HashSet依赖于HashMap，它实际上是通过HashMap实现的；TreeSet依赖于TreeMap，它实际上是通过TreeMap实现的。

2、**Map是一个映射接口，即key-value键值对**。Map中的每一个元素包含“一个key”和“key对应的value”。AbstractMap是个抽象类，它实现了Map接口中的大部分API。而HashMap，TreeMap，WeakHashMap都是继承于AbstractMap。Hashtable虽然继承于Dictionary，但它实现了Map接口。

3、接下来，再看Iterator。它是**遍历集合**的工具，即我们通常通过Iterator迭代器来遍历集合。我们说Collection依赖于Iterator，是因为Collection的实现类都要实现iterator()函数，返回一个Iterator对象。**ListIterator是专门为遍历List而存在的。**

4、再看Enumeration，它是JDK 1.0引入的抽象类。**作用和Iterator一样**，也是遍历集合；但是Enumeration的功能要比Iterator少。在上面的框图中，Enumeration只能在Hashtable, Vector, Stack中使用。

5、最后，看Arrays和Collections。它们是操作数组、集合的两个工具类。