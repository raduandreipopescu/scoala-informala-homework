package main;

/**
 * Main class that operates the management of persons.
 *
 * @author Radu Popescu
 */

public class PersonManagement {
    public static void main(String[] args) {

        PersonTreeMethod personTreeObj = new PersonTreeMethod();
        personTreeObj.personTreeNameSort();
        System.out.println("---------------------------------");
        personTreeObj.personTreeAgeSort();

        System.out.println("---------------------------------");
        HobbyHashMapMethod hobbyHashMapObj = new HobbyHashMapMethod();
        hobbyHashMapObj.personHobbyHashMap();
    }
}
