# git使用方法

```
git init 初始化，创建本地仓库
git add . 添加到本地仓库
git commit -m “注释” 添加注释
git remote add origin 仓库地址 连接远程仓库
git pull --rebase origin master 同步仓库内容
git push -u origin master 上传到远程仓库
```



## 1、配置信息（第一次使用要进行配置）

```
git config --global user.name "name"

git config --global user.email "email"

content_copy
```



## 2、生成密钥(SSH公钥)

继续输入下面的命令，email就是上面的邮箱

```
ssh-keygen -t rsa -C “email”
```

可以使用下面的命令进行查看密钥：

```
cat ~/.ssh/id_rsa.pub
```

## 3、使用方法

### 1、初始化，创建本地仓库

```
git init
```

会生成一个.git文件夹。

### 2、将本地文件添加到本地仓库

```
git add .
```

添加该文件夹下的所有文件到本地仓库，注意add和. 之间有空格。".“表示添加所有文件，如果想要添加个别文件可以把”."替换为相应文件名。

### 3、添加注释

```
git commit -m "注释"
```

git commit -m作用为提交暂存区的文件（也就是上一步添加的文件），后面双引号内可以填写关于提交的注释信息。

## 4、添加远程仓库（与远程仓库建立连接）

复制仓库地址

```
git remote add origin https://gitee.com/ai-case-study-group/lesson-plan
```

建立本地仓库与远程仓库的关联，指令后面的地址为仓库的地址。

## 5、同步仓库内容

```
git pull --rebase origin master
git pull origin master
```

命令，将远程仓库的内容合并到本地仓库。如果远程仓库为空可以跳过这一步，如果远程仓库不为空，则必须进行这一步，否则会报错。
这时候，本地仓库和远程仓库的内容是一样的



## 6、上传文件

第一次上传需要输入git push -u origin master命令，将本地仓库的文件推送到已经建立关联的远程仓库master分支中。

```
content_copy
```

再次上传不需要
这时，文件已经上传到仓库里

