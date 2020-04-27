package se.lexicon.michelle.data;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.michelle.model.Person;

import static org.junit.Assert.assertEquals;

public class PersonSequencerTest {

    @Before
    public void setUp() throws Exception {
        //used only to make the personId be at a higher value than 0 in the beginning.
        int personId = PersonSequencer.nextPersonID();
    }

    @Test
    public void test_nextPersonId_should_return_correct_value() {
        int expected = 1,
                actual = PersonSequencer.nextPersonID();
        assertEquals(expected, actual);
    }

    @Test
    public void test_reset_should_return_0() {
        int expected = 0;
        PersonSequencer.reset();
        int actual = PersonSequencer.nextPersonID();
        assertEquals(expected, actual);
    }
}
