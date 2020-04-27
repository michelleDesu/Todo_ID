package se.lexicon.michelle.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    private Person testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new Person(2,
                "Michelle",
                "Johansson" );
    }

    @Test
    public void testObject_has_correct_fields() {
        assertEquals( 2, testObject.getPersonId());
        assertEquals("Michelle", testObject.getFirstName());
        assertEquals("Johansson", testObject.getLastName());
    }

    @Test
    public void testObject_setName_correct_fields() {
        testObject.setFirstName("Olle");
        testObject.setLastName("Johnsson");
        assertEquals("Olle", testObject.getFirstName());
        assertEquals("Johnsson", testObject.getLastName());
    }
}
