## 命令激活`Windows`系统（无需激活工具、激活码）

### **背景**

以前我们激活 Windows，都是网上四处找激活码，或者下载 KMS 激活软件。这次我发现一个一键激活 Windows 神器，只要输入一条命令就能完成激活，不需要找激活码，不需要下载软件。

### **解决**

这个神器叫 **[Microsoft Activation Scripts (MAS)](https://link.zhihu.com/?target=https%3A//github.com/massgravel/Microsoft-Activation-Scripts)**，是 `github `上的一个开源项目。

具体的操作步骤

1. `Windows `菜单右击，选择 `Windows `终端 或者 `PowerShell`，即可打开终端窗口

2. 粘贴这条命令后回车
   ```shell
   irm https://massgrave.dev/get | iex
   ```

   ![image-20231011204254149](https://s2.loli.net/2023/10/11/SUp6VEa9FhJNqwR.png)

3. 会出现界面提示

   ![image-20231011204329026](https://s2.loli.net/2023/10/11/Axp71bFHNOEQzek.png)

   这时候输入 `1`，即可选择永久激活

4. 然后等待激活过程完成，激活成功后，关闭这些窗口就行了。再去系统设置查看就能显示激活成功了

   ![image-20231011204504168](https://s2.loli.net/2023/10/11/jotmu6JV54UECY9.png)

   