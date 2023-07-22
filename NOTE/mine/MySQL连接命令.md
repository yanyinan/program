# MySQL连接命令

一、MySQL 连接本地数据库，用户名为“root”，密码“123”（注意：“-p”和“123” 之间不能有空格）

```shell
C:>mysql -h localhost -u root -p123
```

二、MySQL 连接远程数据库（xxx.xxx.0.xxx），端口“3306”，用户名为“root”，密码“123”

```shell
C:>mysql -h xxx.xxx.0.xxx -P 3306 -u root -p123
```

三、MySQL 连接本地数据库，用户名为“root”，隐藏密码

```shell
C:>mysql -h localhost -u root -p

Enter password:
```

四、MySQL 连接本地数据库，用户名为“root”，指定所连接的数据库为“test”

```shell
C:>mysql -h localhost -u root -p123 -D test

mysql>select database();
```

查看版本 ：

```shell
mysql>status;
```

