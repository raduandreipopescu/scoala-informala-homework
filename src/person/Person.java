package person;

/**
 * General class to keep the common properties of persons.
 *
 * @author Radu Popescu
 */

public class Person {
    private String name;
    private int age;
    private String CNP;

    public Person(String name, int age, String CNP) {
        this.name = name;
        this.age = age;
        this.CNP = CNP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return (person.name.equals(this.name) && person.age == this.age && person.CNP.equals(this.CNP));
    }
}
