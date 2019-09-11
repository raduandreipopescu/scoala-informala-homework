package ro.siit;

/**
 * General class that reads a file and makes a String[] out of it.
 *
 * @author Radu Popescu
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FileUtil {
    final List<String[]> fileRead(String fileNameIn) {
        try {
            return Files.lines(Paths.get(fileNameIn)).map(s -> s.split(",")).collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}