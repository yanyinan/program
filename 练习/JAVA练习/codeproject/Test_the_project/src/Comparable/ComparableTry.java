package Comparable;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class ComparableTry implements Comparable{
    //定义字段
    private String name;
    private int age;
    private int score;

    public ComparableTry(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "ComparableTry{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object o) throws RuntimeException{
        if (o instanceof ComparableTry student) {
            if (this.age > student.age) {
                return 1;
            } else if (this.age < student.age) {
                return -1;
            }
            if (this.score > student.score) {
                return 1;
            } else if (this.score < student.score) {
                return -1;
            }
            return this.name.compareTo(student.name);
        }throw new CompareException("不合法");
    }

}
