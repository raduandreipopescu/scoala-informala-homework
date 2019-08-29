import org.junit.Test;
import ro.siit.Athlete;
import ro.siit.StandingsMethods;

import java.io.BufferedReader;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class StandingsMethodsTest {

    @Test
    public void getAthletes() {
        String str = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";
        BufferedReader buffer = new BufferedReader(new StringReader(str));
        StandingsMethods standingsMethodsTest = new StandingsMethods();
        standingsMethodsTest.getAthletes(buffer);
        assertTrue(standingsMethodsTest.athleteArrayList.size() > 0);
    }

    @Test
    public void timeCalculator() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
        Athlete athlete = new Athlete(11, "Umar Jorgson", "SK",
                (Date) formatter.parse("30:27"), "xxxox", "xxxxx", "xxoxo");
        StandingsMethods standingsMethodsTest = new StandingsMethods();
        standingsMethodsTest.athleteArrayList.add(athlete);
        standingsMethodsTest.timeCalculator();
        assertEquals((Date) formatter.parse("30:57"), standingsMethodsTest.athleteArrayList.get(0).getFinalTime());
    }
}