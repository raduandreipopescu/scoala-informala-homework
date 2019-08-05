package main;

/**
 * General class that keeps the student operations.
 *
 * @author Radu Popescu
 */

import student.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.*;
import java.util.zip.DataFormatException;

public class StudentMethods {

    HashMap<String, Student> studentHashMap = new HashMap<String, Student>();

    public void addStudent(String firstName, String lastName, String dateOfBirthStr, String gender, String CNP) {

        if (firstName == null || firstName.length() == 0) {
            throw new IllegalArgumentException("First name can not be empty");
        }

        if (lastName == null || lastName.length() == 0) {
            throw new IllegalArgumentException("Last name can not be empty");
        }

        if (dateOfBirthStr == null || dateOfBirthStr.length() == 0) {
            throw new IllegalArgumentException("Birth date can not be empty");
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date dateOfBirth = null;
        try {
            dateOfBirth = format.parse(dateOfBirthStr);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Date format most be yyyy-mm-dd");
        }

        LocalDate localDate = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int birthYear = localDate.getYear();

        int currentYear = Year.now().getValue();

        if (birthYear < 1900 || birthYear > currentYear - 18) {
            throw new IllegalArgumentException("Birth date most be between 1900 and current yer - 18");
        }

        if (gender == null || gender.length() == 0) {
            throw new IllegalArgumentException("Gender most be male or female / M or F");
        }

        if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") &&
                !gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
            throw new IllegalArgumentException("Gender most be male or female / M or F");
        }

        if (CNP == null || CNP.length() == 0) {
            throw new IllegalArgumentException("CNP most not be null");
        }

        Student tempStudent = studentHashMap.get(CNP);
        if (tempStudent != null) {
            throw new IllegalArgumentException("CNP most be unique");
        }

        tempStudent = new Student(firstName, lastName, dateOfBirth, gender, CNP);

        studentHashMap.put(CNP, tempStudent);
    }

    public void deleteStudent(String CNP) {

        if (CNP == null || CNP.length() == 0) {
            throw new IllegalArgumentException("CNP most not be null");
        }

        Student tempStudent = studentHashMap.get(CNP);
        if (tempStudent == null) {
            throw new IllegalArgumentException("Student does not exist");
        }

        studentHashMap.remove(CNP);
    }

    public void retrieveStudentAgeX(Integer ageX) {

        if (ageX == null || ageX.intValue() < 0) {
            throw new IllegalArgumentException("Selected age most be a number bigger than 0");
        }

        ArrayList<Student> studentAgeXList = new ArrayList<Student>();

        int currentYear = Year.now().getValue();

        for (Map.Entry mapElement : studentHashMap.entrySet()) {
            Student tempStudent = (Student) mapElement.getValue();
            LocalDate localDate = tempStudent.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int birthYear = localDate.getYear();
            if (currentYear - birthYear == ageX) {
                studentAgeXList.add(tempStudent);
            }
        }
        for (Student studentObj : studentAgeXList) {
            System.out.println(studentObj);
        }
    }
}
