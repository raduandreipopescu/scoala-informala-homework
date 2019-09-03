package ro.siit;

/**
 * Main class that executes the threads for person management.
 *
 * @author Radu Popescu
 */

import java.util.ArrayList;

public class PersonMain {
    public static void main(String[] args) {

//   Single thread runnable (running time around 4000 ms)
//        ArrayList<String> allFileNames = new ArrayList<>();
//        allFileNames.add("file1.txt");
//        allFileNames.add("file2.txt");
//        PersonThread personThread1 = new PersonThread(allFileNames);
//        Thread thread1 = new Thread(personThread1);
//        thread1.start();

//   Dual thread runnable (running time around 3500 ms)
        ArrayList<String> firstFileName = new ArrayList<>();
        firstFileName.add("file1.txt");
        PersonThread personThread2 = new PersonThread(firstFileName);
        Thread thread2 = new Thread(personThread2);
        thread2.start();

        ArrayList<String> secondFileName = new ArrayList<>();
        secondFileName.add("file2.txt");
        PersonThread personThread3 = new PersonThread(secondFileName);
        Thread thread3 = new Thread(personThread3);
        thread3.start();
    }
}