package ro.siit;

/**
 * General class that reads a file and makes a buffer out of it.
 *
 * @author Radu Popescu
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

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
