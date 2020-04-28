package se.lexicon.michelle.data;

import se.lexicon.michelle.model.Person;

import java.util.Arrays;

public class People {
    private static Person[] personArray= new Person[0];

    /**
     * Returns the size of the personArray
     * @return int
     */
    public int size(){
        return personArray.length;
    }

    /**
     * returns the entire array of personArray
     * @return personArray
     */
    public Person[] findAll(){
        return personArray;
    }

    /**
     *finds the person with the correct id and returns the person,
     * return 0 if person with the specified index is not found.
     * @param personId int
     * @return person with the specified id, null if not found
     */
    public Person findById(int personId){
        for (Person person : personArray) {
            if (person.getPersonId() == personId) {
                return person;
            }
        }
        return null;
    }

    /**
     * creates new Person out of the given values
     * then adds them into newPersonArray.
     * sets the personArray to newPersonArray
     * returns the person you just created
     * @param firstName String
     * @param lastName String
     * @return Person
     */
    public Person addPerson(String firstName, String lastName){
        Person personToAdd = new Person(
                PersonSequencer.nextPersonId(),
                firstName, lastName
        );

        /*
            Creates a new array with the old arrays length +1
            This to make the array longer so you can add more objects to it
         */
        Person[] newPersonsArray = Arrays.copyOf(personArray,personArray.length + 1);
        int offSet = personArray.length;
        for(int i = offSet, j= 0; i < newPersonsArray.length; i++,j++){
            newPersonsArray[i] = personToAdd;
        }
        /*
            Sets personArray to newPersonsArray
            so that the old array now has the new size with the added object.
         */
        personArray = newPersonsArray;
        return personToAdd;
    }

    /**
     * clears the personArray by creating a new Person[] with size 0
     */
    public void clear(){
        personArray = new Person[0];
    }
}
