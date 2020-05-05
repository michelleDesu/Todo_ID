package se.lexicon.michelle.data;

import se.lexicon.michelle.model.Person;
import se.lexicon.michelle.model.Todo;

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
        for(int i = offSet; i < newPersonsArray.length; i++){
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

    /**
     * Remove the object with specified id from personArray
     * @param personId int
     * @return the new personArray.
     */
    public Person[] removeById(final int personId){
        Person[]  arrayBeforeTodoId   = new Person[0],
                arrayAfterTodoId    = new Person[0],
                newTodoArray        = new Person[0];

        boolean isFound = false;

        for ( Person person : personArray) {
            if (person.getPersonId() == personId) {
                isFound = true;
            } else if (!isFound) {
                /*
                every object in the array before the given ID is put in arrayBeforeTodoId
                 */
                arrayBeforeTodoId = increaseAddArray(arrayBeforeTodoId, person);
            } else {
                /*
                 every object in the array after the given ID is put in arrayAfterTodoId
                */
                arrayAfterTodoId = increaseAddArray(arrayAfterTodoId, person);
            }
        }

        /*
        To remove the object with the given ID combine the two arrays
        arrayBeforeTodoId and arrayAfterTodoId
         */
        newTodoArray = Arrays.copyOf(
                arrayBeforeTodoId,
                arrayBeforeTodoId.length + arrayAfterTodoId.length
        );

        System.arraycopy(
                arrayAfterTodoId,            //source array
                0,                    //copy from index
                newTodoArray,               // target array
                arrayBeforeTodoId.length,   //starting position in the destination data
                arrayAfterTodoId.length    //number elements to copy from last array
        );

        personArray = newTodoArray;

        return personArray;
    }

    /**
     * increases the array and adds the new object to new array
     * used to prevent unnecessary duplication of code.
     * @param toIncreaseArray Person[]
     * @param object Person
     * @return new increased personArray
     */
    private Person[] increaseAddArray(Person[] toIncreaseArray, Person object){
        toIncreaseArray = Arrays.copyOf(toIncreaseArray, toIncreaseArray.length + 1);
        toIncreaseArray[toIncreaseArray.length -1] = object;
        return toIncreaseArray;
    }

}
