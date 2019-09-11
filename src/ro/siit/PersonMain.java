package ro.siit;

/**
 * Main class that executes the person management.
 *
 * @author Radu Popescu
 */

import java.util.List;

public class PersonMain {
    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();
        List<String[]> tempList = fileUtil.fileRead("fileIn.txt");

        PersonMethods personMethods = new PersonMethods();
        personMethods.putFilteredPersonsInFile(tempList, 10, "fileOut");
    }
}
