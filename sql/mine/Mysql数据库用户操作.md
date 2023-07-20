# Mysql数据库用户操作

## 1.1创建用户

```shell
create user ‘nz’ identified by ‘123456’ # hzm：用户账号，123456：密码
create user ‘nz’@’%’ identified by ‘123456’ #所有ip都可用账号
create user ‘nz’@’localhost’ identified by ‘123456’ #本地可用账号
create user ‘nz’@’192.168.12.1’ identified by ‘123456’ #具体哪个IP可以使用账号
create user ‘nz’@’192.168.12.%’ identified by ‘123456’ #具体哪个网段可以使用账号
```

## 1.2删除用户

```shell
drop user ‘nz’
```

## 1.3修改用户

### 1)修改用户名

```shell
rename user ‘nz’ to ‘hzm1’ # hzm：原用户； hzm1：新用户
```

### 2)修改密码

```shell
set password for ‘hzm’ =password(‘12321’) #hzm：用户；12321：新密码
```

## 1.4授权

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

