# CRUD操作

- 对数据表中的数据操作通常有添加(Create)、查询(Retrieve)、修改(Update)、删除(Delete)、简称为CRUD。

### 添加数据



**INSERT INTO table_name VALUES(值列表)** 

**INSERT INTO table_name (列列表) VALUES(值列表)**

```
-- 不推荐使用
INSERT INTO dept VALUE(1,'研发部');
-- 2
INSERT INTO dept VALUES(2,'销售部');
INSERT INTO dept VALUES(3,'行政部'),(4,'技术部');
-- 3
INSERT INTO dept(deptno,deptname)VALUES(5,'安保部');
```

区别：

- value和values的区别，values可以同时插入多条数据用逗号隔开
- dept和dept(列名，列名。。。)区别，如果不写列表必须按照列表创建时的顺序每一列都要添加
- 有列名的按照列名排列顺序添加

### 查询数据

```
-- 查询所有数据
SELECT *FROM dept;
-- 查询某列的数据
SELECT deptname FROM dept;
-- 根据条件查询*
SELECT deptno FROM dept WHERE deptname='销售部';
```

### 修改数据

```
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

```
-- 删除数据 ,一定要加 where 条件
DELETE FROM dept WHERE deptno=5;
-- 全部删除c
DELETE FROM dept;
-- 清空/截断 所有数据(慎用)
TRUNCATE TABLE dept;
```

区别

- delete from dd;
- truncate table dd;
- delete 是清空表中的数据,`DML`
- truncate 是清空表数据（删除表后重新创建一个一样表），`DDL`

