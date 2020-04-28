package se.lexicon.michelle.data;
import se.lexicon.michelle.model.Person;
import se.lexicon.michelle.model.Todo;
import java.util.Arrays;

public class TodoItems {
    private static Todo[] todoArray = new Todo[0];

    /**
     * Returns the size of the todoArray
     *      * @return int
     */
    public int size(){
        return  todoArray.length;
    }

    /**
     * returns the entire array of todoArray
     * @return todoArray
     */
    public Todo[] findAll() {
        return todoArray;
    }

    /**
     * finds the person with the correct id and returns the person,
     * return 0 if person with the specified index is not found.
     * @param todoId int
     * @return the todoObject with the specified id, null if not found
     */
     public Todo findById(int todoId){

         for (Todo todoObject : todoArray) {
             if (todoObject.getTodoId() == todoId) {
                 return todoObject;
             }
         }
        return null;
     }

    /**
     * creates new TodoObject out of the given values
     * then adds them into newTodoArray.
     * sets the todoArray to newTodoArray
     * returns the TodoObject you just created
     * @param description String
     * @return returns the new added TodoObject
     */
     public Todo addTodo(String description){
       Todo todoToAdd = new Todo(
               TodoSequencer.nextTodoId(),
               description
       );

       /*
            Creates a new array with the old arrays length +1
            This to make the array longer so you can add more objects to it
         */
         Todo[] newTodoArray = Arrays.copyOf(todoArray, todoArray.length+1);
         int offset = todoArray.length;
         for (int i = offset, j= 0; i < newTodoArray.length; i++,j++){
             newTodoArray[i] = todoToAdd;
         }
         /*
            Sets todoArray to newTodoArray
            so that the old array now has the new size with the added object.
         */
         todoArray = newTodoArray;

         //returns the new added todoToAdd
         return todoToAdd;
     }

    /**
     * clears the personArray by creating a new Person[] with size 0
     */
    public void clear(){
        todoArray = new Todo[0];
    }

    //Returns array with objects that has a matching done status.

    /**
     * creates a new array with the objects matching a certain status
     * @param doneStatus boolean
     * @return TodoArray
     */
    public Todo[] findByDoneStatus(boolean doneStatus) {

        Todo[] newTodoArray = new Todo[0];

        for (Todo todo : todoArray) {
            if (todo.isDone() == doneStatus) {
                newTodoArray = increaseAddArray(newTodoArray, todo);

            }
        }
        return newTodoArray;
    }

    /**
     * Returns array with objects that has an assignee with a matching personId .
     * @param personId int
     * @return TodoArray
     */
    public Todo[] findByAssignee(int personId){
        Todo[] newTodoArray = new Todo[0];

        for(Todo todo : todoArray){
            //if the id's are the same there is someone assigned to the todoObject
            if(todo.getAssignee().getPersonId() == personId){
                newTodoArray = increaseAddArray(newTodoArray, todo);
            }
        }

    return newTodoArray;
    }

    /**
     * Returns array with objects matching with sent in Person.
     * @param assignee
     * @return
     */
    public Todo[] findByAssignee(Person assignee){
        Todo[] newTodoArray = new Todo[0];

        for(Todo todo : todoArray){
            //checks so that the assignee has the same pesonId, to guarantee that it is the same person
            if(todo.getAssignee().getPersonId() == assignee.getPersonId()){
                newTodoArray = increaseAddArray(newTodoArray, todo);
            }
        }

        return newTodoArray;
    }

    /**
     * checks if there are any unassigned objects,
     * returns a TodoArray with the unassigned Todos.
     * @return TodoArray
     */
    public Todo[] findUnassignedTodoItems(){
        Todo[] newTodoArray = new Todo[0];

        for(Todo todo : todoArray){
            //If getAssignee is empty it is not assigned to anyone.
            if(todo.getAssignee() == null){
                newTodoArray = increaseAddArray(newTodoArray, todo);
            }
        }

        return newTodoArray;
    }

    /**
     * Remove the object with specified id from todoArray
     * @param todoId int
     * @return the new todoArray.
     */
    public Todo[] removeById(final int todoId){
        Todo[]  arrayBeforeTodoId   = new Todo[0],
                arrayAfterTodoId    = new Todo[0],
                newTodoArray        = new Todo[0];

        boolean isFound = false;
        for (Todo todo : todoArray) {
            if (todo.getTodoId() == todoId) {
                isFound = true;
            } else if (!isFound) {
                /*
                every object in the array before the given ID is put in arrayBeforeTodoId
                 */
                arrayBeforeTodoId = increaseAddArray(arrayBeforeTodoId, todo);
            } else {
                /*
                 every object in the array after the given ID is put in arrayAfterTodoId
                */
                arrayAfterTodoId = increaseAddArray(arrayAfterTodoId, todo);
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

        todoArray = newTodoArray;

        return todoArray;
    }

    /**
     * increases the array and adds the new object to new array
     * used to prevent unnecessary duplication of code.
     * @param toIncreaseArray TodoArray
     * @param object TodoObject
     * @return new increased TodoArray
     */
    private Todo[] increaseAddArray(Todo[] toIncreaseArray, Todo object){
        toIncreaseArray = Arrays.copyOf(toIncreaseArray, toIncreaseArray.length + 1);
        toIncreaseArray[toIncreaseArray.length -1] = object;
        return toIncreaseArray;
    }

}
