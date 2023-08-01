

## 基本查询

```sql
-- 查询所有数据
SELECT *FROM dept;
-- 查询某列的数据
SELECT deptname FROM dept;
-- 根据条件查询*
SELECT deptno FROM dept WHERE deptname='销售部';
```

当 sql 语句中的条件有多条时，可以将多个条件连接起来。他们之间的关系有一下几种： and a and b : 表示 需要同时满足 a 条件 和 b 条件

or a or b : 表示 满足 a 条件 或 b 条件都可以

in in(a, ... ,b) ： 表示在 a 及 b 这些值中都可以

like :模糊查询, % 表示任意个字符 _ 表示一个字符



### 去除重复值distinct

 在`select`语句中，可以使用`distinct`关键字对查询的结果集进行去重。

```sql
select distinct 列1, ... , 列n  from table_name [其他子句];
```

> 去重必须结果集中每个列的值都相同。

### 使用算数表达式

```sql
SELECT dept_num + 10 FROM dept;
```

## where条件连接

当`sql`语句中的条件有多条时，可以将多个条件连接起来。他们之间的关系有一下几种：

**`and`**

   `a and b`: 表示 需要同时满足 a 条件 和 b 条件

**`or`**

​	`a or b`: 表示 满足 a 条件 或 b 条件都可以

```
in
```

​	`in(a, ... ,b)`： 表示在 a 及 b 这些值中都可以

```
like
```

​    模糊查询,  % 表示任意个字符  _ 表示一个字符

### BETWEEN .. AND

`between 60 and 200 ==> >=60 and <= 100`

### in

用于没有规律的范围查询。相当于多个`or`的集合。

### null查询

` is null`

### order by

`order by`用于对结果进行排序显示，可以使用`ASC` / `DESC`两种方式进行排序，可以有多个排序条件

- `ASC`：表示升序排序，如果不写即为此排序方式
- `DESC`：表示降序排序

```
select [distinct] 列1, ... , 列n from table_name [其他子句] order by 排序列1 [DESC], 排序列2 [DESC];
```

### 分页查询limit子句

```
select * from emp limit 0,2;
```

- 第一个参数0是表示从第几条开始查询 (这里的 0 是可以省略不写的)；
- de第二个参数 表示查询出几条数据
- 后面不够的，有多少写多少；

```
select * from emp order by empNo limit 5;
select * from emp limit 5,5;

-- 
select * from table_name  limit (页码 - 1) * 每页数量, 每页数量;
```

### 聚合函数查询

Mysql中内置了 5 种聚合函数，分别是：`SUM` 、`max`、`min`、`avg`、`count`。

- `sum`： 求和

  ```
  select sum(列) from table_name [其他子句];
  ```

- `max`: 求最大值

  ```
  select max(列) from table_name [其他子句];
  ```

- `min`: 求最小值

  ```
  select min(列) from table_name [其他子句];
  ```

- `avg`： 求平均值

  ```
  select avg(列) from table_name [其他子句];
  ```

- `count`: 求数量

  ```
  select count(列) from table_name [其他子句];
  ```

### group by

`group by` 是对数据进行分组，分组时，表中有相同值的分为一组。分组后可以进行聚合查询。

`group by`分组后的查询中，`select`的列不能出现除了`group by`分组条件以及聚合函数外的其他列。

```
select 列1, 列2, (聚合函数) from table_name group by 列1, 列2;
```

### having

`having`是对`group by`分组后的结果集进行筛选。

```
select 列1, 列2, (聚合函数) from table_name group by 列1, 列2 having 分组后条件;
```

## 多表查询

### 内连接

在MySQL中，on和join函数都是用于连接两个或多个表的方法。其中，on是用于指定连接条件，而join则是用于指定连接方式。

on通常用于指定连接条件，例如：

```
SELECT * FROM table1 JOIN table2 ON table1.id = table2.id;   
```

这将返回两个表中具有相同id的所有行。

而join则通常用于指定连接方式，例如：

```
SELECT * FROM table1 JOIN table2 ON table1.id = table2.id INNER JOIN table3 ON table1.id = table3.id;   
```

这将返回所有三个表中具有相同id的行。

### 外连接

```sql
SELECT * FROM table1  left JOIN table2 ON table1.id = table2.id INNER JOIN table3 ON table1.id = table3.id; 

SELECT * FROM table1  left JOIN table2 ON table1.id = table2.id INNER JOIN table3 ON table1.id = table3.id; 
```

## 子查询

### 单行子查询

```sql
select * from emp e
where e.dept_no = (
	select d.dept_no from dept d
	where d.d_name = "软件部");
```

### 多行子查询

多行子查询需要用到多行记录的操作符，例如`in`,`any`,`all`等

```sql
select * from emp e
where e.dept_no in (
	select d.dept_no from dept d
	where d.d_name = "软件部");
```

### 多列子查询

```sql
select * from emp e
where (e.dept_no,e.dept_name) = (
	select d.dept_no,d.d_name from dept d
	where d.d_name = "软件部");
```

