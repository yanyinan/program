# `Mysql`数据库用户操作

## 1.1、`user`权限表

`MySQL`在安装时会自动创建一个名为`MySQL`的数据库，`MySQL`数据库中存储的都是`MySQL`的权限信息，用户登录之后，`MySQL`会根据这些权限表的内容为每一个用户赋予相应的权限。

`user`表是`MySQL`中最重要的一个权限表，用来记录允许链接到服务器的账号信息

> 在`user`表中启用的所有权限都是全局级的，适用于所有数据库。

## 1.2查看当前登录用户

```shell
select user() [from dual]; # 查看当前登录的用户
```

dual 虚拟表，为了让select语句完整

### 查询用户信息

```shell
select user,host from mysql.user;
```

## 1.3创建用户

### 1、使用`create`语句

```sql
create user '用户名'@'主机名' identified by 'password'
```

举例：

```sql
create user ‘nz’ identified by ‘123456’ # hzm：用户账号，123456：密码
create user ‘nz’@’%’ identified by ‘123456’ #所有ip都可用账号
create user ‘nz’@’localhost’ identified by ‘123456’ #本地可用账号
create user ‘nz’@’192.168.12.1’ identified by ‘123456’ #具体哪个IP可以使用账号
create user ‘nz’@’192.168.12.%’ identified by ‘123456’ #具体哪个网段可以使用账号
```

### 2、在`mysql.user`中添加用户

使用`insert`语句(前提是当前用户有该表的`insert`权限)

```sql
insert into mysql.user
(host,user,authentication_string,ssl_cipher,x508_issuer,x509_subject)
values
('hostname','username',password('password'),'','','');
```

>`(host,user,authentication_string,ssl_cipher,x508_issuer,x509_subject)`在`user`表中不为空且没有默认值。
>
>在输入`password`的时候必须使用`password()`函数进行密码加密成数据库中加密保存密码的格式，以防验证登录时发生乱码，无法登录。
>
>用户创建成功后，不能直接使用创建的用户，会产生报错。需使用`falsh`命令刷新权限表，即时生效，然后重新登录数据库。

## 1.4修改用户

### 1、修改用户名

使用`rename`语句

```sql
rename user ‘nz’ to ‘hzm1’ # hzm：原用户； hzm1：新用户
```

### 2、修改密码

#### 1、使用`set password`语句

##### 修改普通用户密码

> set password for '用户名'@'主机名' = '新密码';
>
> -- 注意：需要在登陆`MySQL`的情况下操作。

```sql
set password for User@host = new_password;
```

##### 修改管理员密码

> `mysqladmin -uroot -p password` 新密码 
>
> --`mysqladmin`是`MySQL`管理工具的名称。它用于管理`MySQL`服务器和执行各种任务，例如备份、恢复、维护等
>
> -- 新密码不需要加上引号
>
> -- 注意：需要在未登陆`MySQL`的情况下操作。

例子：

```sql
mysqladmin ‐uroot ‐p password 123456
输入老密码
```

#### 2、使用`update`语句

```sql
update
mysql.user
set
authentication_string = SHA1('new_password')
where = username and host = hostname;
```

#### 3、使用`alter user`语句

```sql
alter user 用户名 identified by '密码'

alter user 用户名 identified by '密码' password expirenever; # 修改密码之后不需要重新登录
```

## 1.5删除用户

### 1、使用`drop user`语句

```sql
drop user ‘nz’；
```

### 2、使用`delete`语句

```sql
delete from
mysql.user
where
host = 'hostname'
and User = 'username';
```

## 1.6查看用户权限

### 1、通过查看`mysql.user`表查看

```sql
select * from mysql.user;
```

### 2、使用`show grants`语句查询用户的权限

```sql
show grants for 'username'@'hostname';
```

## 1.7用户授权

> 在用户拥有`grant`权限的用户才能执行`grant`语句。

用户创建之后，没什么权限,需要给用户授权

### 语法：

```sql
GRANT 权限1, 权限2... ON 数据库名.表名 TO '用户名'@'主机名';
```

- `GRANT` 授权关键字
- 授予用户的权限，如`SELECT`，`INSERT`，`UPDATE`等。如果要授予所有的权限则使用`ALL`
- `数据库名.表名`：该用户可以操作哪个数据库的哪些表。如果要授予该用户对所有数据库和表的相应操作权限则可用*表示，如`*.*`
- `'用户名'@'主机名'`: 给哪个用户授权

### 基本语法使用

#### grant 权限 on 数据库.表 to ‘用户’@’IP地址’

```shell
grant select on myDB to ‘hzm’@’%’;
```

#### #授予用户`hzm `对于整个数据库`myDB`的查询(select)权限

```shell
grant select on myDB.myTable to ‘hzm’@’%’;
```

#### #授予用户`hzm` 对于整个数据库`myDB`下的表`(mytable)`的查询`(select)`权限

```shell
grant select,insert on . to ‘hzm’ @’%’;
```

#### #授予用户`hzm`对于所有数据库的查询，新增权限

```shell
grant all privileges on . to ‘hzm’@’%’;
```

#### \# 任意`ip`可以访问 

```shell
GRANT ALL PRIVILEGES ON *.* TO '用户名'@'%'; 

update mysql.user set host='%' where user='txsy;
```

#### #授予用户`hzm` 对于所有数据库的所有权限，除创建用户权限外

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

### 语法

```sql
REVOKE 权限1, 权限2... ON 数据库.表名 FROM '用户名'@'主机名';
```

### 例子：

撤销`user1`用户对test操作的权限

```sql
REVOKE ALL ON test.* FROM 'user1'@'localhost';
```

