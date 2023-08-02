# https和http有什么区别

## 简要

区别如下：

1. ​	https的端口是443.而http的端口是80，且二者连接方式不同；
2. http传输时明文，而https是用ssl进行加密的，https的安全性更高；
3. https是需要申请证书的，而http不需要。

## 详细

### 1、什么事https和http

https是http的安全版本，也叫超文本安全传输，https是有加密传输协议的通道，并且SSL提供了安全加密基础，https主要是用于http的传输，并且HTTP与TCP知己去拿有一个特殊的加密身份验证。

http是一种普通的传输协议，在互联网上，所有的文件都要遵守这个HTTP协议，超文本也是http传输的基本部分，实现客户端和服务器的互相请求。

## 2、https和http有什么区别

![https和http有什么区别](https://s2.loli.net/2023/07/27/bTotQCYenFuBPEW.jpg)

1. 端口

   http的端口是443，而https的端口是80，两者的连接方式也是不太一样的。

2. 传输数据、

   http传输的是明文，而https是进行ssl进行加密的。https具有安全性

3. 申请证书

   https传输一般是需要申请证书，申请证书可能会需要一定的费用。

   而http不需要

## 目前见到的tips:

### 复制粘贴的问题

在Chrome的DevTools控制台下执行navigator和clipboard返回undefined,这是因为浏览器禁用了非安全域的navigator.clipboard对象。要解决这个问题，您可以使用以下兼容写法：

```javascript
if (navigator && navigator.clipboard) {
  // 在安全域下使用navigator.clipboard提升效率
  navigator.clipboard.writeText('要复制的文本').then(() => {
    console.log('复制成功');
  }).catch((err) => {
    console.error('复制失败', err);
  });
} else if (document && document.execCommand) {
  // 在非安全域下使用document.execCommand('copy')保证功能可用
  const range = document.createRange();
  range.selectNode(document.getElementById('text-to-copy'));
  const selection = window.getSelection();
  selection.removeAllRanges();
  selection.addRange(range);
  document.execCommand('copy');
  console.log('复制成功');
} else {
  console.error('无法复制文本');
}
```

这段代码首先检查navigator和navigator.clipboard是否存在，如果存在则在安全域下使用navigator.clipboard提升效率。如果不存在，则退回到使用document.execCommand('copy')来保证功能可用。

安全域包括本地访问与开启TLS安全认证的地址，如https协议的地址、127.0.0.1或alhost。因此，如果您需要在非安全域下使用剪贴板功能，可以考虑将相关代码部署到这些地址上。