package test4;


/**
 * @title:图书管理系统
 * @author:nanzhou
 * @date:2023.8.16
 */
/*## 图书管理系统 创建一个简单的图书管理系统，

包含以下类：

Book 类：表示图书，包含属性：书名（title）、作者（author）、出版年份（year）、价格（price）

Library 类：表示图书馆，包含属性：书库（使用数组保存图书）、添加图书的方法、查找图书的方法、显示所有图书的方法

完成以下功能

1. 添加图书
2. 查找图书
3. 显示图书列表。*/
public class test {
    public static void main(String[] args) {
        Library library = new Library();
        System.out.println("addbook");
        System.out.println(library.addbook("三国演义","huahau","1221",2.3));
        System.out.println(library.addbook("三国义","huahau","1221",2.3));
        System.out.println(library.addbook("三义","huahau","1221",2.3));
        System.out.println("selectbook");
        System.out.println(library.selectbook("三国演义"));
        System.out.println("showbook");
        library.showbook();
    }


}
