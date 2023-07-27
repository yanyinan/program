## 注册账号
图床网站：[Image Upload - SM.MS - Simple Free Image Hosting (smms.app)/](https://smms.app/)
自行注册账号即可！
## 获取 API Token
![image](https://s2.loli.net/2023/07/23/qfsyDFndLjul3vH.png)
## Typora配置
软件自行下载安装
>Typora官网：[Typora — a markdown editor, markdown reader.](https://typora.io/)
>Typora国内官网：[Typora 官方中文站 (typoraio.cn)](https://typoraio.cn/)

![image-1690125121268](https://s2.loli.net/2023/07/23/E8AcXe6m2JaWqLf.png)

## 配置文件代码
```json
{
  "picBed": {
    "current": "smms-user",
    "uploader": "smms-user",
    "smms-user": {
      "Authorization": "你自己的 API Token"
    },
    "transformer": "path"
  },
  "picgoPlugins": {
    "picgo-plugin-smms-user": true,
    "picgo-plugin-gitee-uploader": true
  }
}
```
## 安装Node
下插件需要安装Node.js的npm命令下载插件
>Node官网：[Node.js (nodejs.org)](https://nodejs.org/en)
>Node国内官网：[Node.js 中文网 (nodejs.cn)](https://nodejs.cn/)
## 执行安装插件命令
进入`C:\Users\15322\AppData\Roaming\Typora\picgo\win64`在此目录下运行打开命令行终端执行命令
```cmd
.\picgo.exe install smms-user
```
显示安装成功即配置图床完成