# `Collections`

`java.util.Collections`是`java`提供的一个集合操作的工具类。

- 如果提供给它们的集合或类对象为`null`，则此类的方法都抛出一个`NullPointerException`

static fields

```java
static final List EMPTY_LIST;//空List，不可变
//public static final List EMPTY_LIST = new EmptyList<>();
static final Map EMPTY_MAP ;  //空Map，不可变
//public static final Map EMPTY_MAP = new EmptyMap<>();
static final Set EMPTY_SET ; //空Set，不可变
//public static final Set EMPTY_SET = new EmptySet<>();
```

static 方法

|                            方法名                            |  返回值   |                             描述                             |
| :----------------------------------------------------------: | :-------: | :----------------------------------------------------------: |
|      `addAll(Collection<? super T> c,  T... elements)`       | `boolean` |                  将elements，添加到c集合中                   |
|     ` copy(List<? super T> dest, List<? extends T> src)`     |  `void`   | 将`src`集合中的元素复制到`dest`中，`dest`中的元素个数不能少于`src`中的元素个数 |
|        `disjoint(Collection<?> c1, Collection<?> c2)`        | `boolean` |     如果两个指定的集合**没有**共同的元素，则返回 `true`      |
|             `fill(List<?  super T> list, T obj)`             |  `void`   |              用指定的元素代替指定列表的所有元素              |
|             `max(Collection<? extends  T> coll)`             |    `T`    | 根据其元素的 *自然顺序*返回给定集合的最大元素,集合中的元素一定要实现`Comparable`接口 |
|             `min(Collection<? extends  T> coll)`             |    `T`    |                     原理同上，返回最小值                     |
| `max(Collection<? extends T> coll,  Comparator<? super  T> comp)` |    `T`    | 根据指定的比较器引发的顺序返回给定集合的最大元素。 集合中的所有元素必须由指定的比较器相互比较 |
| `min(Collection<? extends T> coll,  Comparator<? super  T> comp)` |    `T`    |                     原理同上，返回最小值                     |
|       `replaceAll(List<T> list, T oldVal,  T newVal)`        | `boolean` |         将列表中一个指定值的**所有**出现替换为另一个         |
|                   `reverse(List<?> list)`                    |  `void`   |                   反转指定列表中元素的顺序                   |
|                   `shuffle(List<?> list)`                    |  `void`   |              使用默认的随机源随机排列指定的列表              |
|                     `sort(List<T> list)`                     |  `void`   | 按照升序排列指定的列表。 列表中的所有元素必须实现`Comparable`接口 |
|        `sort(List<T> list, Comparator<? super T> c)`         |  `void`   | 根据指定的比较器引起的顺序对指定的列表进行排序。 列表中的所有元素必须使用指定的比较器*相互比较* |
| `binarySearch(List<?  extends Comparable<? super T>> list,  T key)` |   `int`   | 使用二叉搜索算法搜索指定对象的指定列表，集合必须是排序后的。如果存在返回索引，如果不存在返回负数 |
| `binarySearch(List<?  extends T> list, T key, Comparator<? super T> c)` |   `int`   |    使用二叉搜索算法搜索指定对象的指定列表,使用前必须排序     |

```java
public static void main(String[] args) {
		List list = new ArrayList();
		Collections.addAll(list, 1,2,3,4,5,6,7,8,9,10,11);
		System.out.println(list.size());
		List list1 = new ArrayList();
		list1.add(10);
		list1.add(9);
		list1.add(8);
		list1.add(7);
		list1.add(6);
		list1.add(5);
		list1.add(4);
		list1.add(3);
		list1.add(2);
		list1.add(1);
		list1.add(0);
		
		Collections.copy(list1, list);
		System.out.println(list);
		System.out.println(list1);
		System.out.println("=================");
		List list2 = new ArrayList();
		list2.add(20);
		list2.add(null);
		boolean flag = Collections.disjoint(list, list2);
		System.out.println(flag);
		
//		Collections.fill(list1, 6);
//		System.out.println(list1);
		
		
		List list3 = new ArrayList();
		list3.add(new Person("赵四2", 23));
		list3.add(new Person("赵四", 20));
		list3.add(new Person("赵四3", 23));
		list3.add(new Person("赵四1", 22));
		Object object = Collections.max(list3);
		Object object1 =  Collections.max(list3,new AgeComparator());
		System.out.println(object);
		System.out.println(object1);
		
		System.out.println("===============");
		
		Collections.replaceAll(list2, null, 100);
		System.out.println(list2);
		Collections.reverse(list1);
		System.out.println(list1);
		Collections.shuffle(list1);
		System.out.println(list1);
		
		System.out.println("============");
		System.out.println(list3);
		Collections.sort(list3);
		System.out.println(list3);
		
		System.out.println("=============");
		Collections.sort(list3, new AgeComparator());
		System.out.println(list3);
	}
public static void main(String[] args) {
		List list = new ArrayList();
		Collections.addAll(list, 2,5,1,0,8);
		Collections.sort(list);
		Collections.reverse(list);
		int index = Collections.binarySearch(list, 0);
		System.out.println(index); //0
	}
```

