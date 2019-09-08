package person;

/**
 * General class to keep the hobby properties, name, frequency and the list of addresses.
 *
 * @author Radu Popescu
 */

import java.util.List;

public class Hobby {
    private String hobbyName;
    private int hobbyFreq;
    private List<Address> hobbyAddressList;

    public Hobby(String hobbyName, int hobbyFreq, List<Address> hobbyAddressList) {
        this.hobbyName = hobbyName;
        this.hobbyFreq = hobbyFreq;
        this.hobbyAddressList = hobbyAddressList;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public int getHobbyFreq() {
        return hobbyFreq;
    }

    public void setHobbyFreq(int hobbyFreq) {
        this.hobbyFreq = hobbyFreq;
    }

    public List getHobbyAddressList() {
        return hobbyAddressList;
    }

    public void setHobbyAddressList(List<Address> hobbyAddressList) {
        this.hobbyAddressList = hobbyAddressList;
    }

    @Override
    public String toString() {
        String tempAddress = "";
        for (Address hobbyAddressListObj : hobbyAddressList) {
            tempAddress = tempAddress + " " + hobbyAddressListObj.getCountry();
        }
        return "Hobby{" +
                "hobbyName = '" + hobbyName + '\'' +
                ", country from hobbyAddressList = " + tempAddress +
                '}';
    }
}
