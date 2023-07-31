# 练习2答案

## 构建数据库

### 数据库

![image-20230723115200075](https://s2.loli.net/2023/07/23/xWHkTcmedP136OJ.png)

### 数据表

> answer开头表为对应题号答案形成的数据表

![image-20230723115355714](https://s2.loli.net/2023/07/23/uaFfjI93CExYDNm.png)

### 表结构

![image-20230723115634205](https://s2.loli.net/2023/07/23/6k9egAf2huQjvHp.png)

![image-20230723115652298](https://s2.loli.net/2023/07/23/KeQjUPn8ErC6wmy.png)

![image-20230723115741230](https://s2.loli.net/2023/07/23/86CD1pQx9bWZkvn.png)

### 表数据

![image-20230723115536915](https://s2.loli.net/2023/07/23/x51aFvUbBk69WdX.png)

![image-20230723115820959](https://s2.loli.net/2023/07/23/a5S8QN4ZFDAdTW6.png)

![image-20230723115845876](https://s2.loli.net/2023/07/23/iljSoRUKt7D34Ws.png)

## 答案：

### 1、修改`emp`表中`sal`字段为`salary`

#### `SQL`语句

```sql
ALTER TABLE emp change sal salary double
```

####  结果：

![image-20230723120655880](https://s2.loli.net/2023/07/23/dIotcJ1Wg4Cihel.png)

### 2、查找年薪在20000到30000之间的所有员工信息并按照 工资降序显示 

#### `SQL`语句

```sql
select * from emp where sal*12 between 20000 and 30000 order by sal desc;
```

####  结果

![image-20230723121340698](https://s2.loli.net/2023/07/23/ONPs8U953qcweh7.png)

### 3、查找员工姓名中包含'A'的所有员工信息 

#### `SQL`语句

```sql
select * from emp where ENAME like '%A%';
```

####  结果

![image-20230723121651364](https://s2.loli.net/2023/07/23/OE8Wx59IlbK2f3B.png)

### 4、查找所有员工姓名中包含'A'及'E'的员工信息

#### `SQL`语句

```sql
select * from emp where ENAME like '%A%' and '%E%';
```

####  结果

![image-20230723122052394](https://s2.loli.net/2023/07/23/eQI3mSuX2r6gRdF.png)

### 5、查找所有的职位为`SALESMAN`的员工信息 

#### `SQL`语句

```sql
select * from emp where JOB = 'SALESMAN' ;
```

####  结果

![image-20230723122202390](https://s2.loli.net/2023/07/23/VUfQI8qLJtO6jzK.png)

### 6、将工资低于2000的员工工资涨薪200 

#### `SQL`语句

```sql
update emp set sal = sal + 200;
```

####  结果

![image-20230723122418868](https://s2.loli.net/2023/07/23/GkcZYeqtpyxg4Ad.png)

### 7、查询没有上级领导的所有员工信息 

#### `SQL`语句

```sql
select * from emp where MGR is null;
```

####  结果

![image-20230723122713011](https://s2.loli.net/2023/07/23/EQziBrKHDIml4gb.png)

### 8、查询没有奖金的所有员工信息

#### `SQL`语句

```sql
select * from emp where COMM is NULL;
```

####  结果

![image-20230723122830495](https://s2.loli.net/2023/07/23/6maOuVsZd2oC4lp.png)

### 9、将部门表中的40部门的地址修改成`'xian'` 

#### `SQL`语句

```sql
update dept set LOC = 'xian' where DEPTNO = 40;
```

####  结果

![image-20230723122907158](https://s2.loli.net/2023/07/23/qrapiOnEAhje41L.png)

### 10、假设李华的工资是2000，请查询出他的工资等级

#### `SQL`语句

```sql
select GRADE from salgrade LOSAL >= 2000 and HISAL <= 2000;
```

####  结果

![image-20230723123005955](https://s2.loli.net/2023/07/23/beCaWrVLh2FfASl.png)

### 11、将MILLER的入职日期修改为1982年2月23日

#### `SQL`语句

```sql
UPDATE emp SET HIREDATE = '1982-02-23' WHERE ENAME = 'MILLER';
```

####  结果

![image-20230723123059291](https://s2.loli.net/2023/07/23/aDYxFVwk6RBJopW.png)