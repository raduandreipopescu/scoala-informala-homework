package ro.siit;

import org.junit.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PersonMethodsTest {

    @Test
    public void putFilteredPersonsInFile() {
        String[] personTest = new String[]{"Alexis", "White", "1995-03-13"};
        List<String[]> fileContent = new ArrayList();
        fileContent.add(personTest);

        int targetMonth = 3;

        String outputFileName = "fileOutTest";

        PersonMethods personMethodsTest = new PersonMethods();
        Writer writer = personMethodsTest.putFilteredPersonsInFile(fileContent, targetMonth, outputFileName);

        Path path = Paths.get(outputFileName + ".txt");
        try {
            long lineCount = Files.lines(path).count();
            assertEquals(1, lineCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}