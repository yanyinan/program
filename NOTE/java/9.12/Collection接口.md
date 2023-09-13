## `Collection`接口

`Collection`接口是`Java`标准库中的一个接口，用于表示一组对象的集合。它是Java集合框中的根接口，继承了`Iterable`接口。

```java
public interface Collection<E>
extends Iterable<E>
```

从类的声明我们可以看到，`Collection`接口继承了`Iterable`接口。也就意味着，实现了Collection 接口的类也间接实现了`Iterable`接口，也就是说它们都能作为`for-each-loop`的循环对象。

>`Collection`是集合层次结构中的根接口。集合表示一组对象，对象称为集合的元
>素。有些集合允许重复元素，有些则不允许。 有些是有序的，有些是无序的（不保证
>顺序）

### 抽象方法

| 方法名                            | 返回值      | 描述                                 |
| --------------------------------- | ----------- | ------------------------------------ |
| add(E e)                          | boolean     | 添加元素                             |
| addAll(Collection<? extends E> c) | boolean     | 将集合c中的所有元素添加此集合中      |
| clear()                           | void        | 清除所有元素                         |
| contains(Object o)                | boolean     | 集合中是否包含此元素                 |
| containsAll(Collection<?> c)      | boolean     | 集合中是否包含c集合中的所有元        |
| isEmpty()                         | boolean     | 集合中是否有元素，如果没有返回true   |
| iterator()                        | Iterator<E> | 继承自Iterable接口，返回集合的迭代器 |
| remove(Object o)                  | boolean     | 删除集合中的某个元素                 |
| removeAll(Collection<?> c)        | boolean     | 删除集合c中包含的所有元素            |
| retainAll(Collection<?> c)        | boolean     | 保留集合c中的元素                    |
| size()                            | int         | 返回此集合中的元素数                 |
| toArray()                         | Object[]    | 返回一个包含此集合中所有元素的数组   |

**子接口很多，主要研究 List 、 Set 、 Queue**

## Queue(队列)接口

Java中的`Queue`接口是一个继承自`Collection`接口的子接口，用于表示一种队列（FIFO，先进先出）的数据结构。

```java
public interface Queue<E>
extends Collection<E
```

设计用于在处理之前保留元素的集合。 除了基本的 Collection 操作之外，队列还提供额外的插入，提取和检查操作。

不可以存 null

#### 主要抽象方法

|      | 抛出异常  | 返回特殊值 |
| :--: | :-------: | :--------: |
| 插入 |  add(e)   |  offer(e)  |
| 消除 | remove()  |   poll()   |
| 检查 | element() |   peek()   |

> 特殊值（或者 null 或 false ，取决于操作）

| 方法名     | 返回值  | 描述                                                         |
| ---------- | ------- | ------------------------------------------------------------ |
| add(E e)   | boolean | 如果可以在不违反容量限制的情况下立即将指定元素插入此队列，则在成功时返回 true. 当前没有可用空间抛出一个 IllegalStateException |
| offer(E e) | boolean | 如果可以在不违反容量限制的情况下立即插入，则将指定元素插入此队列 |
| element()  | E       | 检索但不删除此队列的头部，此方法的不同之处peek仅在于如果此队列为空，它会引发异常 |
| peek()     | E       | 检索不删除此队列的头，如果此队列为空，则返回 null ，如果不为空返回队列的头 |
| poll()     | E       | 检索并删除此队列的头，如果此队列为空，则返回 null            |
| remove()   | E       | 检索并删除此队列的头。 此方法与poll不同之处在于，如果此队列为空，它将抛出异常 |

### Deque(双端队列)

`Deque`接口（双端队列）是Java标准库中的一种集合接口，代表了一种具有队列和栈特性的数据结构，支持在队列的两端进行插入和删除操作。

```java
public interface Deque<E>
extends Queue<E>
```

> 继承了`Queue`,支持两端(首尾)元素插入和移除的线性集合。

#### 常用抽象方法

![image-20230905200131620](https://s2.loli.net/2023/09/13/lxnYIsfKE7GOrqe.png)

| 方法名                          | 返回值 | 描述                                                         |
| ------------------------------- | ------ | ------------------------------------------------------------ |
| addFirst(E e)                   | void   | 插入此双端队列的前面                                         |
| addLast(E e)                    | void   | 双端队列的末尾插入元素，和add(E e)类似                       |
| getFirst()                      | E      | 检索，但不删除，第一个元素                                   |
| getLast()                       | E      | 检索，但不删除，最后一个元素                                 |
| pop()                           | E      | 删除并返回此deque的第一个元素                                |
| push(E e)                       | void   | 相当于addFirst(E)                                            |
| removeFirstOccurrence(Object o) | E      | 从此双端队列中删除第一次出现的指定元素。如果双端队列不包含该元素，则它保持不变。 |
| removeLastOccurrence(Object o)  | E      | 从此双端队列中删除最后一次出现的指定元素。如果双端队列不包含该元素，则它保持不变。 |

![image-20230905200207246](https://s2.loli.net/2023/09/13/7G8vnuDEkjQls2B.png)

常见实现类`LinkedList`

## set接口

`java.util.Set`不包含重复元素的集合、不能保证存储的顺序、只允许有一个 null

```java
public interface Set<E>
extends Collection<E>
```

抽象方法，都是继承自`java.util.Collection`接口。

`of`方法和`copyOf`，都是`static`方法返回一个不可修改的`Set`集合。

#### 不可修改Set集合

- 它们是不可修改的。不能添加或删除元素。
- 不允许`null`元素。尝试使用`null`元素创建它们会导致`NullPointerException`。

`Set`集合的实现类有很多，在此我们重点了解 `HashSet `、 `TreeSet `、 `LinkedHashSet`

### TreeSet

```java
public class TreeSet<E>
extends AbstractSet<E>
implements NavigableSet<E>, Cloneable, Serializable
```

- 非线程安全
- 值必须可比较(元素实现`Comparable`接口、传递 比较器`Comparator`对象)
- 不能存`null`
- 判断是否是重复元素，是按照自然比较/比较器进行比较

就是说a.compareTo(b) == 0,如果是`true`，那么`add(a)`之后的`add(b)`将会返回`false`，也就是添加失败

#### 常用的构造方法

| 方法名                                    | 描述                                                         |
| ----------------------------------------- | ------------------------------------------------------------ |
| TreeSet()                                 | 构造一个新的空TreeSet集合，根据其元素的自然顺序进行排序。    |
| TreeSet(Comparator<? super E> comparator) | 构造一个新的空TreeSet集合，根据指定的比较器进行排序。        |
| TreeSet(Collection<? extends E> c)        | 构造一个新的TreeSet集合，该TreeSet集合包含指定集合中的元素，并根据其元素的自然顺序进行排序。 |

#### 常用方法( Collection 接口的方法不在此赘述)

| 方法名                 | 返回值       | 描述                                                         |
| ---------------------- | ------------ | ------------------------------------------------------------ |
| ceiling(E e)           | E            | 返回此集合中大于或等于给定元素的最小元素，如果没有这样的元素，则返回null。 |
| first()                | E            | 返回当前在此集合中的第一个（最低的）元素。                   |
| floor(E e)             | E            | 返回此集合中小于或等于给定元素的最大元素，如果没有这样的元素，则返回null。 |
| headSet(E toElement)   | SortedSet<E> | 返回此集合中元素严格小于toElement的部分的视图。              |
| higher(e)              | E            | 返回此集合中严格大于给定元素的最小元素，如果没有这样的元素，则返回null。 |
| last()                 | E            | 返回当前在此集合中的最后一个（最高的）元素。                 |
| lower(e)               | E            | 返回此集合中严格小于给定元素的最大元素，如果没有这样的元素，则返回null。 |
| pollFirst()            | E            | 检索并删除第一个（最低的）元素，如果此集合为空，则返回null。 |
| pollLast()             | E            | 检索并删除最后一个（最高）元素，如果此集合为空，则返回null。 |
| tailSet(E fromElement) | SortedSet<E> | 返回此集合中元素严格大于或等于fromElement的部分的视图。      |

```java
TreeSet<String> set = new TreeSet(List.of("null", "a", "a", "b", "c", "e","f","g"));

System.out.println(set); // [a, b, c, e, f, g, null]

// 返回此集合中大于或等于给定元素的最小元素，如果没有这样的元素，则返回null。
String ceiling = set.ceiling("d");
System.out.println(ceiling);// e

// 返回当前在此集合中的第一个（最低的）元素。
String first = set.first();
System.out.println(first); // a

// 返回此集合中小于或等于给定元素的最大元素，如果没有这样的元素，则返回null。
String floor = set.floor("d");
System.out.println(floor); // c

// 返回此集合中元素严格小于toElement的部分的视图。
SortedSet<String> headSet = set.headSet("c");
System.out.println(headSet); // a, b

// 返回此集合中严格大于给定元素的最小元素，如果没有这样的元素，则返回null。
String higher = set.higher("c");
System.out.println(higher); // e

// 返回此集合中元素严格大于或等于fromElement的部分的视图。
SortedSet<String> tailSet = set.tailSet("c");
System.out.println(tailSet); // c, e, f, g, null

// 迭代
for (Object obj : set){
System.out.println(obj);
}
```

### HashSet

```java
public class HashSet<E>
extends AbstractSet<E>
implements Set<E>, Cloneable, Serializable
```

实现了`Set`接口，底层实现是`HashMap`。不保证迭代顺序，允许`null`元素

- 非线程安全的
- 如果`add`的值已存在(`equals`方法返回`true`,基本数据类型自动装箱)返回`false`
- 如果`HashSet`中存的是对象，需要重写此对象类中的`equals`和`hashCode()`方法

#### 构造方法

| 方法名                                         | 描述                                                         |
| ---------------------------------------------- | ------------------------------------------------------------ |
| HashSet()                                      | 构造一个新的空集合； 底层实现HashMap实例具有默认初始容量（16）和负载因子（0.75）。 |
| HashSet(Collection<? extends E> c)             | 构造一个包含指定集合中的元素的新集合                         |
| HashSet(int initialCapacity)                   | 构造一个新的空集合，默认初始容量(initialCapacity)和负载因子(0.75) |
| HashSet(int initialCapacity, float loadFactor) | 构造一个新的空集合； 底层HashMap实例具有指定的初始容量和指定的负载因子 |

#### 常用方法

| 方法名             | 返回值  | 描述                                        |
| ------------------ | ------- | ------------------------------------------- |
| add(Object o)      | boolean | 如果Set中尚未包含指定元素o，则添加指定元素o |
| clear()            | void    | 从Set中移除所有元素                         |
| size()             | int     | 返回Set中的元素的数量                       |
| isEmpty()          | boolean | 如果Set不包含任何元素，则返回true           |
| contains(Object o) | boolean | 如果Set包含指定元素，则返回true             |
| remove(Object o)   | boolean | 如果指定元素o存在与Set中，则将其移除        |

### LinkedHashSet

```java
public class LinkedHashSet<E>
extends HashSet<E>
implements Set<E>, Cloneable, java.io.Serializable
```

- 哈希表和双向链表实现的 Set 接口
- 具有可预测的迭代次序(有序)
- 内部实现是`LinkedHashMap`，顺序是插入顺序

## List接口

有序集合（也称为序列 ）。 该集合用户可以精确控制列表中每个元素的插入位置。 用户可以通过整数索引（列表中的位置）访问元素，并搜索列表中的元素

`List`通常允许重复的元素、允许`null`元素

### 抽象方法

| 方法名                                       | 返回值  | 描述                                                         |
| -------------------------------------------- | ------- | ------------------------------------------------------------ |
| add(int index, E element)                    | void    | 将指定的元素插入此列表中的指定位置                           |
| addAll(int index, Collection<? extends E> c) | void    | 将指定集合中的所有元素插入到此列表中的指定位置               |
| get(int index)                               | E       | 返回此列表中指定位置的元素                                   |
| indexOf(Object o)                            | int     | 返回此列表中指定元素的第一次出现的位置，如果此列表不包含元素，则返回 -1 |
| lastIndexOf(Object o)                        | int     | 返回此列表中指定元素的最后一次出现的位置，如果此列表不包含元素，则返回 -1 |
| remove(int index)                            | E       | 删除该列表中指定位置的元素，返回被删除的元素                 |
| set(int index, E element)                    | E       | 用指定的元素（可选操作）替换此列表中指定位置的元素，返回被替换的值 |
| subList(int fromIndex, int toIndex)          | List<E> | 返回此列表中指定的 fromIndex （含）和 toIndex之间的元素集合  |
| default sort(Comparator<? super E> c)        | void    | 按照 c 比较器进行自然排序                                    |
| copyOf(Collection<? extends E> coll)         | List<E> | 按照迭代顺序返回一个不可修改的 List                          |
| static of()                                  | List<E> | 返回包含任意数量元素的不可修改列表                           |

主要子类，`ArrayList`、 `LinkedList`、`Vector`

### ArrayList

`ArrayList`集合类对数组进行了封装，实现了长度可变的数组，而且和数组采用相同的储存方式，在内存中分配连续的空间，所有称`ArrayList`是动态数组

```java
private transient Object[] elementData;
private int size;
```

#### 常用方法

|                    方法                     |   返回值    |                             描述                             |
| :-----------------------------------------: | :---------: | :----------------------------------------------------------: |
|          add(int index, E element)          |    void     |              在此列表中的指定位置插入指定元素。              |
|               add(E element)                |   boolean   |               将指定的元素附加到此列表的末尾。               |
| addAll(int index, Collection<?extends E> c) |   boolean   |   将指定集合中的所有元素追加到此列表的末尾。从指定位置开始   |
|      addAll(Collection<? extends E> c)      |   boolean   | 将指定集合中的所有元素追加到此列表的末尾。按照它们由指定集合的迭代器返回的顺序 |
|                   clear()                   |    void     |                    从此列表中删除所有元素                    |
|                   clone()                   |   Object    |              返回此实例的浅表副本`ArrayList`。               |
|             contains(Object o)              |   boolean   |                 返回此列表是否包含指定元素。                 |
|              equals(Object o)               |   boolean   |                比较指定对象与此列表是否相等。                |
|     forEach(Consumer<? super E> action)     |    void     | 对`Iterable`的每个元素执行给定的操作，直到处理完所有元素或操作引发异常。 |
|               get(int index)                |      E      |                  返回此列表中指定位置的元素                  |
|                 hashCode()                  |     int     |                     返回此列表的哈希码值                     |
|              indexOf(Object o)              |     int     | 返回此列表中指定元素第一次出现的索引，如果此列表不包含该元素，则返回 -1。 |
|                  isEmpty()                  |   boolean   |            如果此列表不包含任何元素，则返回true。            |
|                 iterator()                  | Iterator<E> |             以正确的顺序返回此列表中元素的迭代器             |
|            lastIndexOf(Object o)            |     int     | 返回此列表中指定元素最后一次出现的索引，如果此列表不包含该元素，则返回 -1。 |
|              remove(int index)              |      E      |                  移除此列表中指定位置的元素                  |
|              remove(Object o)               |   boolean   |             从此列表中移除第一次出现的指定元素。             |
|         removeAll(Collection<?> c)          |   boolean   |            从此列表中移除指定集合中包含的所有元素            |
|   removeRange(int formIndex, int toIndex)   |    void     |   从此列表中删除索引介于fromIndex和toIndex之间的所有元素。   |
|         retainAll(Collection<?> c)          |   boolean   |             仅保留此列表中包含在指定集合中的元素             |
|          set(int index, E element)          |      E      |            用指定元素替换此列表中指定位置的元素。            |
|                   size()                    |     int     |                   返回此列表中的元素个数。                   |
|     subList(int fromIndex, int toIndex)     |   List<E>   |     返回此列表中指定fromIndex和toIndex之间的部分的视图。     |
|                  toArray()                  |  Object[]   | 返回一个数组，其中包含此列表中按正确顺序（从第一个元素到最后一个元素）的所有元素。 |
|                  toArray()                  |   <T> T[]   | 以正确的顺序（从一个元素到最后一个元素）返回一个包含此列表中所有元素的数组；返回数组的运行时类型是指定数组的类型。 |
|                trimToSize()                 |    void     |             将此实例的容量修剪为列表的当前大小。             |



### LinkedList

`LinkedList`类`List`接口的链接列表实现类。它支持实现所有`List`接口可选的列表的操作，并且允许元素值是任何数据，包括`null`。

```java
transient int size = 0;

transient LinkedList.Node<E> frist;

transient LinkedList.Node<E> last;
```

#### 常用方法

|     方法      | 返回值  |                      描述                      |
| :-----------: | :-----: | :--------------------------------------------: |
| addFirst(E e) |  void   |          在此列表的开头插入指定元素。          |
| addLast(E e)  |  void   |         将指定的元素附加到此列表的末尾         |
|   element()   |    E    |     检索但不删除此列表的头部（第一个元素）     |
|  getFirst()   |    E    |           返回此列表中的第一个元素。           |
|   getLast()   |    E    |          返回此列表中的最后一个元素。          |
|  offer(E e)   | boolean | 添加指定元素作为此列表的尾部（最后一个元素）。 |
|    peek()     |    E    |     检索但不删除此列表的头部（第一个元素）     |
|    poll()     |    E    |      检索并删除此列表的头部（第一个元素）      |
|     pop()     |    E    |       从此列表表示的堆栈中弹出一个元素。       |
|   push(E e)   |  void   |       将一个元素推入此列表表示的堆栈中。       |
| removeFirst() |    E    |        从此列表中移除并返回第一个元素。        |
| removeLast()  |    E    |       从此列表中移除并返回最后一个元素。       |

### Vector

`Vector`类实现了可扩展的对象数组。 像数组一样，它包含可以使用整数索引访问的组件。 但是，`Vector`的大小可以变化。

`Vector`是同步的，是线程安全的。

`Vector`继承了`AbstractList`类，实现了`List`接口

内部是使用数组存储数据，也就是说在内存中开辟一个连续的空间

默认大小是10，当容量不足时，默认扩容方式是按倍增长（`capacity` * 2）

可以自定义默认容量以及每次扩展多少容量

子类:`Stack`

![image-20230905203901237](https://s2.loli.net/2023/09/13/p2wh8TrRdqZ3kEz.png)

#### Stack

`Stack`类代表后进先出（LIFO）堆栈的对象，`Stack`继承自`Vector`所以它有所有`Vector`中的方法。

```java
public class Stack<E> extends Vector<E>1
```

##### 常用方法：

| 方法名           | 返回值  | 描述                                     |
| ---------------- | ------- | ---------------------------------------- |
| empty()          | boolean | 此堆栈是否为空                           |
| peek()           | E       | 返回此堆栈顶部的对象，而不从堆栈中删除它 |
| pop()            | E       | 返回并删除此堆栈顶部的对象               |
| push(E item)     | void    | 将item添加到堆栈的顶部                   |
| search(Object o) | int     | 返回对象在此堆栈上的从1开始的位置        |

### LinkedList

```java
public class LinkedList<E>
extends AbstractSequentialList<E>
implements List<E>, Deque<E>, Cloneable, Serializable
```

`LinkedList`的直接父类是`AbstractSequentialList`,实现了`List`、`Deque`

![image-20230905204242822](https://s2.loli.net/2023/09/13/3ljcqrxAn42DXGN.png)

`LinkedList`是一个双向链表，允许存储`null`，此实现不同步（非线程安全的）

![image-20230905204318426](https://s2.loli.net/2023/09/05/Gc9Fh6sNtazulEC.png)

```java
//实例化
LinkedList list = new LinkedList();

LinkedList list1 = new LinkedList(list);
```

| 方法名         | 返回值 | 描述                                                   |
| -------------- | ------ | ------------------------------------------------------ |
| addFirst(E e)  | void   | 在该列表开头插入指定的元素                             |
| addLast(E e)   | void   | 将指定的元素追加到此列表的末尾/add()                   |
| get(int index) | E      | 返回此列表中指定位置的元素                             |
| getFirst()     | E      | 返回此列表中的第一个元素                               |
| getLast()      | E      | 返回此列表中的最后一个元素                             |
| push(E e)      | void   | 列表的前面插入元素/addFirst()                          |
| removeFirst()  | E      | 从此列表中删除并返回第一个元素                         |
| poll()         | E      | 删除并返回此列表的第一个元素，如果列表为空则返回null   |
| pollFirst()    | E      | 删除并返回此列表的第一个元素，如果列表为空则返回null   |
| pop()          | E      | 删除并返回此列表的最后一个元素，如果列表为空则抛出异常 |

- 删除/新增操作效率高

比较`ArrayList`/`LinkedList`

都实现了`List`接口,都是有序的、可以重复的、可以存`null`值得集合，可以使用下标访问元素

- `ArrayList`在随机访问（获取元素时）效率比`LinkedList`高
   - `ArrayList`底层实现是数组, 默认容量是 10 ...
		
   - `LinkedList`底层实现的链表(双向链表)
- 在添加元素到末尾时，两个集合效率差不多
- 在任意位置添加元素时，`LinkedList`效率更高
- 在任意位置删除元素时，`LinkedList`效率高
- 内存，`ArrayList`使用的是连续空间