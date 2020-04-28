package se.lexicon.michelle.data;


import org.junit.Before;
import org.junit.Test;
import se.lexicon.michelle.model.Person;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class PeopleTest {
    private  People peopleTest;
    private  Person firstPerson,
            secondPerson;

    @Before
    public void setUp() throws Exception {
        peopleTest = new People();
        peopleTest.clear();
        PersonSequencer.reset();

        /**
         *  creates names to have easy access to them later on
         */
        String  firstName = "Michelle",
                lastName = "Johansson";

        firstPerson = peopleTest.addPerson(firstName, lastName);
        firstName = "Saga";
        lastName = "Helgadotter";
        secondPerson = peopleTest.addPerson(firstName, lastName);

    }


    //addPerson
    @Test
    public void given_firstName_lastName_should_return_person() {
       Person expected = new Person(
               2,
               "Olle",
               "Johnsson"
               ),
               actual =  peopleTest.addPerson("Olle" , "Johnsson" );

       assertEquals(expected.getPersonId(), actual.getPersonId() );
       assertEquals(expected.getFirstName(), actual.getFirstName() );
       assertEquals(expected.getLastName(), actual.getLastName() );

    }

    //size
    @Test
    public void size_should_return_size_of_array() {
       int expected = 2,
               actual = peopleTest.size();
       assertEquals(expected, actual);
    }

    //findAll

    @Test
    public void findAll_should_return_all_objects_in_array() {
        Person[] expected = new Person[2];
        expected[0] = firstPerson;
        expected[1] = secondPerson;

        assertArrayEquals(expected, peopleTest.findAll());
    }

    //findById
    @Test
    public void given_id_should_return_correct_id() {
        Person actual = peopleTest.findById(1);

        assertEquals(secondPerson, actual);
    }


    @Test
    public void clear_should_clear_the_array() {
        Person[] expected = new Person[0];
        peopleTest.clear();
        Person[] actual = peopleTest.findAll();

        assertArrayEquals(expected, actual);

    }

}
