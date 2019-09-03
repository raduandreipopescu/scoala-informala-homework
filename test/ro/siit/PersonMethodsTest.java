package ro.siit;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.Assert.*;

public class PersonMethodsTest {

    @Test
    public void getPersons() {
        String str = "Timmy Waelchi,1968-09-03,female";
        BufferedReader buffer = new BufferedReader(new StringReader(str));
        PersonMethods personMethodsTest = new PersonMethods();
        personMethodsTest.getPersons(buffer);
        assertTrue(personMethodsTest.personArrayList.size() > 0);
    }
}