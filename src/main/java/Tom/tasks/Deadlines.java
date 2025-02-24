package Tom.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a deadline
 */
public class Deadlines extends Task{
    private LocalDateTime deadline;
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");

    /**
     * Creates a Deadline task with a due date.
     *
     * @param description The task description.
     * @param status If the task is completed or not
     * @param deadlineStr The deadline date in "yyyy-MM-dd" format.
     */
    public Deadlines (String description, boolean status, String deadlineStr){
        super(description, TaskType.DEADLINE, status);
        this.deadline = LocalDateTime.parse(deadlineStr + " 00:00", INPUT_FORMATTER);
    }

    /**
     * Creates a Deadline task with a due date.
     *
     * @param description The task description.
     * @param status If the task is completed or not
     * @param deadline The deadline date in "yyyy-MM-dd" format.
     */
    public Deadlines (String description, boolean status, LocalDateTime deadline) {
        super(description, TaskType.DEADLINE, status);
        this.deadline = deadline;
    }

    /**
     * Returns a formatted string representation of the deadline task.
     *
     * @return A formatted string representing the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline.format(OUTPUT_FORMATTER) + ")";
    }
}
