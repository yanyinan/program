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
public class Book {
    private String title;
    private String anthor;
    private String year;
    private Double price;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAnthor(String anthor) {
        this.anthor = anthor;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAnthor() {
        return anthor;
    }

    public String getYear() {
        return year;
    }

    public Double getPrice() {
        return price;
    }
}
