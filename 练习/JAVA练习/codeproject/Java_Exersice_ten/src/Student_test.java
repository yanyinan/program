/**
 * @title:编程
 * @author:nanzhou
 * @date:2023.8.15
 */

/***1、**编写一个Student类，包含name、gender、age、id、score属性，
 * 分别为String、String、int、int、double类型。类中声明一个say方法，
 * 返回String类型，方法返回信息中包含所有属性值。在另一个`StudentTest`
 * 类中的main方法中，创建Student对象，并访问say方法和所有属性，并将调用
 * 结果打印输出*/
public class Student_test {
    public static void main(String[] args) {
        Student studentTest = new Student();
        System.out.println(studentTest.say());
    }
}
