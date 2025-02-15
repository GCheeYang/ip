package Tom.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadlines extends Task{
    private LocalDateTime deadline;
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Deadlines (String description, boolean status, String deadlineStr){
        super(description, status);
        this.deadline = LocalDateTime.parse(deadlineStr, INPUT_FORMATTER);
    }

    public Deadlines (String description, boolean status, LocalDateTime deadline) {
        super(description,status);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D][" + getStatus() + "] " + super.toString() + "(by:" + deadline.format(OUTPUT_FORMATTER) + ")";
    }
}
