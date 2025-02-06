package Tom.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * An Event task with start and end date/time
 */
public class Events extends Task{
    private LocalDateTime from;
    private LocalDateTime to;
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");

    /**
     * creates an Event Task with a start and end date
     *
     * @param description The task description
     * @param status The task status
     * @param fromStr The task start date/time in string format
     * @param toStr The task end date/time in string format
     */
    public Events(String description, boolean status, String fromStr, String toStr) {
        super(description, status);
        this.from = LocalDateTime.parse(fromStr, INPUT_FORMATTER);
        this.to = LocalDateTime.parse(toStr, INPUT_FORMATTER);
    }

    /**
     * creates an Event Task with a start and end date
     *
     * @param description The task description
     * @param status The task status
     * @param from The task start date/time in LocalDateTime format
     * @param to The task end date/time in LocalDateTime format
     */
    public Events(String description, boolean status, LocalDateTime from, LocalDateTime to) {
        super(description, status);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns a formatted string representation of an Event
     * @return A formatted string representation of an Event
     */
    @Override
    public String toString() {
        return "[E][" + getStatus() + "] " + super.toString() + "(From:" + from.format(OUTPUT_FORMATTER) + " To:" + to.format(OUTPUT_FORMATTER) + ")";
    }
}
