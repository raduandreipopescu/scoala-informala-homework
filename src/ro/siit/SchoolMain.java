package ro.siit;

/**
 * Main class that executes the school database methods.
 *
 * @author Radu Popescu
 */

public class SchoolMain {
    public static void main(String[] args) {
        SchoolDbMethods.getAllClasses();
        System.out.println("----------------------------------------------------------------------------");
        SchoolDbMethods.getCourseById(2);
        System.out.println("----------------------------------------------------------------------------");
        SchoolDbMethods.getClassesWithIntroTitle();
        System.out.println("----------------------------------------------------------------------------");
        SchoolDbMethods.getClassesWithCosDept();
        System.out.println("----------------------------------------------------------------------------");
        SchoolDbMethods.getClassesWithCosProfname();
        System.out.println("----------------------------------------------------------------------------");
    }
}
