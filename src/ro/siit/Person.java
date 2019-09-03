package ro.siit;

/**
 * General class to keep the common properties of persons.
 *
 * @author Radu Popescu
 */

import java.util.Date;

public class Person {
    private String name;
    private Date birthDate;
    private String sex;

    public Person(String name, Date birthDate, String sex) {
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", sex='" + sex + '\'' +
                '}';
    }
}
