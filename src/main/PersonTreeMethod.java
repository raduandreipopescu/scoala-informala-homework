package main;

/**
 * General class that keeps the person TreeSet operations.
 *
 * @author Radu Popescu
 */

import person.Employee;
import person.Person;
import person.Student;
import person.Unemployee;

import java.util.TreeSet;

public class PersonTreeMethod {
    public void personTreeNameSort() {
        TreeSet<Person> personTree = new TreeSet<Person>(new NameComparator());

        personTree.add(new Employee("George", 35, "1850101123"));
        personTree.add(new Unemployee("Alina", 38, "2820101123"));
        personTree.add(new Employee("Luca", 26, "1940101123"));
        personTree.add(new Student("Rares", 25, "1950101123"));
        personTree.add(new Employee("Gabi", 30, "2800101123"));

        System.out.println("Sorted TreeSet using name comparator: ");

        for (Person person : personTree) {
            System.out.println(person);
        }
    }

    public void personTreeAgeSort() {
        TreeSet<Person> personTree = new TreeSet<Person>(new AgeComparator());

        personTree.add(new Employee("George", 35, "1850101123"));
        personTree.add(new Unemployee("Alina", 38, "2820101123"));
        personTree.add(new Employee("Luca", 26, "1940101123"));
        personTree.add(new Student("Rares", 25, "1950101123"));
        personTree.add(new Employee("Gabi", 30, "2800101123"));

        System.out.println("Sorted TreeSet using age comparator: ");

        for (Person person : personTree) {
            System.out.println(person);
        }
    }
}
