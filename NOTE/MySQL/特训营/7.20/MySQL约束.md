# 约束

> 查看约束 `show create table table_name`

## 主键约束（PK）

主键约束最显著的特征是主键列中的值是不允许重复(唯一)的，通过主键约束可强制表 的实体完整性。当创建或更改表时可通过定义 primary key约束来创建主键。

一个表只 能有一个primary key约束，且primary key约束中的列不能接受NULL值。 

`alter table tab_name add constraint pk_name primary key (deptno);`

```sql
-- 创建表时
CREATE TABLE `table_name` (
`id` int PRIMARY KEY,-- 设置主键
`name` varchar(20)
);
CREATE TABLE `table_name` (
`id` int NOT NULL,
`name` varchar(20) ,
PRIMARY KEY (`id`) -- 设置主键
);
CREATE TABLE `table_name` (
`id` int NOT NULL,
`name` varchar(20) ,
constraint pk primary key(id) -- 设置主键
);
-- 设置主键是deptno
ALTER TABLE emp MODIFY empno INT PRIMARY KEY; -- 修改列的属性来添加主键约束
ALTER TABLE 表名称 ADD PRIMARY KEY(id);
ALTER TABLE dept ADD CONSTRAINT pk_name PRIMARY KEY(deptno);
-- 删除主键
ALTER TABLE 表名称 DROP PRIMARY KEY; -- 【推荐】
```

## 子增长列

自增长列是数值类型( INT , FLOAT , DOUBLE 等)的,其值是由数据库自动维护的，是永远都不 会重复的，因此自增长是最适合作为主键列的。

在创建表时，通过` auto_increment` 关键 字来标识自增长列，在`MySQL`数据库中自增长列可以是主键列，也可以是唯一列（有唯一 约束的列）。

 特点：

1. 标识列必须和一个Key搭配（Key指主键、唯一、外键....） 

2.  一个表最多有一个标识列 3. 标识列的类型只能是数值型

3. 标识列可以通过` SET auto_increment_increment = 3; , SET @@auto_increment_increme nt = 3;` 设置步长（全局），可以通过插入行时手动插入标识列值设置起始值。

   >如果设置步长会从 1 + 步长 依次递增。
   >如果表中已有数据，会按照 1 + 步长进行计算，如果这个 值 已有则再加直到没有

```sql
CREATE TABLE emp(
empNo INT PRIMARY KEY AUTO_INCREMENT,
job VARCHAR(10),
mgr INT,
sal DOUBLE,
comm DOUBLE,
deptno INT
)CHARACTER SET utf8;
-- 设置自增长列的初始值
CREATE TABLE temp(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(2)
) AUTO_INCREMENT=10;
-- 设置自增长列的初始值
ALTER TABLE emp AUTO_INCREMENT = 10;
alter table 表名称 modify column id int auto_increment;
-- 删除自增长列
ALTER TABLE 表名称 MODIFY COLUMN id INT;
```

## 唯一约束

对于非主键列中的值也要求唯一性时，就需要唯一约束

```sql
- 创建表时
CREATE TABLE `table_name` (
`id` int NOT NULL,
`name` varchar(20) UNIQUE, # 唯一约束
);
CREATE TABLE `table_name` (
id` int NOT NULL,
`name` varchar(20),
constraint uq_name unique(name), #唯一约束
);
alter table 表名称 ADD unique(列名称);
ALTER TABLE dept ADD CONSTRAINT uq_name UNIQUE(deptname);
-- 删除唯一约束
ALTER TABLE tb_name DROP CONSTRAINT constraint_name;
[alter table 表名称 drop index 设置唯一时的名称;] -- 删索引
```

唯一约束要求值不能重复 可以存在多个空值( NULL )的数据 一张可以有多个唯一约束列吗 约束默认的名称为其列名 唯一约束创建后会自动创建一个唯一索引

## 默认约束

为列中的值设置默认值，default ....,如果已经定了值，默认值就无效

```sql
- 创建表时
CREATE TABLE `table_name` (
`id` int DEFAULT NULL,# 默认约束
`name` varchar(20) unique,
);
alter table 表名称 modify column 列名 列类型 default 默认值;
-- 删除
alter table 表名称 modify column 列名 列类型; -- 将默认值改为 NULL
ALTER TABLE tb_name ALTER col_name DROP DEFAULT; -- 删除了默认值，新增时必须有值
```

创建表时，不写默认值都默认 NULL （在无非空约束的情况下） 默认约束能和主键约束可以同时存在 默认约束不能和 AUTO_INCREMENT 同时使用

## 非空约束

NOT NULL ：非空，用于保证该字段的值不能为空。例如学生表的学生姓名及学号等等

```sql
- 创建表时
CREATE TABLE `table_name` (
`id` int NOT NULL, # 非空约束
`name` varchar(20),
);
alter table 表名称 modify column 列名 列类型 not null;
-- 删除
alter table 表名称 modify column 列名 列类型 [null];
```

## 外键约束

A表中列的值来自于另外一张表B的主键或唯一键的列称为 外键`FK`，将被引用值得表称为 主表或父表，将引用值得表称为从表或子表。 例如:` emp `表中有 `deptno `列，值来自于` dept `表的 主键 `deptno` 。 `dept` 是主表，` emp `是从表。

```sql
- 创建表时
CREATE TABLE `dept`(
dept_no INT PRIMARY KEY,
dept_name VARCHAR(20),
)
CREATE TABLE `emp` (
`id` int NOT NULL,
`name` varchar(20),
`deptno` int,
CONSTRAINT fk_dept_no FOREIGN KEY(deptno) REFERENCES dept(dept_no)
);
alter table userinfo add constraint foreign key fk_dept_no (dept_no) REFERENCES
dept(deptno);
-- 删除
ALTER TABLE tb_name DROP CONSTRAINT constraint_name;
alter table 表名称 drop foreign key 设置外键时的名称;
-- 删除外键约束创建的索引
ALTER TABLE tb_name DROP INDEX 设置外键时的名称;
```

dept 是主表，` userinfo` 是从表 

创建外键时，会在引用表(从表)的字段上建立索引 

- ​	这个字段上有则不创建

在 `userinfo `表中添加或修改时， dept_no 列的值必须是 dept 表中 `deptno `字段中的 存在值或者 NULL 删除从表数据可以直接删除 

删除主表数据时，会先检查被删除数据在从表中有没有对此数据的关联（引用），如果 有不能直接删除。

 如果想要解除此限制需要先禁用外键约束【不推荐】 我们可以在创建约束时，设置级联操作

```sql
on delete CASCADE/ on update CASCADE 级联删除 / 级联更新 

ON DELETE SET NULL / ON UPDATE SET NULL
```

## 检查约束

check 检查约束，在数据添加或修改时保证数据的有效性。符合表达式的才会正确执行。

```sql
CREATE TABLE users (
... ,
age INT CHECK (age >= 18)
);
CREATE TABLE users (
... ,
CONSTRAINT chk_xxx CHECK(expr)
);
ALTER TABLE emp2 MODIFY sal DOUBLE CHECK(sal >= 2000);
ALTER TABLE tb_name ADD CONSTRAINT chk_xx check(id > 10);
-- 删除约束
ALTER TABLE tb_name DROP CONSTRAINT tb_chk_num;

```

