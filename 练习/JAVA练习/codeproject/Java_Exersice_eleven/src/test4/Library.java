package test4;

import java.util.Arrays;

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
public class Library {
    Book[] bookslibrary = new Book[10];
    private int count = 0;

    public void setBookslibrary(Book[] bookslibrary) {
        this.bookslibrary = bookslibrary;
    }

    public Book[] getBookslibrary() {
        return bookslibrary;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String addbook(String title, String anthor, String year, Double price) {
        if (count >= bookslibrary.length) {
            bookslibrary = Arrays.copyOf(bookslibrary, count * 2);
        }
        bookslibrary[count] = new Book();
        bookslibrary[count].setTitle(title);
        bookslibrary[count].setAnthor(anthor);
        bookslibrary[count].setYear(year);
        bookslibrary[count].setPrice(price);
        count++;
        return "书名：" + title + "作者：" + anthor + "出版年份：" + year + "价格：" + price + "addbook is ok";
    }

    public String selectbook(String title) {
        for (int i = 0; i < count; i++) {
            if (bookslibrary[i].getTitle().equals(title))
                return "书名：" + bookslibrary[i].getTitle() + "作者：" + bookslibrary[i].getAnthor() + "出版年份：" + bookslibrary[i].getYear() + "价格：" + bookslibrary[i].getPrice();
        }
        return "未找到";
    }

    public void showbook() {
        for (int i = 0; i < count; i++) {
            System.out.printf("书名：%s\t作者：%s\t出版年份：%s\t价格：%.2f\n",
                    bookslibrary[i].getTitle(), bookslibrary[i].getAnthor(), bookslibrary[i].getYear(), bookslibrary[i].getPrice());
        }
    }

}
