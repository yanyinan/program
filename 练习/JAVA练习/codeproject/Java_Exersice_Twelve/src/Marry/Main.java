package Marry;

import Marry.CAB;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Alice", 'F', 25, false);
        Person person2 = new Person("Bob", 'M', 44, true);
        Person person3 = new Person("Bob", 'M', 27, false);
        Person person4 = new Person("Alice", 'F', 23, false);

        CAB cab = new CAB();
        System.out.println( cab.canMarry(person1, person2));
        System.out.println( cab.canMarry(person3, person4));
    }
}
