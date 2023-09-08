package LowestSalary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ## 薪资最低的员工
 *
 * 有一个员工类Employee,里面有name、age和salary字段。请通过 Stream 对多个Employee对象按salary排序,然后取前3个输出。
 * @author:nanzhou
 * @date:
 */
public class Lowest {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee employee = new Employee("张三",'男',2000.0);
        Employee employee1 = new Employee("张一",'男',3000.0);
        Employee employee2 = new Employee("张四",'男',4000.0);
        Employee employee3 = new Employee("张把",'男',3000.0);
        Employee employee4 = new Employee("张流",'男',2000.0);
        Employee employee5 = new Employee("张五",'女',1000.0);
        list.add(employee);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
/*        list.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList()).forEach(e-> System.out.println(e.toString()));*/
        list.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .limit(3)
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e.toString()));
    }
}
class Employee{
    String name;
    Character age;
    Double salary;

    public Employee(String name, Character age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getAge() {
        return age;
    }

    public void setAge(Character age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}