# `java`中对象和`JSON`格式的转换

## `JSON`

`JSON(javaScript Object Notation)`是**一种轻量级的数据交换格式**，具有良好的可读性和可拓展性。

它采用键值对的方式表示数据，支持基本数据类型和复合数据类型。可用于描述结构化数据和非结构化数据。

### 结构

#### 对象结构（无序）：

>无序的对象结构在不同语言中称法不同

对象（object）：一个对象包含一系列非排序的`键／值对`，一个对象以 `{`开始，并以 `}`结束。每个键／值对之间使用 `:`分区。多个键值对之间通过 `,` 分割。

#### 数组结构（有序）：

> 有序的的数组结构。将数组作为有序数组进行转换`JSON`，就可以得到有序的`JSON`数组结构

数组：一个数组包含一系列排序的`键／值对`，一个对象以 `[`开始，并以 `]`结束。每个键／值对之间使用 `:`分区。多个键值对之间通过 `,` 分割。

![img](https://pic2.zhimg.com/v2-2576f821a9068050e2a696753a483091_r.jpg)

### tips:

1. 需要注意的是`JSON` 的键是一个 `String` 类型的字符串。
2. 值（value）：可以是双引号括起来的`字符串（string）`、`数值(number)`、`true`、`false`、 `null`、`对象（object）`或者`数组（array）`。这些结构可以嵌套使用。
3. `JSON`格式不支持注释，且字符串必须使用双引号`""`，而不是 单引号。
4. `JSON`格式可以使用一些转义字符

## `JSON`在`java`中的使用

> Java中并没有内置`JSON`的解析，因此使用`JSON`需要借助第三方类库。

`java `中常见的解析` json` 的**第三方库(jar包)**：

1. -`JSON官方`
2. \-` GSON`
3. \- `FastJson`
4. \-` Jackson 2`
5. \- `hutool-json`

### 每种方式生成和解析进行阐述

#### 1.使用JSON官方提供的JSON

官方提供的JSON具有通用性，就是解析时有点费事。
**maven依赖:**

```java
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20180130</version>
</dependency>
```

**生成`JSON`对象**
*1.使用`JSONObject`添加对象*
代码：

```java
 @Test
    public void Test3(){
    	//创建JSON对象
        JSONObject jsonObject = new JSONObject();
        Object obj = null;
        //像JSON对象中添加数据
        jsonObject.put("name", "张三");
        jsonObject.put("age", 20);
        jsonObject.put("birth", "1998-01-01");
        jsonObject.put("haveCar", obj);
        jsonObject.put("hasGirlfriend", true);
        jsonObject.put("likes", new String[]{"看电影", "看书"});
		//将JSON对象以字符串的形式打印
        System.out.println(jsonObject.toString());
        
    }
```


结果：

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020052416105282.png)


在字符串输出的时候会发现，输出的字符串与数据存储的顺序可能是不一致的。原因是调用`jsonObject.put()`方法的时候，其底层是一个 `HashMap`，数据被存到了`HashMap` 中。 `HashMap`根据键的哈希码来决定键的位置，所以可能会出现上面的问题。

*2.`javaBean`转`JSON`*
javaBean：

```java
public class User {
    private String name;
    private int age;
    private String[] likes;
    // 省略 get 与 set 方法
}
```

JavaBean TO JSON：

    public static void beanToJsonTest() {
        User user = new User();
    
        user.setName("张三");
        user.setAge(20);
        user.setLikes(new String[]{"看电影", "看书"});
    
        JSONObject jsonObject = new JSONObject(user);
        System.out.println(jsonObject.toString());
    }
1
2
3
4
5
6
7
8
9
10
解析JSON
首先有两张表，分别是学生表和年级表，年纪和学生是一对多关系，这里我就不展示表了，太简单了。直接上解析代码：（不懂一定要看注释哦！）

//JSON字符串
String json = "{'id':1,'name':'JAVAEE-1703','stus':[{'id':101,'name':'刘一','age':16},{'id':102,'name':'刘二','age':23}]}";
//将JSON字符串转为JSON对象
JSONObject jsonObject = JSONObject.fromObject(json);
//创建年级对象，然后进行解析JSON，并赋值
Grade grade = new Grade();
grade.setId(jsonObject.getInt("id"));
grade.setName(jsonObject.getString("name"));
//创建一个集合用来存储学生对象
ArrayList<Student> students = new ArrayList<>();
JSONArray stus = jsonObject.getJSONArray("stus");
//遍历JSONArray对象，解析后放入集合中
for (Object o : stus) {
    JSONObject jsonObject1 = JSONObject.fromObject(o);
    Student student = new Student(jsonObject1.getInt("id"),jsonObject1.getString("name"), jsonObject1.getInt("age"));
    students.add(student);
    }
grade.setStus(students) ;   
//至此一个JSON字符串解析为Java对象

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
2.使用GSON
依赖

        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.2</version>
        </dependency>
1
2
3
4
5
生成JSON对象:

    public static void beanToJsonTest() {
        User user = new User();
    
        user.setName("张三");
        user.setAge(20);
        user.setLike(new String[]{"看电影", "看书"});
    
        /**
        * 使用GsonBuilder 可以作一些额外处理，比如格式化输出，预处理等
        * 
        * GsonBuilder gsonBuilder = new GsonBuilder();
        * gsonBuilder.setPrettyPrinting();    
        * Gson gson = gsonBuilder.create();
        */
        Gson gson = new Gson();
        System.out.println(gson.toJson(user));
    }

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
解析JSON

public static void jsonToBeanTest() {
        String jsonStr = "{\"name\":\"李四\",\"age\":22 , \"like\":[\"看电影\",\"看书\"],\"birth\":\"1996-01-01\"}";
        GsonBuilder gsonBuilder = new GsonBuilder();
        // 设置日期转换格式
        gsonBuilder.setDateFormat("yyyy-MM--dd");   
        Gson gson = gsonBuilder.create();
        //解析对象：第一个参数：待解析的字符串 第二个参数结果数据类型的Class对象
        User user = gson.fromJson(jsonStr, User.class);
    }
1
2
3
4
5
6
7
8
9
不用get取值，set赋值了，看起来好爽啊。有没有？

 String json2 = "['北京','天津','杭州']";
 //解析数组要求使用Type
 ArrayList<String> list=gson.fromJson(json2, new TypeToken<ArrayList<String>>(){}.getType());
 System.out.println(list);
1
2
3
4
3.使用FastJSON
FastJSON是阿里巴巴的产品，效率最高，深受广大程序员的喜爱，哈哈。但这里有很多东西我这里只写一下上面的老套路，生成和解析。想更多了解的可以去看这个FastJson。超赞的。
依赖

<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.47</version>
</dependency>
1
2
3
4
5
生成JSON对象：
创建JSON 对象非常简单，只需使用 JSONObject（fastJson提供的json对象） 和 JSONArray（fastJson提供json数组对象） 对象即可。

@Test
public void whenGenerateJson_thanGenerationCorrect() throws ParseException {
    JSONArray jsonArray = new JSONArray();
    for (int i = 0; i < 2; i++) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AGE", 10);
        jsonObject.put("FULL NAME", "Doe " + i);
        jsonObject.put("DATE OF BIRTH", "2016/12/12 12:12:12");
        jsonArray.add(jsonObject);
    }
    String jsonOutput = jsonArray.toJSONString();

解析JSON

@Test
public void whenJson_thanConvertToObjectCorrect() {
    Person person = new Person(20, "John", "Doe", new Date());
    String jsonObject = JSON.toJSONString(person);
    Person newPerson = JSON.parseObject(jsonObject, Person.class);

JSON 对象与字符串的相互转化
最常用的就是这个直接转化了，来吧：

//从字符串解析JSON对象
JSONObject obj = JSON.parseObject("{\"runoob\":\"菜鸟教程\"}");
//从字符串解析JSON数组
JSONArray arr = JSON.parseArray("[\"菜鸟教程\",\"RUNOOB\"]\n");
//将JSON对象转化为字符串
String objStr = JSON.toJSONString(obj);
//将JSON数组转化为字符串
String arrStr = JSON.toJSONString(arr);

4.使用JackSon
jackSon解析JSON，SpringMVC内置的解析器就是这个
依赖

<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.8</version>
</dependency>


生成JSON字符串

ArrayList<Student> students = new ArrayList<>();
for (int i = 0; i < 3; i++) {
     students.add(new Student(100 + i, "二稿" + i, 1000 + i));
}
Grade grade = new Grade(22, "语文", students);
ObjectMapper objectMapper = new ObjectMapper();
String s = objectMapper.writeValueAsString(grade);
System.out.println(s);

解析JSON字符串

// 对象嵌套数组嵌套对象
String json1 = "{\"id\":1,\"name\":\"JAVAEE-1703\",\"stus\":[{\"id\":101,\"name\":\"刘一\",\"age\":16}]}";
// 数组
String json2 = "[\"北京\",\"天津\",\"杭州\"]";

ObjectMapper mapper = new ObjectMapper();
Grade grade = mapper.readValue(json1, Grade.class);
System.out.println(grade);

List<String> list = mapper.readValue(json2, newTypeReference<List<String>>() {});
System.out.println(list)


### tips:

此时，我们深克隆实现就有三种了：
\- 自定义 clone 实现 【麻烦死了】
  \- 将引用数据类型的字段也克隆一份
\- 使用序列化实现
  \- 将对象序列化为字节流，再反序列化为对象
\- 通过`JSON`，使用第三方库实现 【推荐】
  \- 使用第三方库实现深克隆，比如：`GSON、FastJson、Jackson 2、hutool-json`