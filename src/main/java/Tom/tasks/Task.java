package Tom.tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//task commit
/**
 * This is an abstract class that serves as the base for specific task types like Todo, Deadline, and Event.
 */
public class Task {
    private String description;
    private boolean status;
    private TaskType taskType;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * Constructs a Task with a description and task type.
     *
     * @param description The description of the task.
     * @param taskType The type of task (TODO, DEADLINE, or EVENT).
     */
    public Task(String description, TaskType taskType) {
        this.description = description;
        this.status = false;
        this.taskType = taskType;
    }

    /**
     * Constructs a Task with a description, task type, and completion status.
     *
     * @param description The description of the task.
     * @param taskType The type of task (TODO, DEADLINE, or EVENT).
     * @param status If the task is completed or not
     */
    public Task(String description, TaskType taskType, boolean status) {
        this.description = description;
        this.status = false;
        this.taskType = taskType;
    }

    /**
     * Returns the status icon of the task.
     *
     * @return "X" if the task is completed, otherwise a space " ".
     */
    public String getStatus() {
        return (status ? "X" : " ");
    }

    /**
     * Marks the task as done or undone.
     */
    public void toggle() {
        this.status = !status;
    }

    /**
     *
     * @param line The input that will be converted to a task
     * @return A newly created task with details such as description, deadline and status
     */
    public static Task parseTask(String line) {
        String[] parts = line.split("\\| ");

        if (parts.length < 3) { // Ensuring that at least type, status, and description exist
            System.out.println("Invalid task format: " + line);
            return null;
        }

        String type = parts[0];
        boolean isDone = parts[1].equals("1 ");
        String description = parts[2];

        try {
            if (type.equals("T ")) {
                return new ToDo(description, isDone);
            } else if (type.equals("D ")) {
                if (parts.length < 4) {
                    System.out.println("Invalid deadline format: " + line);
                    return null;
                }
                LocalDateTime deadlineDate = LocalDateTime.parse(parts[3], DATE_FORMATTER);
                return new Deadlines(description, isDone, deadlineDate);
            } else if (type.equals("E ")) {
                if (parts.length < 5) {
                    System.out.println("Invalid event format: " + line);
                    return null;
                }
                LocalDateTime eventFrom = LocalDateTime.parse(parts[3].substring(0, parts[3].length() - 1), DATE_FORMATTER);
                LocalDateTime eventTo = LocalDateTime.parse(parts[4], DATE_FORMATTER);

                return new Events(description, isDone, eventFrom, eventTo);
            } else {
                System.out.println("Unknown task type: " + line);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error parsing task: " + line);
            return null;
        }
    }

    /**
     * Returns a string representation of the task.
     *
     * @return The formatted string representation of the task.
     */
    @Override
    public String toString() {
        return "[" + getStatus() + "] " + this.description;
    }

}

