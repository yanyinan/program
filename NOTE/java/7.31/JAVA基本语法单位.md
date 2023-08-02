### 注释

```java
.单行注释：
	// 后面根解释文字
2.多行注释
	/*
		这里写注释文字
		可以写多行
	*/
3.文档注释
	/**
		这里写文档注释
		也可以写多行，文档注释可以利用JDK的工具生成帮助文档
	*/
```

### 字面量

| 常用数据 | 生活中的写法 | 程序中的写法 | 说明                                   |
| -------- | ------------ | ------------ | -------------------------------------- |
| 整数     | 666，-88     | 666，-88,0   | 写法一致                               |
| 小数     | 13.14，-5.21 | 13.14，-5.21 | 写法一致                               |
| 字符     | A,0,我       | ‘A’,‘0’，'我 | 程序中必须使用单引号，有且仅能一个字符 |
| 字符串   | 开发喵       | “开发喵”,“0” | 程序中必须使用双引号，内容可有可无     |
| 布尔值   | 真，假       | true\false   | 只有两个值，true表示真，false表示假    |
| 空值     |              | 值是null     | 一个特殊的值，空值                     |

### 变量

```
数据类型 变量名称 = 初始值;
```

### 标识符

1. 标识符由字母（ A~Z 和 a~z ）、数字（0~9）、下划线（_）、美元符号（$）以及部分Unicode字符集（各符号之间没有空格）组成。
2. 标识符的首字母以字母、下划线或美元符号开头，后面可以是任何字母、数字、美元符号或下划线，但不能以数字开头。
3. 标识符的命名不能是关键字、布尔值（true、false）和null。
4. 标识符区分大小写，没有长度限制。

### 关键字

| **abstract** | **default** | **if**         | **protected**    | **throws**    |
| ------------ | ----------- | -------------- | ---------------- | ------------- |
| **assert**   | **do**      | **implements** | **public**       | **transient** |
| **boolean**  | **double**  | **import**     | **return**       | **try**       |
| **break**    | **else**    | **instanceof** | **strictfp**     | **void**      |
| **byte**     | **enum**    | **int**        | **short**        | **volatile**  |
| **case**     | **extends** | **interface**  | **static**       | **while**     |
| **catch**    | **final**   | **long**       | **super**        | **_**         |
| **char**     | **finally** | **native**     | **switch**       |               |
| **class**    | **float**   | **new**        | **synchronized** |               |
| **const**    | **for**     | **package**    | **this**         |               |
| **continue** | **goto**    | **private**    | **throw**        |               |

### 数据类型转换

- 自动类型转换（扩展原始转换）

  guage-mermaid

  ```mermaid
  flowchart LR
      byte --> short --> int --> long --> float --> double
      		char --> int
  ```

  > 多种数据类型参与运算，其结果以大的数据类型为准
  > `byte`,`short`,`char` 三种类型数据在和其他类型数据运算时，都会转换为`int`类型再运算

- 强制类型转换（缩小原始转换）

  `目标数据类型 变量名 = (目标数据类型)被转换的数据;`

  ```java
  0102int a = 10;
  byte b = (byte)a;
  ```

```java
public class TypeConversionDemo3 {
	public static void main(String[] args) {
		// 目标：掌握强制类型转换。
		int a = 20;
		byte b = (byte) a;
		System.out.println(a);
		System.out.println(b);
        
		int i = 1500;
		byte j = (byte) i;
		System.out.println(j);
        
		double d = 99.5;
		int m = (int) d; // 强制类型转换
		System.out.println(m); // 丢掉小数部分，保留整数部分
	}
}
```

### 字符在计算机中的存储原理

> ASCII编码表中字符编码的规律：
>
> 1. 1.字符0对应48，后面的1,2,3,4…9 对应的十进制整数依次往后顺延
> 2. 2.字符a对应97，后面的b,c,d,e…z 对应的十进制整数依次往后顺延
> 3. 3.字符A对应65，后面的B,C,D,E…Z 对应的十进制整数依次往后顺延



![image-20230731211747156](https://s2.loli.net/2023/07/31/N7FRjUxLMhnO5ua.png)