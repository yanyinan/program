# 常见数据类型

|  数据类型名称   |                             描述                             |
| :-------------: | :----------------------------------------------------------: |
|    SMALLINT     | 小的整数，带符号的范围是-32768到32767.无符号的范围是0到65535 |
|    MEDIUMINT    |          中等大小整数-8388608到8388607，0到16777215          |
| **INT/INTEGER** |  普通大小的整数，-2147483648到2,147,483,647，0到4294967295   |
|     BIGINT      | 大整数，-9223372036854775808到9223372036854775807，0到18446744073709551615 |
|      FLOAT      | 小(单精度)浮点数，允许的值-3.402823466E+38到-1.175494351E-38,0和1.175494351E-38到3.402823466E+38,这些是理论限制，基于IEEE标准。实际的范围根据硬件或操作系统的不同可能稍微小些 |
|   **DOUBLE**    | 普通大小(双精度)浮点数，允许的值-1.7976931348623157E+380到-2.2250738585072014E-308,0和2.2250738585072014E-38到 1.7976931348623157E+308.这些事理论限制，基于IEEE标准。实际的范围根据硬件或操作系统的不同可能稍微小些 |
|    **DATE**     | 日期，支持的范围为‘1000-01-01’到‘9999-12-31’，MySQL以'YYYY-MM-DD'格式显示DATE值，但允许使用字符串或数字为DATE列分配值 |
|  **DATETIME**   | 日期和时间的组合。支持的范围是‘上面加上00：00：00’到‘上面第二个加上23：59：59’.MySQL以YYYY-MM-DD HH:MM:SS“格式显示DATETIME值，但允许使用字符串或数字为DATETIME列分配值 |
|  **TIMESTAMP**  |         时间戳，范围是'1970-01-01 00:00:00'到2037年          |
|    **TIME**     | 时间，范围是‘-838：59：59’到‘838：59：59’.MySQL以‘HH:MM:SS’格式显示TIME值，但允许使用字符串或数字为TIME列分配值 |
|      YEAR       | 两位或四位格式的年。默认是四位格式。在四位格式中，允许的值是1901到2155和0000.在两位格式中，允许的值是70到69，表示从1970到2069年。MySQL以yyyy格式显示YEAR值，但允许使用字符串或数字为YEAR列分配值 |
|     CHAR(M)     | 固定长度字符串，当保存时在右侧填充空格以达到指定长度。M表示列长度。M的范围是0到255个字符 |
| **VARCHAR(M)**  | 变长字符串。M表示最大列长度。M的范围是0到65535.（VARCHAR的最大实际长度由最长的行的大小和使用的字符集确定。最大有效长度是65355字节） |
|    BLOB[(M)]    | 最大长度为65535(216-1)字节，=的BLOB列，可以给出该类型的可选长度M。如果给出，则MySQL将列创建为最小的但是足以容纳M字节长度的值的BLOB类型 |
|    TEXT[(M)]    | 长字符串，最大长度为65535(216-1)字符的TEXT列。可以给出可选长度M。则MySQL将列创建为最小的但是足以容纳M字符长度的值的TEXT类型。 |

# SQL 分类

-  **DCL:** 数据控制语言，用来创建数据库用户，控制数据库的访问权限(见[Mysql用户操作.md](http://39.105.197.178/archives/mysql用户操作md))
-  **DDL**: 数据定义语句,数据定义语言，用来定义数据库对象（数 据库，表，字段）。 如： CREATE / ALTER / DROP
-  **DML:** 数据操纵语句,用来对数据表中的数据进 行增删改 。如：INSERT / UPDATE / DELETE 
-  **DQL**: 数据查询语句,用来创建数据库用户，控制数据库的访问权限。如：SELECT 

> 所有的SQL都应该以英文状态下的分号结束`;`

# **DDL**: 数据定义语句

## 建库 

**数据库语句的关键词建议最好大写**

* 创建数据库语法结构：

  * CREATE DATABASE [ IF NOT EXISTS ] db_name 

  * CREATE DATABASE 表示创建数据库，是SQL中的关键词

  * db_name是要创建的数据库名称

    ```mysql
    CREATE DATABASE company_info;
    ```

    > 数据库中，命名一般是使用`_`连接多个单词;
    >
    > 数据库中 SQL 语句执行失败后会有错误提示，错误提示包括错误信息和错误编号。我们可以直接拿错误编号去搜索。
    >
    > 有时在创建数据库时要设置数据库的编码。`MySQL 8`默认编码为`UTF-8`，满足我们需求所以不需要设置。如果使用的是低版本数据库则需要在创建数据库时加上`CHARACTER SET utf8`去设置编码。或者使用`ALTER DATABASE db_name CHARACTER SET UTF8;`修改

* 使用数据库：

  * USE db_name

  * 使用USE关键词来指定要使用的数据库

    ```mysql
    USE company_info;
    ```

* 删除数据库语法结构

  * drop database db_name

  * 使用DROP关键字删除数据库

    ```mysql
    DROP DATABASE company_info;
    ```

* 显示所有的数据库

  ```shell
  SHOW DATABASES;
  ```

  

## 创建数据表

* 创建数据表的语法结构

  * ```mysql
    CREATE TABLE tab_name(
    
    col_name datatype default null/number comment '注释',
    
    col_name datatype
    
    ) [CHARACTER set 编码格式];
    ```

    

    * 使用CREATE TABLE table关键词创建数据表

    * tab_name是数据表的名称

    * col_name是列名称

    * datatype是列的数据类型

    * DEFAULT 是默认值

    * COMMENT 是注释

~~~mysql
  CREATE TABLE dept(
  deptno INT DEFAULT 1 COMMENT '部门编号',
  deptname VARCHAR(20) DEFAULT NULL COMMENT '部门名称'
  )CHARACTER SET utf8;

  -- 显示所有表
  SHOW tables;
    ```
~~~

###     创建和某表结构一样的表

```mysql
-- 创建和dept结构一样的表
CREATEABLE d LIKE dep
-- 创建表
CREATE TABLE t AS select * from d
```

# **DML:** 数据操纵语句

## 删除表

```mysql
DROP TABLE table_name
```

## 添加列

```mysql
ALTER TABLE d ADD id INT;
```

## 修改列属性

```mysql
ALTER TABLE d MODIFY id VARCHAR(20);
```

## 修改列名

```mysql
ALTER TABLE d CHANGE id ss VARCHAR(20);	
```

## 删除列

```mysql
ALTER TABLE d DROP ss;
```

## 重命名表

```mysql
RENAME TABLE d TO dd;
```

## CRUD操作

* 对数据表中的数据操作通常有添加(Create)、查询(Retrieve)、修改(Update)、删除(Delete)、简称为CRUD。

### 添加数据



**INSERT INTO table_name VALUES(值列表)** 

**INSERT INTO table_name (列列表) VALUES(值列表)**

```mysql
-- 不推荐使用
INSERT INTO dept VALUE(1,'研发部');
-- 2
INSERT INTO dept VALUES(2,'销售部');
INSERT INTO dept VALUES(3,'行政部'),(4,'技术部');
-- 3
INSERT INTO dept(deptno,deptname)VALUES(5,'安保部');
```

区别：

* value和values的区别，values可以同时插入多条数据用逗号隔开
* dept和dept(列名，列名。。。)区别，如果不写列表必须按照列表创建时的顺序每一列都要添加
* 有列名的按照列名排列顺序添加

### 查询数据

```mysql
-- 查询所有数据
SELECT *FROM dept;
-- 查询某列的数据
SELECT deptname FROM dept;
-- 根据条件查询*
SELECT deptno FROM dept WHERE deptname='销售部';
```

### 修改数据

```mysql
--全部修改为6
UPDATE dept SET deptno=6;
--根据条件修改
UPDATE dept SET deptno=1 WHERE deptname='研发部';
UPDATE dept SET deptno=2 WHERE deptname='销售部';
UPDATE dept SET deptno=3 WHERE deptname='行政部';
UPDATE dept SET deptno=4 WHERE deptname='技术部';
UPDATE dept SET deptno=5 WHERE deptname='安保部';
```

### 删除数据

```mysql
-- 删除数据 ,一定要加 where 条件
DELETE FROM dept WHERE deptno=5;
-- 全部删除c
DELETE FROM dept;
-- 清空/截断 所有数据(慎用)
TRUNCATE TABLE dept;
```

区别

* delete from dd;
* truncate table dd;
* delete 是清空表中的数据,`DML`
* truncate 是清空表数据（删除表后重新创建一个一样表），`DDL`

# **DQL**: 数据查询语句

## 查询数据

```mysql
-- 查询所有数据
SELECT *FROM dept;
-- 查询某列的数据
SELECT deptname FROM dept;
-- 根据条件查询*
SELECT deptno FROM dept WHERE deptname='销售部';
```

## 高级查询

### distinct

 在`select`语句中，可以使用`distinct`关键字对查询的结果集进行去重。

```sql
select distinct 列1, ... , 列n  from table_name [其他子句];
```

> 去重必须结果集中每个列的值都相同。;

### order by

`order by`用于对结果进行排序显示，可以使用`ASC` / `DESC`两种方式进行排序，可以有多个排序条件

- `ASC`：表示升序排序，如果不写即为此排序方式
- `DESC`：表示降序排序

```sql
select [distinct] 列1, ... , 列n from table_name [其他子句] order by 排序列1 [DESC], 排序列2 [DESC];
```

## 分页查询limit子句

```properties
select * from emp limit 0,2;
```

- 第一个参数0是表示从第几条开始查询 (这里的 0 是可以省略不写的)；
- de第二个参数 表示查询出几条数据
- 后面不够的，有多少写多少；

```java 
select * from emp order by empNo limit 5;
select * from emp limit 5,5;

-- 
select * from table_name  limit (页码 - 1) * 每页数量, 每页数量;
```

# 函数

## where条件连接

当`sql`语句中的条件有多条时，可以将多个条件连接起来。他们之间的关系有一下几种：

**`and`**

   `a and b`: 表示 需要同时满足 a 条件 和 b 条件

**`or`**

	`a or b`: 表示 满足 a 条件 或 b 条件都可以

`in`

	`in(a, ... ,b)`： 表示在 a 及 b 这些值中都可以

`like`

    模糊查询,  % 表示任意个字符  _ 表示一个字符

## 聚合函数

Mysql中内置了 5 种聚合函数，分别是：`SUM` 、`max`、`min`、`avg`、`count`。

- `sum`： 求和

  ```sql
  select sum(列) from table_name [其他子句];
  ```

- `max`: 求最大值

  ```sql
  select max(列) from table_name [其他子句];
  ```

- `min`: 求最小值

  ```sql
  select min(列) from table_name [其他子句];
  ```

- `avg`： 求平均值

  ```sql
  select avg(列) from table_name [其他子句];
  ```

- `count`: 求数量

  ```sql
  select count(列) from table_name [其他子句];
  ```

## group by

`group by ` 是对数据进行分组，分组时，表中有相同值的分为一组。分组后可以进行聚合查询。

`group by`分组后的查询中，`select`的列不能出现除了`group by `分组条件以及聚合函数外的其他列。

```sql
select 列1, 列2, (聚合函数) from table_name group by 列1, 列2;
```

## having

`having`是对`group by`分组后的结果集进行筛选。

```sql
select 列1, 列2, (聚合函数) from table_name group by 列1, 列2 having 分组后条件;
```

## on和join

在MySQL中，on和join函数都是用于连接两个或多个表的方法。其中，on是用于指定连接条件，而join则是用于指定连接方式。

on通常用于指定连接条件，例如：

```mysql
SELECT * FROM table1 JOIN table2 ON table1.id = table2.id;   
```

这将返回两个表中具有相同id的所有行。

而join则通常用于指定连接方式，例如：

```mysql
SELECT * FROM table1 JOIN table2 ON table1.id = table2.id INNER JOIN table3 ON table1.id = table3.id;   
```

这将返回所有三个表中具有相同id的行。

## 综合查询

```sql
SELECT DISTINCT emp.deptno FROM emp JOIN dept ON emp.deptno = dept.deptno WHERE bridate >= '2000-01-01' GROUP BY emp.deptno HAVING count(*) >= 2 ORDER BY count(*) DESC  LIMIT 0, 5;
```

> 书写顺序是以上。
>
> `SQL`语句的执行顺序
>
> from --> join --> on --> where --> group by --> having -->  select --> distinct-- > order by--> limit

[sql语句定义和执行顺序]