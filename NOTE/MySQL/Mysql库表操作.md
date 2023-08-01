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

-  **DCL:** 数据控制语言，用来创建数据库用户，控制数据库的访问权限(见[Mysql用户操作.md](http://39.105.197.178:8090/archives/mysql用户操作md))
-  **DDL**: 数据定义语句,数据定义语言，用来定义数据库对象（数 据库，表，字段）。 如： CREATE / ALTER / DROP
-  **DML:** 数据操纵语句,用来对数据表中的数据进 行增删改 。如：INSERT / UPDATE / DELETE 
-  **DQL**: 数据查询语句,用来创建数据库用户，控制数据库的访问权限。如：SELECT 
-  **TCL**: 数据控制语句,GRANT(授权)命令，REMOKE(撤销)命令(见[Mysql用户操作.md](http://39.105.197.178:8090/archives/mysql用户操作md))
> 所有的SQL都应该以英文状态下的分号结束`;`

# 对数据库操作

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

## 使用数据库：

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


## 删除数据库

语法结构

```sql
drop database db_name;
```

# 对数据表创建删除

## 创建数据表

* 创建数据表的语法结构

  ```mysql
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
~~~

##     创建和某表结构一样的表

```mysql
-- 创建和dept结构一样的表
CREATEABLE d LIKE dep
-- 创建表
CREATE TABLE t AS select * from d
```

## 查看表结构

### 以`SQL`的形式展示表结构

```sql
show create table t_name;
```

### 以表格的形式展示表结构

```sql
desc t_name;
```

## 删除表

```mysql
DROP TABLE table_name
```

## 修改表结构

### 添加列

```mysql
ALTER TABLE d ADD id INT;
```

### 修改列属性

```mysql
ALTER TABLE d MODIFY id VARCHAR(20);
```

### 修改列名

```mysql
ALTER TABLE d CHANGE id ss VARCHAR(20);	
```
> **MODIFY 和 CHANGE 关键字用于修改表的列名、数据类型以及列的约束。区别在于：**

> MODIFY 不会修改列名， CHANGE 关键字允许同时修改列名。
>
> 使用 CHANGE 时，必须指定原始列名、新列名以及新的数据类型和列约束（如NOT NULL、DEFAULT等）
> ALTER TABLE tb_name CHANGE old_column_name new_column_name new_data_type new_constraints;

### 删除列

```mysql
ALTER TABLE d DROP ss;
```

## 重命名表
1、rename语句
```mysql
RENAME TABLE d TO dd;
```
2、alter table 语句
```mysql
alter table old_table_name rename [as/to] new_table_name;
```

