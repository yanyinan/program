package test1;

/**
 * @title:Student
 * @author:nanzhou
 * @date:2023.08.16
 */
/*## 创建一个学生类 编写一个名为 test1.Student 的类，

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
