

# `Stream`流

在`Java 8`中，得益于`Lambda`所带来的函数式编程，引入了一个全新的`Stream`概念，用于解决已有集合类库既有的弊端。

## 1.1 集合的迭代

几乎所有的集合（如 `Collection `接口或 `Map` 接口等）都支持直接或间接的迭代遍历操作。而当我们需要对集合中的元素进行操作的时候，除了必需的添加、删除、获取外，最典型的就是集合遍历。例如：

```java
public class Demo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张三");
        list.add("张三丰");
        for (String name : list) {
            System.out.println(name);
        }

    }
}
```

这是一段非常简单的集合遍历操作：对集合中的每一个字符串都进行打印输出操作。

**循环遍历的弊端**
`Java 8`的`Lambda`让我们可以更加专注于做什么（`What`），而不是怎么做（`How`），这点此前已经结合内部类进行了对比说明。现在，我们仔细体会一下上例代码，可以发现：

- `for`循环的语法就是“怎么做”
- `for`循环的循环体才是“做什么”

为什么使用循环？因为要进行遍历。但循环是遍历的唯一方式吗？遍历是指每一个元素逐一进行处理，而并不是从第一个到最后一个顺次处理的循环。前者是目的，后者是方式。
试想一下，如果希望对集合中的元素进行筛选过滤：

1. 将集合A根据条件一过滤为子集B；
2. 然后再根据条件二过滤为子集C。

那怎么办？在`Java 8`之前的做法可能为：

这段代码中含有三个循环，每一个作用不同：

1. 首先筛选所有姓张的人；
2. 然后筛选名字有三个字的人；
3. 最后进行对结果进行打印输出。

```java
public class DemoFilter {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张三");
        list.add("张三丰");

        List<String> zhangList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张")) {
                zhangList.add(name);
            }
        }
        List<String> shortList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length() == 3) {
                shortList.add(name);
            }
        }
        for (String name : shortList) {
            System.out.println(name);
        }

    }
}
```

每当我们需要对集合中的元素进行操作的时候，总是需要进行循环、循环、再循环。这是理所当然的么？不是。循环是做事情的方式，而不是目的。另一方面，使用线性循环就意味着只能遍历一次。如果希望再次遍历，只能再使用另一个循环从头开始。
那，`Lambda`的衍生物`Stream`能给我们带来怎样更加优雅的写法呢？

```java
public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("阳顶天");
        list.add("小昭");
        list.add("杨逍");
        list.add("杨过");
        list.add("韦一笑");
        list.add("谢逊");
        list.add("灭绝师太");
        list.add("静虚师太");

        //获取list的stream流
        Stream<String> listStream = list.stream();
        //stream.filter(boolean)  当boolean = true 是保留，false移除
        //过滤流中的非姓张的人名 //boolean test(T t)
        Stream<String> zhangStream = listStream.filter(t -> t.startsWith("张"));
        //姓张 且名字长度是3个字的
        Stream<String> shortStream = zhangStream.filter(t -> t.length() == 3);

        //迭代输出  //void accept(T t)
        shortStream.forEach(t -> System.out.println(t));

        //等同于
        list.stream().filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .forEach(s -> System.out.println(s));
    }
```

直接阅读代码的字面意思即可完美展示无关逻辑方式的语义：获取流、过滤姓张、过滤长度为3、逐一打印。代码中并没有体现使用线性循环或是其他任何算法进行遍历，我们真正要做的事情内容被更好地体现在代码中。流式版本比之前的写法要更易于阅读，因为流遵循了"做什么而非怎么做"的原则。

流表面上看起来和集合很类似，都可以让我们转换和获取数据。但是，它们之间存在着显著的差异：
1. 流并不存储其元素。这些元素可能存储在底层的集合中，或者是按需生成的。

2. 流的操作不会修改其数据源。例如，`filter`方法不会从新的流中移除元素，而是会生成一个新的流，其中不包含被过滤掉的元素。

3. 流的操作是尽可能惰性执行的。这意味着直至需要其结果时，操作才会执行。

  例如：
    如果我们只想査找前5个长单词而不是所有的长单词，那么`filter`方法就会在匹配到第 5 个单词后就停止过滤。

## 1.2 流式思想

> **注意：请暂时忘记对传统IO流的固有印象！**

整体来看，流式思想类似于工厂车间的“生产流水线”

![](img\stream.jpg)

当需要对多个元素进行操作（特别是多步操作）的时候，考虑到性能及便利性，我们应该首先拼好一个“模型”步骤方案，然后再按照方案去执行它。

![](img\stream.png)

这张图中展示了过滤、映射、跳过、计数等多步操作，这是一种集合元素的处理方案，而方案就是一种“函数模型”。图中的每一个方框都是一个“流”，调用指定的方法，可以从一个流模型转换为另一个流模型。而最右侧的数字3是最终结果。
这里的 `filter` 、 `map` 、 `skip` 都是在对函数模型进行操作，集合元素并没有真正被处理。只有当终结方法 `count` 执行的时候，整个模型才会按照指定策略执行操作。而这得益于`Lambda`的延迟执行特性。

> 备注：“Stream流”其实是一个集合元素的函数模型，它并不是集合，也不是数据结构，其本身并不存储任何元素（或其地址值）。

## 1.3 获取流方式

生成Stream流的方式

- Collection体系集合

  使用默认方法stream()生成流， default Stream<E> stream()

- Map体系集合

  把Map转成Set集合，间接的生成流

- 数组

  通过Arrays中的静态方法stream生成流

- 同种数据类型的多个数据

  通过Stream接口的静态方法of(T... values)生成流

`java.util.stream.Stream` 是`Java 8`新加入的最常用的流接口。（这并不是一个函数式接口。）

```java
public interface Stream<T> extends BaseStream<T, Stream<T>>
```

获取一个流非常简单，有以下几种常用的方式：

- 所有的 `Collection` 集合都可以通过 `stream` 默认方法获取流；
- `Stream `接口的静态方法 `of` 可以获取数组对应的流。

**根据`Collection`获取流 **

首先，` java.util.Collection` 接口中加入了`default`方法 `stream` 用来获取流，所以其所有实现类均可获取流。

```java
public class DemoGetStream {

    public static void main(String[] args) {
        /*
            获取Stream流的方式
                 1.Collection中 方法    Stream stream()
                 2.Stream接口 中静态方法  of(T...t) 向Stream中添加多个数据
         */
        List<String> list = new ArrayList<>();

        Stream<String> stream1 = list.stream();
        Set<String> set = new HashSet<>();

        Stream<String> stream2 = set.stream();

    }
}
```

**根据数组获取流**

如果使用的不是集合或映射而是数组，由于数组对象不可能添加默认方法，所以 `Stream` 接口中提供了静态方法`of` ，使用很简单：

```java
public static void main(String[] args) {
    String[] array = { "张无忌", "张翠山", "张三丰", "张翠山" };
    Stream<String> stream = Stream.of(array);
    Stream<String> stream3 = Stream.of("张小山");
    Stream<String> stream4 = Stream.of("张无忌", "张翠山", "张三丰", "张一元");
}
```

`of `方法的参数其实是一个可变参数，所以支持数组。

## 1.4 常用方法

流模型的操作很丰富，这里介绍一些常用的`API`。这些方法可以被分成两种：

- **终结方法**：返回值类型不再是 `Stream` 接口自身类型的方法，因此不再支持类似 `StringBuilder` 那样的链式调用。终结方法包括 `count` 和 `forEach`等 方法。

- 非终结方法（中间方法）：返回值类型仍然是 `Stream` 接口自身类型的方法，因此支持链式调用。（除了终结方法外，其余方法均为非终结方法。）

  > 备注：除了以下要介绍的方法外还有更多方法，请自行参考API文档。

| 方法名                                          | 说明                                                       |
| ----------------------------------------------- | ---------------------------------------------------------- |
| Stream<T> filter(Predicate predicate)           | 用于对流中的数据进行过滤                                   |
| Stream<T> limit(long maxSize)                   | 返回此流中的元素组成的流，截取前指定参数个数的数据         |
| Stream<T> skip(long n)                          | 跳过指定参数个数的数据，返回由该流的剩余元素组成的流       |
| static <T> Stream<T> concat(Stream a, Stream b) | 合并a和b两个流为一个流                                     |
| Stream<T> distinct()                            | 返回由该流的不同元素（根据Object.equals(Object) ）组成的流 |

**filter：过滤**

可以通过 `filter` 方法将一个流转换成另一个子集流。方法声明：

```java
Stream<T> filter(Predicate<? super T> predicate);
```

该接口接收一个 `Predicate` 函数式接口参数（可以是一个`Lambda`）作为筛选条件。

```java
public static void main(String[] args) {

    Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
    Stream<String> result = original.filter((String s) -> s.startsWith("张"));
    }
```

**limit：取用前几个**

`limit` 方法可以对流进行截取，只取用前`n`个。方法：

```java
Stream<T> limit(long maxSize)
```

参数是一个`long`型，如果集合当前长度大于参数则进行截取；否则不进行操作。基本使用：

```java
public static void main(String[] args) {

    Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
    Stream<String> result = original.limit(2);
    
    System.out.println(result.count()); // 2
}
```

**skip：跳过前几个**

如果希望跳过前几个元素，可以使用 `skip` 方法获取一个截取之后的新流：

```
Stream<T> skip(long n)
```

如果流的当前长度大于`n`，则跳过前`n`个；否则将会得到一个长度为0的空流。基本使用：

```java
public static void main(String[] args) {
    Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
    Stream<String> result = original.skip(2);
    System.out.println(result.count()); // 1
}

```

**concat：组合**

如果有两个流，希望合并成为一个流，那么可以使用 `Stream` 接口的静态方法` concat `：

```java
static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
```

> 这是一个静态方法，与 java.lang.String 当中的 concat 方法是不同的。

```java
public static void main(String[] args) {
    Stream<String> streamA = Stream.of("张无忌");
    Stream<String> streamB = Stream.of("张翠山");
    Stream<String> result = Stream.concat(streamA, streamB);
}

```

**distinct**: 去重

```java
 public static void main(String[] args) {
        //创建一个集合，存储多个字符串元素
        ArrayList<String> list = new ArrayList<String>();

        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        // 取前4个数据组成一个流
        Stream<String> s1 = list.stream().limit(4);

        // 跳过2个数据组成一个流
        Stream<String> s2 = list.stream().skip(2);

        
        Stream.concat(s1,s2).distinct().forEach(s-> System.out.println(s));
    }
```



**终结方法：**

**forEach : 逐一处理**

虽然方法名字叫 `forEach` ，但是与`for`循环中的`for-each`不同，该方法并不保证元素的逐一消费动作在流中是被有序执行的。

```java
void forEach(Consumer<? super T> action);
```

该方法接收一个 `Consumer` 接口函数，会将每一个流元素交给该函数进行处理。例如：

```java
public class DemoForEach {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张无忌", "张三丰", "周芷若");
        stream.forEach((String str)->{System.out.println(str);});
    }
}
```

在这里，`lambda`表达式 `(String str)->{System.out.println(str);}` 就是一个`Consumer`函数式接口的示例。

**count：统计个数**

正如旧集合 `Collection` 当中的 `size` 方法一样，流提供 `count` 方法来数一数其中的元素个数：

```java
long count();
```

此处方法返回值是`long`而不是`int`

```java
public static void main(String[] args) {

    Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
    Stream<String> result = original.filter((String s) -> s.startsWith("张"));
    System.out.println(result.count()); // 2
}
```

在上述介绍的各种方法中，凡是返回值仍然为` Stream` 接口的为**函数拼接方法**，它们支持链式调用；而返回值不再为`Stream` 接口的为**终结方法**，不再支持链式调用。

![](img\stream2.png)

### Stream流的收集操作【应用】

- 概念

  对数据使用Stream流的方式操作完毕后,可以把流中的数据收集到集合中

- 常用方法

  | 方法名                         | 说明               |
  | ------------------------------ | ------------------ |
  | R collect(Collector collector) | 把结果收集到集合中 |

- 工具类Collectors提供了具体的收集方式

  | 方法名                                                       | 说明                   |
  | ------------------------------------------------------------ | ---------------------- |
  | public static <T> Collector toList()                         | 把元素收集到List集合中 |
  | public static <T> Collector toSet()                          | 把元素收集到Set集合中  |
  | public static  Collector toMap(Function keyMapper,Function valueMapper) | 把元素收集到Map集合中  |

- 代码演示

```java
// toList和toSet方法演示 
public class MyStream7 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list1.add(i);
        }

        list1.add(10);
        list1.add(10);
        list1.add(10);
        list1.add(10);
        list1.add(10);

        //filter负责过滤数据的.
        //collect负责收集数据.
                //获取流中剩余的数据,但是他不负责创建容器,也不负责把数据添加到容器中.
        //Collectors.toList() : 在底层会创建一个List集合.并把所有的数据添加到List集合中.
        List<Integer> list = list1.stream().filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(list);

    Set<Integer> set = list1.stream().filter(number -> number % 2 == 0)
            .collect(Collectors.toSet());
    System.out.println(set);
}
}
/**
Stream流的收集方法 toMap方法演示
创建一个ArrayList集合，并添加以下字符串。字符串中前面是姓名，后面是年龄
"zhangsan,23"
"lisi,24"
"wangwu,25"
保留年龄大于等于24岁的人，并将结果收集到Map集合中，姓名为键，年龄为值
*/
public class MyStream8 {
	public static void main(String[] args) {
      	ArrayList<String> list = new ArrayList<>();
        list.add("zhangsan,23");
        list.add("lisi,24");
        list.add("wangwu,25");

        Map<String, Integer> map = list.stream().filter(
                s -> {
                    String[] split = s.split(",");
                    int age = Integer.parseInt(split[1]);
                    return age >= 24;
                }

         //   collect方法只能获取到流中剩余的每一个数据.
         //在底层不能创建容器,也不能把数据添加到容器当中

         //Collectors.toMap 创建一个map集合并将数据添加到集合当中

          // s 依次表示流中的每一个数据

          //第一个lambda表达式就是如何获取到Map中的键
          //第二个lambda表达式就是如何获取Map中的值
        ).collect(Collectors.toMap(
                s -> s.split(",")[0],
                s -> Integer.parseInt(s.split(",")[1]) ));

        System.out.println(map);
	}
}
```

### Stream流综合练习

### 案例需求

- 现在有两个ArrayList集合，分别存储6名男演员名称和6名女演员名称，要求完成如下的操作

  - 男演员只要名字为3个字的前三人
  - 女演员只要姓林的，并且不要第一个
  - 把过滤后的男演员姓名和女演员姓名合并到一起
  - 把上一步操作后的元素作为构造方法的参数创建演员对象,遍历数据

  演员类Actor已经提供，里面有一个成员变量，一个带参构造方法，以及成员变量对应的get/set方法

- 代码实现

  演员类

  ```java
  public class Actor {
      private String name;
  
      public Actor(String name) {
          this.name = name;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  }
  ```

  测试类

```java
public class StreamTest {
    public static void main(String[] args) {
        //创建集合
        ArrayList<String> manList = new ArrayList<String>();
        manList.add("周润发");
        manList.add("成龙");
        manList.add("刘德华");
        manList.add("吴京");
        manList.add("周星驰");
        manList.add("李连杰");
        ArrayList<String> womanList = new ArrayList<String>();
        womanList.add("林心如");
        womanList.add("张曼玉");
        womanList.add("林青霞");
        womanList.add("柳岩");
        womanList.add("林志玲");
        womanList.add("王祖贤");

        //男演员只要名字为3个字的前三人
        Stream<String> manStream = manList.stream().filter(s -> s.length() == 3).limit(3);

        //女演员只要姓林的，并且不要第一个
        Stream<String> womanStream = womanList.stream().filter(s -> s.startsWith("林")).skip(1);

        //把过滤后的男演员姓名和女演员姓名合并到一起
        Stream<String> stream = Stream.concat(manStream, womanStream);

        // 将流中的数据封装成Actor对象之后打印
        stream.forEach(name -> {
            Actor actor = new Actor(name);
            System.out.println(actor);
        }); 
    }
```
}



作业：

了解并使用`Files.lines`方法