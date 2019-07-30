import main.AgeComparator;
import org.junit.Test;
import person.Person;

import static org.junit.Assert.assertEquals;

public class AgeComparatorTest {

    @Test
    public void compare() {
        Person testPerson1 = new Person("Vasile", 79, "120101012345");
        Person testPerson2 = new Person("Andrei", 39, "160101012345");
        AgeComparator ageComparatorTest = new AgeComparator();
        int result = ageComparatorTest.compare(testPerson1, testPerson2);
        assertEquals(1, result);
    }
}