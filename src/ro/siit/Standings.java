package ro.siit;

/**
 * Main class that makes the standings.
 *
 * @author Radu Popescu
 */

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;

public class Standings {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        BufferedReader fileContent = fileReader.fileRead("Standings.csv");

        StandingsMethods standingsMethods = new StandingsMethods();
        standingsMethods.getAthletes(fileContent);
        standingsMethods.timeCalculator();

        ArrayList<Athlete> standings = standingsMethods.athleteArrayList;
        Collections.sort(standings, new StandingComparator());

        for (int i = 0; i < standings.size(); i++) {
            switch (i+1) {
                case 1: {
                    System.out.println("Winner - " + standings.get(i).toString());
                    break;
                }
                case 2: {
                    System.out.println("Runner-up - " + standings.get(i).toString());
                    break;
                }
                case 3: {
                    System.out.println("Third Place - " + standings.get(i).toString());
                    break;
                }
                default:
                    break;
            }
        }
    }
}