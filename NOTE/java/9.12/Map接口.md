## Map接口

`Map`接口不是`Collection`的子接口，使用键、值映射表来存储

```java
public interface Map<K,V>
```

- `Map`不能有重复的键(覆盖)，每个键可以映射到最多一个值 
- 允许将映射内容视为一组键、值集合或键值映射集合`key`不要求有序，不可以重复。 
- `value`也不要求有序，但可以重复 
- 当使用对象作为`key`时，要重写`equals`和`hashCode`方法

### 抽象方法

| 方法名                                 | 返回值              | 描述                          |
| -------------------------------------- | ------------------- | ----------------------------- |
| clear()                                | void                | 删除所有的映射                |
| containsKey(Object key)                | boolean             | Map中是有没有这个key          |
| containsValue(Object value)            | boolean             | Map有没有这个value            |
| entrySet()                             | Set<Map.Entry<K,V>> | 返回包含的映射的Set           |
| get(Object key)                        | V                   | 根据key返回对应的value        |
| isEmpty()                              | boolean             | Map是不是空的                 |
| keySet()                               | Set<K>              | 返回Map中所有key的Set         |
| put(K key, V value)                    | V                   | 向Map添加映射                 |
| putAll(Map<? extends K,? extends V> m) | void                | 将指定Map中的映射复制到此映射 |
| remove(Object key)                     | V                   | 如果key存在，删除映射         |
| remove(Object key, Object value)       | boolean             | 当key、value映射存在时，删除  |
| replace(K key, V value)                | boolean             | 当key存在时，替换内容         |
| size()                                 | int                 | Map中映射的数量               |
| values()                               | Collection<V>       | 返回所有value的集合           |

> `JDK9` 提供了创建不可修改 Map 对象的方法：
>
> 1. `Map.of  `
> 2. `Map.ofEntries `
> 3. `Map.copyOf`

`Map`的实现类较多，在此我们关注`HashMap`、`TreeMap`、`HashTable`、`LinkedHashMap`

### TreeMap

```java
public class TreeMap<K,V>
extends AbstractMap<K,V>
implements NavigableMap<K,V>, Cloneable, Serializable
```

- 继承`AbstractMap`,一个红黑树基于`NavigableMap`实现 
- 非线程安全的 
- `key`不能存 `null`,但是`value`可以存`null` 
- `key`必须是可比较的 (实现`Comparable`接口，传递一个`Comparator`比较器)

![image-20230906205409035](https://s2.loli.net/2023/09/06/nKx1l8Ds4Pmpgde.png)

#### 主要方法

| 方法名                      | 返回值  | 描述                                                         |
| --------------------------- | ------- | ------------------------------------------------------------ |
| put(K key, V value)         | V       | 将指定的键值对插入到此映射中，如果映射以前包含一个键的映射关系，则旧值被替换。 |
| get(Object key)             | V       | 根据给定的键返回与此映射中的键关联的值，如果此映射不包含键的映射关系，则返回 null。 |
| remove(Object key)          | V       | 如果此映射包含键的映射关系，则删除与指定键关联的映射关系；否则返回 null。 |
| containsKey(Object key)     | boolean | 如果此映射包含指定键的映射关系，则返回 true；否则返回 false。 |
| containsValue(Object value) | boolean | 如果此映射将值与此值相等（根据 compareTo() 的结果）的指定值关联，则返回 true；否则返回 false。 |
| size()                      | int     | 返回此映射中的键-值映射对的数量。                            |
| clear()                     | void    | 移除此映射中的所有映射关系。                                 |

### Hashtable

```java
public class Hashtable<K,V>
extends Dictionary<K,V>
implements Map<K,V>, Cloneable, Serializable
```

- 该类实现了一个哈希表，它将键映射到值 
- 不允许`null`作为键和值 
- 默认初始容量(`initialCapacity`)为 11 ，默认负载因子(`loadFactor`)为`0.75f `
- 同步的(线程安全的) 
- 不保证顺序 
- 扩容方式是旧容量的2倍 +1
  - 为什么`hashtable`的扩容方式选择为`2n+1`
  - 为了均匀分布，降低冲突率

- 数组 + 链表方式存储实现`Hash`表存储 
- 添加值时
  - 如果`hash`一样`equals`为`false`则将当前值添加到链表头 
  - 如果`hash`一样`equals`为`true`则使用当前值替换原来的值 （`key`相同）

![image-20230906210022521](https://s2.loli.net/2023/09/06/MAxfwlzcTs1P3CL.png)

#### 构造方法

| 方法名                                           | 描述                                                         |
| ------------------------------------------------ | ------------------------------------------------------------ |
| Hashtable()                                      | 构造一个新的，空的散列表，默认初始容量为11，负载因子为0.75。 |
| Hashtable(int initialCapacity)                   | 构造一个新的，空的哈希表，具有指定的初始容量和默认负载因子（0.75）。 |
| Hashtable(int initialCapacity, float loadFactor) | 构造一个新的，空的哈希表，具有指定的初始容量和指定的负载因子。 |
| Hashtable(Map<? extends K,? extends V> t)        | 构造一个与给定Map相同的映射的新哈希表。                      |

#### 常用方法

大多实现自`Map`所以不重复讲解

| 方法名     | 返回值 | 描述                                                         |
| ---------- | ------ | ------------------------------------------------------------ |
| toString() | String | 返回此 Hashtable对象的字符串表示形式，其括在大括号中，并以 ASCII字符“ , ”（逗号和空格）分隔。 |

### HashMap

```java
public class HashMap<K,V>
extends AbstractMap<K,V>
implements Map<K,V>, Cloneable, Serializable
```

- 基于哈希表的实现的`Map`接口 
- 允许`null`的值和`null`键 
- 非线程安全
- 默认容量 16，默认负载因子 0.75
  - `HashMap`容量为什么是2的n次方
- 扩容是 2 倍旧的容量 
- 在存储数据时，`key`的`hash`计算调用的是`HashMap`中的`hash`方法 
- 添加值时，如果`hash`一样添加到链表尾部

> `HashMap`类大致相当于`Hashtable`，除了它是不同步的，并允许`null`

内部采用`数组+链表`实现 ,`JDK 8`及以后版本增加红黑树的支持。

`HashMap`的`put`过程:

![image-20230906210819802](https://s2.loli.net/2023/09/06/mLSR8ihU4QV1WJj.png)

存储时，根据内部的`hash`方法计算`key`,来确定`value`的存储位置（`Map`的桶bucket），如果`hash`相同，在计算下标。如果产生没有碰撞（`key`不相同）,直接放到桶中，由于`hash`相同，所以放到一个桶中。放的时候，如果没有超过阈值(8)，以链表的形式放到后边，长度超过阈值且数组长度大于等于64将链表转换成红黑树存储。

- 删除元素时，如果时以红黑树存储的如果节点小于 6 个将会变为链表存储
- 如果产生碰撞（节点已经存在）就替换值

### LinkedHashMap

```java
public class LinkedHashMap<K,V>
	extends HashMap<K,V>
	implements Map<K,V>
```

- 哈希表和双向链表实现的 Map 接口
- 具有可预测的迭代次序(有序)
- 非线程安全
- 允许空元素

#### 常用方法

| 方法名                      | 返回值  | 描述                                                         |
| --------------------------- | ------- | ------------------------------------------------------------ |
| put(K key, V value)         | void    | 将指定的值与此映射中的指定键关联（可选操作）。如果映射以前包含一个键的映射关系，则旧值被替换。 |
| get(Object key)             | V       | 根据给定的键从映射中获取值，返回 null 如果映射不包含键的映射关系。 |
| remove(Object key)          | V       | 从映射中删除指定键的映射关系，返回与键关联的值。如果映射包含键的映射关系，则必须首先使用 delete() 方法删除该键的映射关系，然后才能调用此方法。 |
| containsKey(Object key)     | boolean | 如果此映射包含指定键的映射关系，则返回 true；否则返回 false。 |
| containsValue(Object value) | boolean | 如果此映射将值与此值关联（根据定义，值可能相等），则返回 true；否则返回 false。 |
| size()                      | int     | 返回此映射中的键-值映射对的数量。                            |
| clear()                     | void    | 移除此映射中的所有映射关系。                                 |

### ConcurrentHashMap

`java.util.concurrent.ConcurrentHashMap`

```java
public class ConcurrentHashMap<K,V> extends AbstractMap<K,V>
	implements ConcurrentMap<K,V>, Serializable
```

> 是`Java`从`JDK1.5`开始提供的一个`HashMap`线程安全的实现类。且`java.util.concurren
> t`包下所有的类都是线程安全的

### Properties

```java
public
class Properties extends Hashtable<Object,Object>
```

> `Properties`类表示一组持久的属性。`Properties`可以保存到流中或从流中加载。 属性
> 列表中的每个键及其对应的值都是一个字符串。

> 内部使用`ConcurrentHashMap`存储

> 操作和`Hashtable`基本一致，主要用于从流中记载或保存到流中去。(后期`JDBC`模块会使
> 用到)