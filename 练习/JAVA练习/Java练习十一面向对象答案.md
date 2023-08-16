## 创建一个学生类 编写一个名为 Student 的类，

包含以下属性和方法：

属性：姓名（name）、年龄（age）、学号（studentId）、成绩（score）

方法：构造方法、获取姓名的方法、获取年龄的方法、获取学号的方法、获取成绩的方法、设置成绩的方法

```java
/**
 * @title:Student
 * @author:nanzhou
 * @date:2023.08.16
 */
/*## 创建一个学生类 编写一个名为 Student 的类，

包含以下属性和方法：

属性：姓名（name）、年龄（age）、学号（studentId）、成绩（score）

方法：构造方法、获取姓名的方法、获取年龄的方法、获取学号的方法、获取成绩的方法、设置成绩的方法*/
public class Student {
    private String name;
    private Integer age;
    private String studentId;
    private Double score;

    public Student(){
        this("未知",18,"xxx",0);
    }
    public  Student(String name, int age, String studentId,double score){
        setName(name);
        setAge(age);
        setStudentId(studentId);
        setScore(score);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getStudentId() {
        return studentId;
    }

    public Double getScore() {
        return score;
    }
}
```

## 银行账户管理 创建一个名为 BankAccount 的类，用于管理银行账户。

该类包含以下属性和方法：

属性：账户号码（accountNumber）、账户持有人姓名（accountHolder）、余额（balance）

方法：构造方法、获取账户号码的方法、获取账户持有人姓名的方法、获取余额的方法、存款方法、取款方法

```java
package test2;

/**
 * @title:银行账户管理
 * @author:nanzhou
 * @date:2023.8.16
 */
/*## 银行账户管理 创建一个名为 BankAccount 的类，用于管理银行账户。

该类包含以下属性和方法：

属性：账户号码（accountNumber）、账户持有人姓名（accountHolder）、余额（balance）

方法：构造方法、获取账户号码的方法、获取账户持有人姓名的方法、获取余额的方法、存款方法、取款方法*/
public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private Double balance;

    public BankAccount() {
        this( null,null,0.0);
    }

    public BankAccount(String accountNumber, String accountHolder, Double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public Double getBalance() {
        return balance;
    }
}

```



## 几何图形计算器 设计一个几何图形计算器，可以计算圆的面积和矩形的面积。

创建名为 GeometryCalculator 的类，

包含以下实例方法：

calculateCircleArea(double radius) ：计算并返回圆的面积

calculateRectangleArea(double width, double height) ：计算并返回矩形的面积

完成计算圆的面积以及计算矩形的面积等功能。

```java
package test3;

/**
 * @title:几何图形计算器
 * @author:nanzhou
 * @date:2023.8.16
 */
/*## 几何图形计算器 设计一个几何图形计算器，可以计算圆的面积和矩形的面积。

创建名为 GeometryCalculator 的类，

包含以下实例方法：

calculateCircleArea(double radius) ：计算并返回圆的面积

calculateRectangleArea(double width, double height) ：计算并返回矩形的面积

完成计算圆的面积以及计算矩形的面积等功能。*/
public class GeometryCalculator {
    public double calculateCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public double calculateRectangleArea(double width, double height) {
        return width * height;
    }

}
```

## 图书管理系统 创建一个简单的图书管理系统，

包含以下类：

Book 类：表示图书，包含属性：书名（title）、作者（author）、出版年份（year）、价格（price）

Library 类：表示图书馆，包含属性：书库（使用数组保存图书）、添加图书的方法、查找图书的方法、显示所有图书的方法

完成以下功能

1. 添加图书
2. 查找图书
3. 显示图书列表。

`book`

```java
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

```

`library`

```java
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

```

`test`

```java
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

```

