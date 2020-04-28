package se.lexicon.michelle.data;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.michelle.model.Person;
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

        /*
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
    
    //findByDoneStatus

    @Test
    public void findByDoneStatus_given_true_should_return_array_with_done() {
        boolean isDone = true;
        firstTodo.setDone(isDone);
        Todo thirdTodo = todoTest.addTodo( "This is the third todo");
        thirdTodo.setDone(isDone);


        Todo[] expected = new Todo[2];
        expected[0] = firstTodo;
        expected[1] = thirdTodo;

        Todo[] actual = todoTest.findByDoneStatus(isDone);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void findByDoneStatus_given_false_should_return_array_with_done() {
        boolean isDone = false;
        firstTodo.setDone(isDone);
        Todo thirdTodo = todoTest.addTodo( "This is the third todo");
        thirdTodo.setDone(isDone);


        Todo[] expected = new Todo[3];
        expected[0] = firstTodo;
        expected[1] = secondTodo;
        expected[2] = thirdTodo;

        Todo[] actual = todoTest.findByDoneStatus(isDone);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findByAssigneeId_should_return_correct_todoArray() {
        Person firstPerson = new Person(
                PersonSequencer.nextPersonId(),
                "Haldur",
                "Rind"
        );

        Todo[] expected = new Todo[2];
        expected[0] = firstTodo;
        expected[1] = secondTodo;

        firstTodo.setAssignee(firstPerson);
        secondTodo.setAssignee(firstPerson);

        int personId = firstPerson.getPersonId();

        Todo[] actual = todoTest.findByAssignee(personId);

        assertArrayEquals(expected, actual);

    }

    @Test
    public void given_assignee_findByAssignee_should_return_correct_todoArray() {
        Person firstPerson = new Person(
                PersonSequencer.nextPersonId(),
                "Saga",
                "Helga"
        );

        Todo[] expected = new Todo[2];
        expected[0] = firstTodo;
        expected[1] = secondTodo;

        firstTodo.setAssignee(firstPerson);
        secondTodo.setAssignee(firstPerson);

        Todo[] actual = todoTest.findByAssignee(firstPerson);

        assertArrayEquals(expected, actual);

    }
    @Test
    public void findUnassignedTodoItems_should_return_unassigned_todo_todoArray() {

        Todo[] expected = new Todo[2];
        expected[0] = firstTodo;
        expected[1] = secondTodo;

        Todo[] actual = todoTest.findUnassignedTodoItems();

        assertArrayEquals(expected, actual);

    }

}
