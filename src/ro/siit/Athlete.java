package ro.siit;

/**
 * General class to keep the common properties of athletes.
 *
 * @author Radu Popescu
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class Athlete {
    private int number;
    private String name;
    private String countryCode;
    private Date skiTimeResult;
    private String firstShooting;
    private String secondShooting;
    private String thirdShooting;
    private Date finalTime;
    private long penalty;

    public Athlete(int number, String name, String countryCode, Date skiTimeResult,
                   String firstShooting, String secondShooting, String thirdShooting) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShooting = firstShooting;
        this.secondShooting = secondShooting;
        this.thirdShooting = thirdShooting;
    }

    public int getNumber() {
        return number;
    }

    public long getPenalty() {
        return penalty;
    }

    public void setPenalty(long penalty) {
        this.penalty = penalty;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Date getSkiTimeResult() {
        return skiTimeResult;
    }

    public void setSkiTimeResult(Date skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public String getFirstShooting() {
        return firstShooting;
    }

    public void setFirstShooting(String firstShooting) {
        this.firstShooting = firstShooting;
    }

    public String getSecondShooting() {
        return secondShooting;
    }

    public void setSecondShooting(String secondShooting) {
        this.secondShooting = secondShooting;
    }

    public String getThirdShooting() {
        return thirdShooting;
    }

    public void setThirdShooting(String thirdShooting) {
        this.thirdShooting = thirdShooting;
    }

    public Date getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(Date finalTime) {
        this.finalTime = finalTime;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
        return name +
                " " + formatter.format(finalTime) +
                " (" + formatter.format(skiTimeResult) +
                " + " + penalty +
                ")";
    }
}