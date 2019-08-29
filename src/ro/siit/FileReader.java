package ro.siit;

/**
 * General class that reads a file and makes a buffer out of it.
 *
 * @author Radu Popescu
 */

import java.io.*;

public class FileReader {
    public BufferedReader fileRead(String fileName) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            return buffer;
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            return null;
        }
    }
}
