package se.lexicon.michelle.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TodoTest {

    private Todo testObject;
    private Person testPerson;
    @Before
    public void setUp() throws Exception {
       testObject = new Todo(
               1,
               "TestingTodo");

       testPerson = new Person(1,
               "Michelle",
               "johansson");

    }

    @Test
    public void testObject_has_correct_fields() {

        assertEquals( 1, testObject.getTodoId());
        assertEquals("TestingTodo", testObject.getDescription());
    }

    @Test
    public void given_done_true_should_return_true() {
        testObject.setDone(true);
        boolean expected = true;
        assertTrue( testObject.isDone());
    }
    @Test
    public void given_done_false_should_return_false() {
        testObject.setDone(false);
        boolean expected = false;
        assertFalse( testObject.isDone());
    }

    @Test
    public void given_assignee_has_correct_values() {
        testObject.setAssignee(testPerson);
        assertEquals(testPerson, testObject.getAssignee());
    }
}
