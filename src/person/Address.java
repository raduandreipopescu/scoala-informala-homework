package person;

/**
 * General class to keep the address properties, country and town.
 *
 * @author Radu Popescu
 */

public class Address {
    private String country;
    private String town;

    public Address(String country, String town) {
        this.country = country;
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
