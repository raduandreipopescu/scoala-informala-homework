package ro.siit;

/**
 * General class that keeps the person operation to put the filtered persons in a file.
 *
 * @author Radu Popescu
 */

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonMethods {

    public Writer putFilteredPersonsInFile(List<String[]> fileContent, int targetMonth, String outputFileName) {
        List<Person> personList = new ArrayList<>();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

        for (String[] s : fileContent) {
            try {
                personList.add(new Person(s[0], s[1], dateFormatter.parse(s[2])));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(outputFileName + ".txt"), "utf-8"));

            personList.stream()
                    .filter(f -> f.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).getMonthValue() == targetMonth)
                    .sorted(Comparator.comparing(Person::getFirstName))
                    .forEach(w -> {
                        try {
                            writer.write(w.getFirstName() + " " + w.getLastName() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            writer.close();
            return writer;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}