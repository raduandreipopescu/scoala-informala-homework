package main;

/**
 * General class that compares persons by name.
 *
 * @author Radu Popescu
 */

import person.Person;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    public NameComparator() {
    }

    @Override
    public int compare(Person person1, Person person2) {

        return person1.getName().compareTo(person2.getName());
    }
}
