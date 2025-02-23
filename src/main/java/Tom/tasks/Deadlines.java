package Tom.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadlines extends Task{
    private LocalDateTime deadline;
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Deadlines (String description, boolean status, String deadlineStr){
        super(description, TaskType.DEADLINE, status);
        this.deadline = LocalDateTime.parse(deadlineStr + " 00:00", INPUT_FORMATTER);
    }

    public Deadlines (String description, boolean status, LocalDateTime deadline) {
        super(description, TaskType.DEADLINE, status);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline.format(OUTPUT_FORMATTER) + ")";
    }
}
