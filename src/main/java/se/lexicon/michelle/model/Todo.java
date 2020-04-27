package se.lexicon.michelle.model;

public class Todo {

    /**
     * Private fields
     */
    private final int todoId;
    private String description;
    private boolean done;
    Person assignee;

    /**
     * Todos constructor
     * @param todoId final int
     * @param description String description of the task
     */
    public Todo(int todoId, String description) {
        this.todoId = todoId;
        setDescription(description);
        done = false;

    }


    /**
     * Get Methods
     */
    public int getTodoId() {
        return todoId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public Person getAssignee() {
        return assignee;
    }

    /**
     * Set methods
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }
}
