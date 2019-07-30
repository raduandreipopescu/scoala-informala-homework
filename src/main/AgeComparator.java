package main;

/**
 * General class that compares persons by age.
 *
 * @author Radu Popescu
 */

import person.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    public AgeComparator() {
    }

    @Override
    public int compare(Person person1, Person person2) {
        int compResult;
        if (person1.getAge() < person2.getAge()) {
            compResult = -1;
        } else if (person1.getAge() > person2.getAge()) {
            compResult = 1;
        } else {
            compResult = 0;
        }

        return compResult;
    }
}
