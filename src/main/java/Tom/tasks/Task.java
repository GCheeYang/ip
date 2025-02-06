package Tom.tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String description;
    private boolean status;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    public Task(String description, boolean status) {
        this.description = description;
        this.status = false;
    }

    public String getStatus() {
        return (status ? "X" : " ");
    }

    public void toggle() {
        this.status = !status;
    }


    @Override
    public String toString() {
        return this.description;
    }

}

