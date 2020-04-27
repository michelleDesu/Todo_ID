package se.lexicon.michelle.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TodoSequencerTest {


    @Before
    public void setUp() throws Exception {
        //used only to make the personId be at a higher value than 0 in the beginning.
        int todoId = TodoSequencer.nextTodoId();
    }

    @Test
    public void test_nextPersonId_should_return_correct_value() {
        int expected = 1,
                actual = TodoSequencer.nextTodoId();
        assertEquals(expected, actual);
    }

    @Test
    public void test_reset_should_return_0() {
        int expected = 0;
        TodoSequencer.reset();
        int actual = TodoSequencer.nextTodoId();
        assertEquals(expected, actual);
    }
}
