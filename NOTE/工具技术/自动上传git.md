

# 自动上传git

### 执行脚本

保存为`.bat`文件

```
@echo off
@title bat 交互执行git命令
D:
cd D:/git/test
git add .
git commit -m %date:~0,4%年%date:~5,2%月%date:~8,2%日
git push
```

## 教程如下

### 1、搜索任务计划程序（最好管理员身份运行，普通用户可能无权限）

![image-20230728193909789](https://s2.loli.net/2023/07/28/D4CG87puoXFP3UK.png)

### 2、点击任务计划程序库创建基本任务

![image-20230728193939517](https://s2.loli.net/2023/07/28/ok12j6DRVH8pyTN.png)

![屏幕截图 2023-07-28 193945](https://s2.loli.net/2023/07/28/nw7QzeyqhPKXibt.png)

根据个人命名、描述

![屏幕截图 2023-07-28 194048](https://s2.loli.net/2023/07/28/8jqcPS7L31hKUlk.png)

选择脚本文件

![屏幕截图 2023-07-28 195846](https://s2.loli.net/2023/07/28/2egvEpK6jzHT5uW.png)

其余按照流程操作，最后完成前，可以点击完成时打开任务属性进行高级的编辑

![image-20230728195902470](https://s2.loli.net/2023/07/28/Cu4UOL3z5tfjmo7.png)



### 高级设置

根据自己需要选择详细的时间重复，当前选项为`一小时重复一次`                                                                                                                                                                                                   

![屏幕截图 2023-07-28 194654](https://s2.loli.net/2023/07/28/AcTwkIUdnMyrvq6.png)

这里可对触发器进行重新编辑

![屏幕截图 2023-07-28 194716](https://s2.loli.net/2023/07/28/g9RqAloUDMafsJZ.png)

设置任务条件

![屏幕截图 2023-07-28 194849](https://s2.loli.net/2023/07/28/4xVSXzZ3nMcNKyJ.png)

以上完成，就会实现自己想完成的基本任务。