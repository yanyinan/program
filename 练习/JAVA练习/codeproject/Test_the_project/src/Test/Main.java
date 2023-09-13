package Test;


import java.util.ArrayList;
import java.util.List;

class Person{
    String name="person";
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Studentes extends Person{
    String name="Student";
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Pupil extends Studentes{
    String name="Pupil";
    @Override
    public String toString() {
        return "Pupil{" +
                "name='" + name + '\'' +
                '}';
    }
}
/**
 * @author 26481
 */
public class Main {
    /**
     * List<? extends Studentes>
     * @param students
     */
    public static void show(List<? extends Studentes> students){
        students.stream().forEach(s -> System.out.println(s));
    }

    /**
     * List<? super Studentes>
     *
     * @param students
     */
    public static void display(List<? super Studentes> students){
        students.stream().forEach(s -> System.out.println(s));
    }
    public static void main(String[] args) {
        List<Pupil> pupils = new ArrayList<>();
        pupils.add(new Pupil());
        pupils.add(new Pupil());
        show(pupils);
        List<Person> peoples = new ArrayList<>();
        peoples.add(new Person());
        peoples.add(new Person());
        display(peoples);
    }

}