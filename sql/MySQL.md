# 安装MySQL



1. 解压`mysql-8.0.30-winx64.zip`到 `d:/kaifamiao/envirments`文件夹下

2. 输入`cmd`使用管理员方式打开命令提示窗口

3. 使用命令将目录调整到`D:\kaifamiao\enviroments\mysql-8.0.30-winx64`目录下

   - `cd` 
   - `盘符:`
   - `dir`
   - `../`
   - `./`

4. 依次执行脚本

   1. `1initialization.bat` 初始化。完成后会有一个`data`目录产生
   2. `2install.bat` 安装 `mysql` 服务
   3. `3startup.bat` 启动`mysql ` 服务

   > `4reboot.bat`为重启服务命令
   >
   > `5stop.bat`为停止服务命令
   >
   > `6uninstall.bat` 为卸载服务命令

   **注意：**初始化脚本只需要执行一次。如果在某个过程出错，删掉目录，重新来过即可。



## 验证安装

前提：启动了`mysql`服务后

1. `cmd`窗口中输入以下命令：

   ```shell
   mysql -u root -p
   ```

2. 能够进入到`mysql`即为成功安装。