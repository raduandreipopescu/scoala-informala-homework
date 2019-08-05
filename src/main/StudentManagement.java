package main;

/**
 * Main class that operates the management of students.
 *
 * @author Radu Popescu
 */

public class StudentManagement {
    public static void main(String[] args) {
        StudentMethods studentMethodsObj = new StudentMethods();
        studentMethodsObj.addStudent("Gheorghe", "Hagi", "1960-01-05", "M", "160010500000");
        studentMethodsObj.addStudent("Alina", "Vasile", "1980-01-05", "female", "280010500000");
        studentMethodsObj.addStudent("Adrian", "Ilie", "1970-01-05", "Male", "170010500000");
        studentMethodsObj.addStudent("Andreea", "Esca", "1960-01-05", "f", "260010500000");

        studentMethodsObj.deleteStudent("260010500000");

        studentMethodsObj.retrieveStudentAgeX(59);
    }
}
