package Test;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Student {

    int age;

    public Student(int age) {
        this.age = age;
    }

    public void increment() {
        this.age++;//这行的this指代哪个对象
    }

    public static void main(String[] args) {
        Student stu1 = new Student(20);
        Student stu2 = new Student(21);
        stu1.increment();
        stu2.increment();
    }

}
