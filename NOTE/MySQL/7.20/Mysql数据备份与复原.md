# 数据备份和还原

## 命令行备份

### 备份结构

1.备份表结构

```shell
mysqldump -u root -p -d dbname table1 table2 ... > a.sql
```

2.备份数据库的所有表结构

```shell
mysqldump -u root -p -d dbname > b.sql
```

3.备份多个数据库的所有表结构

```shell
mysqldump -u root -p -d --databases db1 db2... > c.sql
```

4.备份所有数据库的表结构

```shell
mysqldump -u root -p -d --all-databases > d.sql
```

### 备份数据和结构

(相当于在备份结构的语法上去掉-d选项)

1.备份表结构和数据

```shell
mysqldump -u root -p dbname table1 table2 ... > a.sql
```

2.备份数据库的所有表结构和数据

```shell
mysqldump -u root -p dbname  > b.sql
```

3.备份多个数据库的表结构和数据

```shell
mysqldump -u root -p --databases db1 db2  > c.sql
```

4.备份所有数据库的表结构和数据

```shell
mysqldump -u root -p --all-databases > d.sql
```

* mysqldump -h 127.0.0.1 -u root -p root db_name>path;
  * 使用mysqldump 命令备份数据库
  * -h指定数据库所在的服务器的ip地址
  * -u指定登录数据库的密码
  * db_name是要备份的数据库的名称
  * 使用输出目标操作符>,指定输出的文件具体路径c:/back.sql

### 备份表数据

```sql
mysql -u root -p -e "selec 语句" dbname > 目标文件名

select * from xxx into outfile ‘/tmp/stud.txt' ; 
```



## 命令行还原

### 还原表结构和数据

```shell
mysql -u root -p [dbname] < 目标文件
mysql -h127.0.0.1 -uroot -proot db_name<back.sql

load data infile '/tmp/stud.txt' into table students;
source /backup/all_db_2013-09-08.sql
```

