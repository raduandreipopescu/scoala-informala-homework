package ro.siit;

/**
 * General class that keeps the person operations.
 *
 * @author Radu Popescu
 */

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PersonMethods {
    public ArrayList<Person> personArrayList = new ArrayList<>();

    public void getPersons(BufferedReader buffer) {
        String fileLine;
        try {
            while ((fileLine = buffer.readLine()) != null) {
                String[] results = fileLine.split(",");

                Sex sex = Sex.fromString(results[2]);
                String sexString = "";
                switch (sex) {
                    case FEMALE: {
                        sexString = "female";
                        break;
                    }
                    default: {
                        sexString = "male";
                        break;
                    }
                }

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Person person = new Person(results[0], (Date) formatter.parse(results[1]), sexString);
                    personArrayList.add(person);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("IO exception");
        }
    }

    public enum Sex {
        FEMALE, MALE;

        public static Sex fromString(String input) {
            if (input.equalsIgnoreCase("female") || input.equalsIgnoreCase("1")) {
                return FEMALE;
            } else if (input.equalsIgnoreCase("male") || input.equalsIgnoreCase("0")) {
                return MALE;
            } else {
                throw new IllegalArgumentException("No enum constant");
            }
        }
    }

    public void getCelebratedFemales(ArrayList<Person> personArrayList) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
        SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");
        Date today = Calendar.getInstance().getTime();
        final List<Person> results =
                personArrayList
                        .stream()
                        .filter(s -> s.getSex().equals("female"))
                        .filter(s -> formatter.format(s.getBirthDate()).equals(formatter.format(today)))
                        .collect(Collectors.toList());

        results.forEach(s -> {
            System.out.println("Happy birthday " + s.getName() + " (" + yearFormatter.format(s.getBirthDate()) + ")!");
            try {
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(s.getName() + ".txt"), "utf-8"));
                writer.write("Happy birthday " + s.getName() + " (" + yearFormatter.format(s.getBirthDate()) + ")!\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
