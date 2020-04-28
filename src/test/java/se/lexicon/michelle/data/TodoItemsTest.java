package se.lexicon.michelle.data;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.michelle.model.Todo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TodoItemsTest {
    private TodoItems todoTest;
    private Todo        firstTodo,
                        secondTodo;

    @Before
    public void setUp() throws Exception {
        todoTest = new TodoItems();
        todoTest.clear();
        TodoSequencer.reset();

        /**
         *  creates todos to have easy access to them later on
         */
        String firstDescription = "This is my first todo",
                secondDescription = "This is my second todo";

        firstTodo = todoTest.addTodo(firstDescription);
        secondTodo = todoTest.addTodo(secondDescription);
    }

    //AddTodo(description)
    @Test
    public void given_description_shouldReturn_addedTodo() {
        Todo expected = new Todo(
          2,
          "This is my third description"
        ),
        actual = todoTest.addTodo("This is my third description" );
        assertEquals(expected.getTodoId(),actual.getTodoId()) ;
        assertEquals(expected.getDescription(), actual.getDescription() );
    }

    //size()
    @Test
    public void size_method_should_return_correct_size_of_array() {
        int expected = 2,
                actual = todoTest.size();
        assertEquals(expected, actual);
    }

    //findAll()
    @Test
    public void findAll_should_return_all_objects_in_array() {
        Todo[] expected = new Todo[2];
        expected[0] = firstTodo;
        expected[1] = secondTodo;

        assertArrayEquals(expected, todoTest.findAll() );
    }

    //findById(todoId)
    @Test
    public void given_id_should_return_correct_id() {
     Todo actual = todoTest.findById(1);
     assertEquals(secondTodo, actual);
    }

   //clear()

    @Test
    public void clear_should_clear_the_array() {
        Todo[] expected = new Todo[0];
        todoTest.clear();
        Todo[] actual = todoTest.findAll();

        assertArrayEquals(expected, actual);
    }
}
