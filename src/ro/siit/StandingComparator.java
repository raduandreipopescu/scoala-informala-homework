package ro.siit;

/**
 * General class that compares athletes by final calculated time.
 *
 * @author Radu Popescu
 */

public class StandingComparator implements java.util.Comparator<Athlete> {

    public StandingComparator() {
    }

    @Override
    public int compare(Athlete athlete1, Athlete athlete2) {
        int compResult;
        if ((athlete1.getFinalTime()).compareTo(athlete2.getFinalTime()) < 0) {
            compResult = -1;
        } else if ((athlete1.getFinalTime()).compareTo(athlete2.getFinalTime()) > 0) {
            compResult = 1;
        } else {
            compResult = 0;
        }
        return compResult;
    }
}