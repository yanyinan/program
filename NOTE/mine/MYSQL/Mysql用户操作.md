# Mysql数据库用户操作

## 1.1创建用户



```shell
create user ‘nz’ identified by ‘123456’ # hzm：用户账号，123456：密码
create user ‘nz’@’%’ identified by ‘123456’ #所有ip都可用账号
create user ‘nz’@’localhost’ identified by ‘123456’ #本地可用账号
create user ‘nz’@’192.168.12.1’ identified by ‘123456’ #具体哪个IP可以使用账号
create user ‘nz’@’192.168.12.%’ identified by ‘123456’ #具体哪个网段可以使用账号
```

## 1.2修改密码

```shell
alter user 用户名 identified by '密码' password expirenever; # 修改密码之后不需要重新登录
```

### 修改管理员密码

> mysqladmin -uroot -p password 新密码 
>
> -- 新密码不需要加上引号
>
> -- 注意：需要在未登陆MySQL的情况下操作。

例子：

```mysql
mysqladmin ‐uroot ‐p password 123456
输入老密码
```

### 修改普通用户密码

> set password for '用户名'@'主机名' = '新密码';
>
> -- 注意：需要在登陆MySQL的情况下操作。

```mysql
set password for 'user1'@'localhost' = '666666';
```

## 1.3查看当前登录用户

```shell
select user() [from dual]; # 查看当前登录的用户
```

dual 虚拟表，为了让select语句完整

### 查询用户信息

```shell
select user,host from mysql.user;
```

## 1.4删除用户

```shell
drop user ‘nz’；
```

## 1.6修改用户

### 1)修改用户名

```shell
rename user ‘nz’ to ‘hzm1’ # hzm：原用户； hzm1：新用户
```

### 2)修改密码

```shell
set password for ‘hzm’ =password(‘12321’) #hzm：用户；12321：新密码
```

## 1.7授权

用户创建之后，没什么权限,需要给用户授权

> GRANT 权限1, 权限2... ON 数据库名.表名 TO '用户名'@'主机名';

- `GRANT` 授权关键字
- 授予用户的权限，如`SELECT`，`INSERT`，`UPDATE`等。如果要授予所有的权限则使用`ALL`
- `数据库名.表名`：该用户可以操作哪个数据库的哪些表。如果要授予该用户对所有数据库和表的相应操作权限则可用*表示，如`*.*`
- `'用户名'@'主机名'`: 给哪个用户授权

### 基本语法

#### grant 权限 on 数据库.表 to ‘用户’@’IP地址’

```shell
grant select on myDB to ‘hzm’@’%’;
```

#### #授予用户hzm 对于整个数据库myDB的查询(select)权限

```shell
grant select on myDB.myTable to ‘hzm’@’%’;
```

#### #授予用户hzm 对于整个数据库myDB下的表(mytable)的查询(select)权限

```shell
grant select,insert on . to ‘hzm’ @’%’;
```

#### #授予用户hzm对于所有数据库的查询，新增权限

```shell
grant all privileges on . to ‘hzm’@’%’;
```

#### \# 任意ip可以访问 

```shell
GRANT ALL PRIVILEGES ON *.* TO '用户名'@'%'; 

update mysql.user set host='%' where user='txsy;
```



#### #授予用户hzm 对于所有数据库的所有权限，除创建用户权限外

> 注：
> 1）创建与授权联合使用
>
> ```shell
> grant all privileges on . to “hzm”@”%” identified by ‘123456’ with grant option;
> ```
>
> 2）每次授权完，刷新授权
>
> ```shell
> flush privileges;
> ```

## 1.8撤销授权

> REVOKE 权限1, 权限2... ON 数据库.表名 FROM '用户名'@'主机名';

例子：

撤销user1用户对test操作的权限

```sql
REVOKE ALL ON test.* FROM 'user1'@'localhost';
```

## 1.9查看权限

> SHOW GRANTS FOR '用户名'@'主机名'; 

例子：

查看`user1`用户的权限

```mysql
SHOW GRANTS FOR 'user1'@'localhost';
```
