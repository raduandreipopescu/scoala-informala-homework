package ro.siit;

/**
 * General class that creates a thread for person management.
 *
 * @author Radu Popescu
 */

import java.io.BufferedReader;
import java.util.ArrayList;

public class PersonThread implements Runnable {
    private ArrayList<String> fileNames;

    public PersonThread(ArrayList<String> fileNames) {
        this.fileNames = fileNames;
    }

    @Override
    public void run() {
        Long time = System.currentTimeMillis();

        FileReader fileReader = new FileReader();
        PersonMethods personMethods = new PersonMethods();

        fileNames.forEach(s -> {
            BufferedReader fileContent = fileReader.fileRead(s);
            personMethods.getPersons(fileContent);
        });

        ArrayList<Person> persons = personMethods.personArrayList;
        personMethods.getCelebratedFemales(persons);

        System.out.println(System.currentTimeMillis() - time);
    }
}
