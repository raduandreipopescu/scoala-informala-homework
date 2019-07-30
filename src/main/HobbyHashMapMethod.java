package main;

/**
 * General class that keeps the person HashMap operations.
 *
 * @author Radu Popescu
 */

import person.Address;
import person.Hobby;
import person.Person;
import person.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HobbyHashMapMethod {
    public void personHobbyHashMap() {

        HashMap<Person, List<Hobby>> personHashMap = new HashMap<Person, List<Hobby>>();
        Person georgePerson = new Person("George", 35, "1850101123");
        Person andreeaPerson = new Student("Andreea", 25, "1950101123");

        List<Hobby> hobbyList = new ArrayList<Hobby>();
        List<Address> hobbyAddress = new ArrayList<Address>();
        addHobbyAddress("Italy", "Milano", hobbyAddress);
        addHobbyAddress("Romania", "Caracal", hobbyAddress);
        addHobby("Football", 3, hobbyAddress, hobbyList);

        hobbyAddress = new ArrayList<Address>();
        addHobbyAddress("United Kingdom", "London", hobbyAddress);
        addHobby("Tennis", 2, hobbyAddress, hobbyList);

        personHashMap.put(georgePerson, hobbyList);


        hobbyList = new ArrayList<Hobby>();
        hobbyAddress = new ArrayList<Address>();
        addHobbyAddress("Italy", "Milano", hobbyAddress);
        addHobbyAddress("Romania", "Caracal", hobbyAddress);
        addHobby("Football", 3, hobbyAddress, hobbyList);

        personHashMap.put(andreeaPerson, hobbyList);

        System.out.println(personHashMap.get(georgePerson));
    }

    public List<Address> addHobbyAddress(String country, String town, List<Address> hobbyAddress) {
        hobbyAddress.add(new Address(country, town));
        return hobbyAddress;
    }

    public List<Hobby> addHobby(String hobbyName, int hobbyFreq, List<Address> hobbyAddress, List<Hobby> hobbyList) {
        hobbyList.add(new Hobby(hobbyName, hobbyFreq, hobbyAddress));
        return hobbyList;
    }
}