## 运算符

运算符就是参与运算的符号。Java提供的运算符有很多种，可以分为下面几种：

- 基本算术运算符
- 自增自减运算符
- 赋值运算符
- 关系运算符
- 逻辑运算符
- 三元运算符

### 算术运算符

   算术运算符有 + - * / % ，其中 * 表示乘 法， / 表示除法， % 表示取余数。
| 符号 | 作用 | 说明                                              |
| ---- | ---- | ------------------------------------------------- |
| +    | 加   | 与算术的相加相同                                  |
| -    | 减   | 与算术的相减相同                                  |
| \*   | 乘   | 与“X”相同                                         |
| /    | 除   | 与“÷”相同，注意：再java中两个整数相除结果还是整数 |
| %    | 取余 | 获取的是两个数据做除法的余数                      |

> 需要主义的是： ` + `除了用于加法运算，还可以作连接符。` +` **符号与字符串运算的额时候是用作连接符的，其结果依然是一个字符串。**

例： 

```java
public class OperatorDemo1 {
public static void main(String[] args) {
// 目标：掌握基本的算术运算符的使用。
int a = 10;
int b = 2;
System.out.println(a + b); // 12
System.out.println(a - b); // 8
System.out.println(a * b); // 20
System.out.println(a / b); // 5 整数 / 整数 = 整数
System.out.println(5 / 2); // 2
System.out.println(5.0 / 2); // 2.5
int i = 5;
int j = 2;
System.out.println(1.0 * i / j); // 2.5
System.out.println(a % b); // 0
System.out.println(3 % 2); // 1
System.out.println("-------------------------------------
--");
// 目标2：掌握使用+符号做连接符的情况。
int a2 = 5;
System.out.println("abc" + a2); // abc5
System.out.println(a2 + 5); // 10
System.out.println("kaifamiao" + a2 + 'a'); //
kaifamiao5a
System.out.println(a2 + 'a' + "kaifamiao"); //
5akaifamiao 102kaifamiao
	}
}
```

### 自增自减以运算符

`++` 读作自增、`--`读作自减。

运算规则：

| 符号     | 作用                                        |
| -------- | ------------------------------------------- |
| 自增：++ | 放在某个变量的前面或后面，对变量自身的值加1 |
| 自减：—— | 放在某个变量的前面或后面，对变量自身的值减1 |

> 需要我们注意的是，自增自减只能对变量进行操作，不能操作字面量。具体使用时也 分为两种情况，如下:

```java
// 1.单独使用：++或者--放在变量前面没有区别
int a = 10;
a++; // 1
--a; // 10
System.out.println(a); // 10
// 2.混合使用：++或者--放在变量或者前面运算规则稍有不通过 ++ 在后 先赋值 再自增 ++ 在前 先自增再赋值
int a = 10;
int b = a++;
int c = ++a;
System.out.println(a); // 12
System.out.println(b); // 10
System.out.println(c); // 12
int x = 10;
int y = --x;
x = 9 y = 9
```

### 赋值运算符

基本的复制运算符`=`,意思是把右边的数值赋值给左边的变量。

```java
int a = 10;     //将数据10赋值给左边的变量
```

除了基本的赋值运算符，我们在了解一下扩展的运算符，有：`+=`,`-=`,`8=`,`/=`,`%=`。

| 符号 | 用法 | 作用       | 底层代码形式          |
| ---- | ---- | ---------- | --------------------- |
| +=   | a+=b | 加后赋值   | a=(a的类型)（a+b;     |
| -=   | a-=b | 减后赋值   | a=(a的类型)（a-b;     |
| *=   | a*=b | 乘后赋值   | a = (a的类型)(a * b); |
| /=   | a/=b | 除后赋值   | a = (a的类型)(a / b); |
| \%=  | a%=b | 取余后赋值 | a = (a的类型)(a % b); |

> 以 ``+=`` 为例来看一下它的运算规则，其他的运算符运算同理分析即可。

```java
int a = 10;
a += 5; // a = a + 5;
System.out.println(a); // 15
```

例：

```java
// 问题1：下面的代码否有问题？
byte x = 10;
byte y = 30;
x = x + y; // byte char short 转换成int类型进行计算
System.out.println(x); // 报错
// 问题2：下面的代码是否有问题？
byte x = 10;
byte y = 30;
// x += 3;
x += y; // x = (byte) (x + y);
System.out.println(x); // 40
```

### 关系运算符

下表是每一种关系运算符的符号及作用，每一个关系运算符的结果都是boolean值 （true、false）

![image-20230801165544381](https://s2.loli.net/2023/08/01/njrK7JIvBW9Np42.png)

下面通过代码来家演示一下，各种关系运算符的效果：

```java
public class Demohhhhjkhghjhjj {
public static void main(String[] args) {
    // 目标：掌握关系运算符的基本使用。
    int a = 10;
    int b = 5;
    boolean rs = a > b;
    System.out.println(rs); // true
    System.out.println(a >= b); // true
    System.out.println(2 >= 2); // true
    System.out.println(a < b); // false
    System.out.println(a <= b); // false
    System.out.println(2 <= 2); // true
    System.out.println(a == b); // false
    System.out.println(5 == 5); // true
    // 注意了：判断是否相等一定是用 == ，=是用来赋值的。
    System.out.println(a = b); // 5 报错
    System.out.println(a != b); // true
    System.out.println(10 != 10); // false
	}
} 
```

> 关系运算符在程序中常用于条件判断，根据条件判断的结果是true还是false，来决定 后续该执行哪些操作。

### 逻辑运算符

逻辑运算符是用来将多个条件放在一起运算，最终结果是true或者false。

![image-20230801165940640](https://s2.loli.net/2023/08/01/wRrpbi9ZDfxISQ1.png)

> 逻辑运算符在程序中常用于组合几个条件判断，根据条件判断的结果是true还是 false，来决定后续该执行哪些操作。

### 位运算符

在计算及内部，数据以二进制（0和1）的形式存储和处理。计算机通过数据转换为二进制形式，将其存储在内存中，并对其进行操作和计算和操作。不同的数据类型在内存中占据不同的二进制位，以便正确的表示和处理数据。

1. 源码：源码是一种最简单的机器数表示法，其中最高表示符号位，其余位表示该数的二进制的绝对值。
2. 反码：正数的反码与与原码相同，而负数的反码是其原码除符号位外，按位取反的结果。
3. 补码：正数的补码等于其补码，而负数的补码等于其反码加1。

![image-20230801172129577](https://s2.loli.net/2023/08/01/fTs4PGZDEXkmY5l.png)

```java
// 计算5&6的结果
// 计算5|6的结果
// 计算3<<2的结果
// 计算16>>2的结果
// 计算-12 | 2的结果
```

### 三元运算符

三元运算符格式：

```java
数据类型 变量名 = 关系表达式 ? 值1 : 值2;
```

> 三元运算的执行流程：首先计算关系表达式的值，如果关系表达式的值为true，则返 回值1；如果关系表达式的值为false, 则返回值2。

### 运算优先级

![ ](https://s2.loli.net/2023/08/01/pzUN9scrGh4w3MR.png)

> 在实际开发中，其实我们很少考虑运算优先级， 因为如果 你想让某些数据先运算，其实加 () 就可以了，这样阅读性更高。