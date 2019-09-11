package ro.siit;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class FileUtilTest {

    @Test
    public void fileRead() throws IOException {
        FileUtil fileUtilTest = new FileUtil();
        List<String[]> tempList = fileUtilTest.fileRead("fileIn.txt");
        assertNotNull(tempList);
    }
}