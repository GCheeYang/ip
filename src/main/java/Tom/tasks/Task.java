package Tom.tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Parent task class
 */
public class Task {
    private String description;
    private boolean status;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    /**
     * Creates a basic task with description and status
     * @param description The description of the task
     * @param status The status of the task
     */
    public Task(String description, boolean status) {
        this.description = description;
        this.status = false;
    }

    /**
     * Finds out the status of a task
     * @return status in string format with X meaning done
     */
    public String getStatus() {
        return (status ? "X" : " ");
    }

    /**
     * changing the status of the task
     */
    public void toggle() {
        this.status = !status;
    }


    /**
     * returns a string representation of a task
     * @return A string representation of a task
     */
    @Override
    public String toString() {
        return this.description;
    }

}

