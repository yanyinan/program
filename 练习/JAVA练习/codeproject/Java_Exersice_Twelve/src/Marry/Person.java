package Marry;

import java.util.Objects;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Person {
    private String name;
    private Character gender;
    private Integer age;
    private Boolean marry;

    /**
     * @param name
     * @param gender
     * @param age
     * @param marry
     */
    public Person(String name, Character gender, Integer age, Boolean marry) {
        setName(name);
        setGender(gender);
        setAge(age);
        setMarry(marry);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getMarry() {
        return marry;
    }

    public void setMarry(Boolean marry) {
        this.marry = marry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender);
    }

    @Override
    public String toString() {
        return "姓名：" + name + '\t' +
                "性别：" + gender + '\t' +
                "年龄：" + age + '\t' +
                "婚否：" + marry;
    }
}
