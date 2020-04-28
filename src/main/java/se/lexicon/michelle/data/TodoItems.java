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

}
