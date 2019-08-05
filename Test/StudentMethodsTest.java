import main.StudentMethods;

import static org.junit.Assert.*;

public class StudentMethodsTest {

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void addStudentDateBefore() {
        StudentMethods testStudent = new StudentMethods();
        testStudent.addStudent("Gheorghe", "Hagi", "1860-01-05", "M", "160010500000");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void addStudentDateAfter() {
        StudentMethods testStudent = new StudentMethods();
        testStudent.addStudent("Gheorghe", "Hagi", "2018-01-05", "M", "160010500000");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void addStudentFirstNameEmpty() {
        StudentMethods testStudent = new StudentMethods();
        testStudent.addStudent("", "Hagi", "1960-01-05", "M", "160010500000");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void addStudentLastNameEmpty() {
        StudentMethods testStudent = new StudentMethods();
        testStudent.addStudent("Gheorghe", "", "1960-01-05", "M", "160010500000");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void addStudentWrongGender() {
        StudentMethods testStudent = new StudentMethods();
        testStudent.addStudent("Gheorghe", "Hagi", "1960-01-05", "cat", "160010500000");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void deleteStudentCNPEmpty() {
        StudentMethods testStudent = new StudentMethods();
        testStudent.deleteStudent("");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void deleteStudentCNPWrong() {
        StudentMethods testStudent = new StudentMethods();
        testStudent.deleteStudent("160010500001");
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void retrieveStudentAgeXNegative() {
        StudentMethods testStudent = new StudentMethods();
        testStudent.retrieveStudentAgeX(-1);
    }
}