package StudentManagement;

import java.util.Comparator;
import java.util.Vector;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * 学生管理
 * 创建一个List集合表示学生列表。添加10个学生并设计方法实现根据学生成绩排序和计算
 * 平均成绩功能。
 * class Student{
 * private String name;
 * private Double score;
 * // 省略其他代码
 * }
 */
public class StudentList {
    public static void main(String[] args) {
        Vector<Student> stu = new Vector<>();
        Student stu1 = new Student("张三",90.3);
        stu.add(stu1);
        Student stu2 = new Student("张四",50.3);
        stu.add(stu2);
        Student stu3 = new Student("张五",70.3);
        stu.add(stu3);
        Student stu4 = new Student("张六",80.3);
        stu.add(stu4);
        System.out.println(stu);
        StuSort(stu, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getScore() - o2.getScore());
            }
        });
        System.out.println(stu);
    }

    private static void StuSort(Vector<Student> stu, Comparator<Student> comparator) {
        for (int i = 0; i < stu.size() - 1; i++) {
            for (int j = 0; j < stu.size() - 1 - i; j++) {
                // 比较器
                int result = comparator.compare(stu.get(j), stu.get(j + 1));
                if (result > 0) {
                    Student temp = stu.get(j);
                    stu.set(j, stu.get(j + 1));
                    stu.set(j + 1, temp);
                }

            }
        }
    }


}
