package ro.siit;

/**
 * General class that keeps the standings operations.
 *
 * @author Radu Popescu
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StandingsMethods {
    public ArrayList<Athlete> athleteArrayList = new ArrayList<>();

    public void getAthletes(BufferedReader buffer) {
        String fileLine;
        try {
            while ((fileLine = buffer.readLine()) != null) {
                String[] results = fileLine.split(",");
                SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
                try {
                    Athlete athlete = new Athlete(Integer.parseInt(results[0]), results[1], results[2],
                            (Date) formatter.parse(results[3]), results[4], results[5], results[6]);
                    athleteArrayList.add(athlete);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("IO exception");
        }
    }

    public void timeCalculator(){
        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
        for (int i = 0; i < athleteArrayList.size(); i++) {
            Athlete athleteTemp = athleteArrayList.get(i);
            long count = (athleteTemp.getFirstShooting()).chars().filter(ch -> ch =='o').count() +
                    (athleteTemp.getSecondShooting()).chars().filter(ch -> ch =='o').count() +
                    (athleteTemp.getThirdShooting()).chars().filter(ch -> ch =='o').count();
            try {
                athleteTemp.setFinalTime(formatter.parse(formatter.format(new Date(athleteTemp.getSkiTimeResult().getTime()
                        + 10*1000*count))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            athleteTemp.setPenalty(10*count);
            athleteArrayList.set(i, athleteTemp);
        }
    }
}