## Apache Tomcat

### Tomcat基本概述：

Tomcat服务器是一个免费的开放源代码的Web应用服务器。Tomcat是Apache软件基金会(Apache SoftwareFoundation）的Jakarta项目中的一个核心项目,由Apache、Sun和其他一些公司及个人共同开发而成。由于有了Sun的参与和支持，最新的Servlet 和JSP规范总是能在Tomcat中得到体现。

因为Tomcat技术先进、性能稳定，而且免费，因而深受Java爱好者的喜爱并得到了部分软件开发商的认可，是目前比较流行的Web应用服务器。

### 下载与安装

1. 到[Tomcat官网](https://tomcat.apache.org/)，选择左侧`Which version`。如图：

   ![image-20231012222805242](https://s2.loli.net/2023/10/12/jCSN2Pu4xXOtJwK.png)

2. 根据项目版本需求在左侧选择对应`Tomcat`版本

   ![image-20231012223116190](https://s2.loli.net/2023/10/12/DTsLIqlkjC3YQh7.png)

   - `tar.gz `是 `linux` 操作系统下的安装版本

   - `zip `是` windows` 操作系统下的压缩版本（选这个版本）

   - `Windows Service Installer` 是` windows `操作系统下的 `exe` 安装版本

3. 下载完成后，将文件解压到对应的文件夹下存放

4. 配置环境，` Tomcat` 运行依赖` java` 环境所以配置了` java `环境后就可以直接使用` tomcat` 。如果没有配置` java `环境不能运行 `tomcat` 。

### 启动

启动`Tomcat`

到` tomcat` 目录下的` bin` 目录，找到` startup.bat `文件，双击运行。

![image-20231012223643961](https://s2.loli.net/2023/10/12/qs4TCQ8WzexKFLH.png)

启动成功界面：

![image-20231012223705838](https://s2.loli.net/2023/10/12/SvwTPQh1qafnrtG.png)

> 启动成功后不要关闭此窗口

测试tomcat服务

打开浏览器在，在浏览器的地址栏中输入：

1. **http://127.0.0.1:8080/**
2. **http://localhost:8080/**

![image-20231012223801257](https://s2.loli.net/2023/10/12/9nkE1XWqBe7PrSU.png)

### 关闭

1. 直接关闭 tomcat 启动窗口
2. tomcat 目录下 bin 目录，查找其中的 shutdown.bat 命令，双击关闭服务器

![image-20231012224223060](https://s2.loli.net/2023/10/12/aAO2lygsRY4Hbiw.png)