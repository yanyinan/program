# 练习2答案

## 构建数据库

### 数据库



### 数据表

> answer开头表为对应题号答案形成的数据表



### 表结构





### 表数据



## 答案：

### 1、编写脚本，创建mis数据库，创建`dept`，创建`employee`表

#### `SQL`语句

```sql
ALTER TABLE emp change sal salary double
```

####  结果：



### 2、添加约束：`dept`表的 `dept_name` 列的值是唯一的 ;`employee`表的`dept_id` 列引用`dept`表的 `dept_id` 列 ,给`employee`表的`gender`字段添加默认约束，默认为'男'

#### `SQL`语句

```sql
select * from emp where sal*12 between 20000 and 30000 order by sal desc;
```

####  结果



### 3、根据表2和表4，向`dept`表和`employee`表中添加测试数据

#### `SQL`语句

```sql
select * from emp where ENAME like '%A%';
```

####  结果



### 4、查询工资大于`2900`元的员工信息-

#### `SQL`语句

```sql
select * from emp where ENAME like '%A%' and '%E%';
```

####  结果



### 5、将`孙二娘`的出生日期更改为`1985-6-8`

#### `SQL`语句

```sql
select * from emp where JOB = 'SALESMAN' ;
```

####  结果



### 6、删除员工`扈三娘`

#### `SQL`语句

```sql
update emp set sal = sal + 200;
```

####  结果



### 7、查找工资最低的两个员工

#### `SQL`语句

```sql
select * from emp where MGR is null;
```

####  结果



### 8、按照工资降序排序员工信息

#### `SQL`语句

```sql
select * from emp where COMM is NULL;
```

####  结果



### 9、删除测试部门及其员工删除测试部门及其员工

#### `SQL`语句

```sql
update dept set LOC = 'xian' where DEPTNO = 40;
```

####  结果



### 10、统计男员工和女员工的人数

#### `SQL`语句

```sql
select GRADE from salgrade LOSAL >= 2000 and HISAL <= 2000;
```

####  结果



### 11、计算最高工资和最低工资的差额

#### `SQL`语句

```sql
UPDATE emp SET HIREDATE = '1982-02-23' WHERE ENAME = 'MILLER';
```

####  结果

### 12、统计部门平均工资，及部门名称

#### `SQL`语句

```sql
UPDATE emp SET HIREDATE = '1982-02-23' WHERE ENAME = 'MILLER';
```

####  结果

### 13、查询员工信息，显示员工姓名，部门名称，薪水

#### `SQL`语句

```sql
UPDATE emp SET HIREDATE = '1982-02-23' WHERE ENAME = 'MILLER';
```

####  结果

