import main.NameComparator;
import org.junit.Test;
import person.Person;

import static org.junit.Assert.assertTrue;

public class NameComparatorTest {

    @Test
    public void compare() {
        Person testPerson1 = new Person("Vasile", 79, "120101012345");
        Person testPerson2 = new Person("Andrei", 39, "160101012345");
        NameComparator nameComparatorTest = new NameComparator();
        int result = nameComparatorTest.compare(testPerson1, testPerson2);
        boolean resultTest = false;
        if (result > 0) {
            resultTest = true;
        }
        assertTrue(resultTest);
    }
}