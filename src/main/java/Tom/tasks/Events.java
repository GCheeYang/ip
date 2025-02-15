package Tom.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Events extends Task{
    private LocalDateTime from;
    private LocalDateTime to;
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Events(String description, boolean status, String fromStr, String toStr) {
        super(description, status);
        this.from = LocalDateTime.parse(fromStr, INPUT_FORMATTER);
        this.to = LocalDateTime.parse(toStr, INPUT_FORMATTER);
    }

    public Events(String description, boolean status, LocalDateTime from, LocalDateTime to) {
        super(description, status);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E][" + getStatus() + "] " + super.toString() + "(From:" + from.format(OUTPUT_FORMATTER) + " To:" + to.format(OUTPUT_FORMATTER) + ")";
    }
}
