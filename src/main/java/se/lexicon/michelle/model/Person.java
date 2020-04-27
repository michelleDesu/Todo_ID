package se.lexicon.michelle.model;

public class Person {


    /**
     *
     * Private variables
     */
    private final int personId;
    private String  firstName,
            lastName;

    public Person(int personId , String firstName, String lastName){
        this.personId = personId;
        setFirstName(firstName);
        setLastName(lastName);
    }

    /**
     *
     * get and set methods
     */
    public int getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
