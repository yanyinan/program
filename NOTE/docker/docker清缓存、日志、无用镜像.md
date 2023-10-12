# docker清缓存、日志、无用镜像

```shell
docker system df
```

 查看docker各类型文件占用情况

```shell
docker system df
```

该命令列出了 docker 使用磁盘的 4 种类型：

> Images: 所有镜像占用的空间，包括拉取的镜像、本地构建的镜像
>
> Containers: 运行中的容器所占用的空间（没运行就不占空间），其实就是每个容器读写层的空间
>
> Local Volumes: 本地数据卷的空间
>
> Build Cache: 镜像构建过程中，产生的缓存数据

`RECLAIMABL` 这个字段明确了该类型中可以清理的空间

## 查看每个image、container占用情况

```shell
docker system df -v
```

我们使用 docker 镜像创建容器时，docker会创建一些目录，如：

> `/var/lib/docker/containers/<容器ID> `目录，如果容器使用了默认的日志模式，那么该容器的日志会以 `JSON `形式保存在此目录下。
> `/var/lib/docker/overlay2` 目录，该目录包含容器的读写层，如果容器使用自己的文件系统保存了数据，那么这些数据就会写到此目录下。

### 1、清理容器日志

Containers 包含的我们容器自身的容量、产生的数据容量、产生的日志容量

\# 查看所有容器下日志的大小

```shell
find /var/lib/docker/containers/ -name *-json.log |xargs du -sh
```

\# 写个空文件到容器日志中

```shell
cat /dev/null > /var/lib/docker/containers/3c1452f817fad2296d1c105112faed89d01feaa4ee094e8622c959e072012f7a/3c1452f817fad2296d1c105112faed89d01feaa4ee094e8622c959e072012f7a-json.log
```

\# 将某个日志文件清零

```shell
truncate -s 0 /var/lib/docker/containers/3c1452f817fad2296d1c105112faed89d01feaa4ee094e8622c959e072012f7a/3c1452f817fad2296d1c105112faed89d01feaa4ee094e8622c959e072012f7a-json.log
```

这里可以看出我的其中一个容器的日志已经到14G

设置容器日志的最大容量，下面是nginx的设置的例子

```shell
nginx:
image: nginx:1.12.1
restart: always
logging:
driver: "json-file"
options:
max-size: "5g"
```



### 2、清理无用的image、volume、container

如果发现有些容器、数据卷是没有被使用的，此时可以通过下面命令清理 Docker 占用的空间

 清理所有没用的image、volume、container、 但是这个呢会把你暂时停止的容器、镜像也删除掉、当前命令可以用于清理磁盘，删除关闭的容器、无用的数据卷和网络，以及dangling镜像（即无tag的镜像）

```shell
docker system prune
```

\# 当前命令清理得更加彻底，可以将没有容器使用Docker镜像都删掉

```shell
docker system prune -a
```

当然也是有其他选择的：

\#删除所有关闭的容器：

```shell
docker ps -a | grep Exit | cut -d ' ' -f 1 | xargs docker rm
```

\#删除所有dangling镜像（即无tag的镜像）：

```shell
docker rmi $(docker images | grep "^<none>" | awk "{print $3}")
```

\#删除所有dangling数据卷（即无用的Volume）：

```shell
docker volume rm $(docker volume ls -qf dangling=true)
```



\#数据卷容器删除

```shell
docker rm -v 卷名
```

参考命令：

```shell
df -h查看磁盘使用情况
df -i 查看inode使用情况
du -sh *查看当前目录下各个文件及目录占用空间大小
df -h和du -sh显示的磁盘大小不一致原因及解决办法
df -hT显示132G空间全部占用，du -sh显示只占用**30G**docker system df
```

\# 查看docker各类型文件占用情况

```shell
docker system df
```

该命令列出了 docker 使用磁盘的 4 种类型：

```shell
Images: 所有镜像占用的空间，包括拉取的镜像、本地构建的镜像

Containers: 运行中的容器所占用的空间（没运行就不占空间），其实就是每个容器读写层的空间

Local Volumes: 本地数据卷的空间

Build Cache: 镜像构建过程中，产生的缓存数据

\# RECLAIMABL 这个字段明确了该类型中可以清理的空间
```

 

## 查看每个image、container占用情况

```bash
docker system df -v
```

我们使用 docker 镜像创建容器时，docker会创建一些目录，如：

/var/lib/docker/containers/<容器ID> 目录，如果容器使用了默认的日志模式，那么该容器的日志会以 JSON 形式保存在此目录下。
/var/lib/docker/overlay2 目录，该目录包含容器的读写层，如果容器使用自己的文件系统保存了数据，那么这些数据就会写到此目录下。

### 1、清理容器日志

Containers 包含的我们容器自身的容量、产生的数据容量、产生的日志容量

\# 查看所有容器下日志的大小

```bash
find /var/lib/docker/containers/ -name *-json.log |xargs du -sh
```

\# 写个空文件到容器日志中

```bash
cat /dev/null > /var/lib/docker/containers/3c1452f817fad2296d1c105112faed89d01feaa4ee094e8622c959e072012f7a/3c1452f817fad2296d1c105112faed89d01feaa4ee094e8622c959e072012f7a-json.log
```

\# 将某个日志文件清零🆑

```bash
truncate -s 0 /var/lib/docker/containers/3c1452f817fad2296d1c105112faed89d01feaa4ee094e8622c959e072012f7a/3c1452f817fad2296d1c105112faed89d01feaa4ee094e8622c959e072012f7a-json.log这里可以看出我的其中一个容器的日志已经到`14G`
```

设置容器日志的最大容量，下面是`nginx`的设置的例子

```bash
nginx:
image: nginx:1.12.1
restart: always
logging:
driver: "json-file"
options:
max-size: "5g"
```

### 2、清理无用的image、volume、container

如果发现有些容器、数据卷是没有被使用的，此时可以通过下面命令清理 Docker 占用的空间

 	清理所有没用的image、volume、container、但是这个呢会把你暂时停止的容器、镜像也删除掉、当前命令可以用于清理磁盘，删除关闭的容器、无用的数据卷和网络，以及dangling镜像（即无tag的镜像）

```bash
docker system prune
```

\# 当前命令清理得更加彻底，可以将没有容器使用Docker镜像都删掉

```bash
docker system prune -a
```

当然也是有其他选择的：

\#删除所有关闭的容器：

```bash
docker ps -a | grep Exit | cut -d ' ' -f 1 | xargs docker rm
```

\#删除所有dangling镜像（即无tag的镜像）：

```bash
docker rmi $(docker images | grep "^<none>" | awk "{print $3}")
```

\#删除所有dangling数据卷（即无用的Volume）：

```bash
docker volume rm $(docker volume ls -qf dangling=true)
```

 

\#数据卷容器删除

```bash
docker rm -v 卷名
```

参考命令：

```bash
df -h查看磁盘使用情况
df -i 查看inode使用情况
du -sh *查看当前目录下各个文件及目录占用空间大小
df -h和du -sh显示的磁盘大小不一致原因及解决办法
df -hT显示132G空间全部占用，du -sh显示只占用30G
```

