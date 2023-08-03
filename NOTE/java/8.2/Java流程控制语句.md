## 程序流程控制

基本结构包括顺序结构、选择结构和循环结构。

### 顺序结构

![image-20230803190943971](https://s2.loli.net/2023/08/03/rwB6AeWtfpO4Gm2.png)

是指程序按照语句的书写顺序依次执行，没有中间的判断、跳转或循环。每条语句按照顺序执行，没有跳过或重复的部分。

### 选择结构

![image-20230803191140447](https://s2.loli.net/2023/08/03/ezd7ki5b9GLFJyS.png)

选择结构根据条件判断的结果选择执行不同的代码。选择结构可以细分为单分支结构、双分支结构和多分支结构。

### 循环结构

![image-20230803191352080](https://s2.loli.net/2023/08/03/hbEsO3ZdAzgjVtK.png)

循环结构根据判断条件重复执行某段代码。

## 选择结构

### if控制语句

#### 单分支结构

##### 流程如图

![image-20230803191706225](https://s2.loli.net/2023/08/03/JvsM9lcYQXgd5jR.png)

##### 语法规则

```java
if(表达式){
    语句
}
```

#### 双分支结构

##### 流程如图

![image-20230803191726438](https://s2.loli.net/2023/08/03/c9T8CQuqVFbwv4a.png)

##### 语法规则

```java
if(表达式){
    语句
}else{
    语句
}
```

#### 多分支结构

##### 流程如图

![image-20230803191741713](https://s2.loli.net/2023/08/03/oq7iX1Qbm8dMnxS.png)

##### 语法规则

```java
if(表达式1){
    语句
}else if(表达式2){
    语句2
}else{
    语句3
}
```

### 嵌套if控制语句

```java
if(表达式1){
    if(表达式){
        语句
    }else{
        语句    
    }
}else if(表达式2){
    语句
}
}else{
    语句
}
```

### Switch语句

#### 一般

语法规则如下：

```java
switch(expression){
    case value :
       //语句
       break; //可选
    case value :
       //语句
       break; //可选
    //你可以有任意数量的case语句
    default : //可选
       //语句
}
```

![img](https://www.runoob.com/wp-content/uploads/2018/09/java-switch-case-flow-diagram.jpeg)

> 如果case后面没有break语句，程序将继续执行下一个case，直到遇到break语句或Switch语句。

#### `java12`开始的升级

```
switch(expression){
    case value ->语句；
    case value ->语句；
    default ->语句；
}
```

**新特性：**

1. 箭头表达式：从`Java12`开始,`switch`语句升级为更简洁的表达式语法，使用类似模式匹配的方法。保证只有一种路径执行，并且不需要break语句。
2. `yield`大多时候。在`Switch`表达式内部，只返回简单的值。返回时可以选择yield只返回一个值作为`switch`语句的返回值。
3. `case`匹配多个值：把相同逻辑的`case`放在一起。

## 循环结构

### while循环结构

#### 语法规则

```java
while( 布尔表达式 ) {
  //循环内容
}
```

#### 流程图

![image-20230803201340424](https://s2.loli.net/2023/08/03/uKdp2YMmcNORqtr.png)

### do-while循环结构

#### 语法规则

```java
循环变量初始化
do{
  //循环内容
}while( 布尔表达式 )
```

#### 流程图

![image-20230803201524849](https://s2.loli.net/2023/08/03/m1zgpsEeGOUZ9Ka.png)

### for循环结构

#### 语法规则

```java
for(初始化; 布尔表达式; 更新) {
    //代码语句
}
```

#### 流程图

![image-20230803201915157](https://s2.loli.net/2023/08/03/ouOBrAURPJb41Yj.png)

### 多重循环

```java
while( 布尔表达式 ) {
  //循环内容
    for(初始化; 布尔表达式; 更新) {  
        while( 布尔表达式 ) { 
            //循环内容    
        }
    }
}
```

### 循环区别

|    循环    |      特点      |          使用场合          |
| :--------: | :------------: | :------------------------: |
|   `for`    | 先判断，后执行 | 适用在一直循环次数的情况下 |
|  `while`   | 先判断，后执行 | 适合先判断，后执行的情况下 |
| `do-while` | 先执行，后判断 | 适合先执行，后判断的情况下 |

