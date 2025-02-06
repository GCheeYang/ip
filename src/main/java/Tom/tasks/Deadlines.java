package Tom.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A Deadline task with a due date
 */
public class Deadlines extends Task{
    private LocalDateTime deadline;
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");

    /**
     * Creates a dateline task with description, status and string input for the deadline
     * @param description The task description
     * @param status The task status
     * @param deadlineStr The task deadline in string format
     */
    public Deadlines (String description, boolean status, String deadlineStr){
        super(description, status);
        this.deadline = LocalDateTime.parse(deadlineStr, INPUT_FORMATTER);
    }

    /**
     * Creates a dateline task with description, status and LocalDateTime input for the deadline
     * @param description The task description
     * @param status The task status
     * @param deadline The task deadline in LocalDateTime format
     */
    public Deadlines (String description, boolean status, LocalDateTime deadline) {
        super(description,status);
        this.deadline = deadline;
    }

    /**
     * Returns a formatted string representation of deadline task
     * @return A formatted string representation of deadline task
     */
    @Override
    public String toString() {
        return "[D][" + getStatus() + "] " + super.toString() + "(by:" + deadline.format(OUTPUT_FORMATTER) + ")";
    }
}
