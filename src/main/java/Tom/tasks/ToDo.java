package Tom.tasks;

/**
 * A todo task without any date/time constraint
 */
public class ToDo extends Task{

    /**
     * Creates a ToDo task with a description and status
     *
     * @param description The description of the task
     * @param status The status of the task (completed or not)
     */
    public ToDo(String description, boolean status){
        super(description, status);
    }

    /**
     * Returns a string representation of the todo task
     *
     * @return The formatted string representation of the todo task
     */
    @Override
    public String toString() {
        return "[T][" + getStatus() + "] " + super.toString();
    }


}
