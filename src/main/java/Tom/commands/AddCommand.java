package Tom.commands;

import Tom.Storage;
import Tom.TomException;
import Tom.tasks.Deadlines;
import Tom.tasks.ToDo;
import Tom.tasks.Events;
import Tom.tasks.Task;
import Tom.tasks.TaskList;
import Tom.tasks.TaskType;

public class AddCommand extends Command{
    private String[] input;
    private TaskType type;

    public AddCommand(String[] input, TaskType taskType) {
        this.input = input;
        this.type = taskType;
    }

    @Override
    public String execute(TaskList taskList) throws TomException {
        if (input.length < 2 || input[1].isEmpty()) {
            throw new TomException("Please input description!");
        }

        Task task;
        switch (type) {
            case TODO:
                task = new ToDo(input[1]);
                break;
            case DEADLINE:
                task = parseDeadline(input[1]);
                break;
            case EVENT:
                task = parseEvent(input[1]);
                break;
            default:
                throw new TomException("Invalid task type.");
        }

        taskList.addTask(task);
        Storage.saveTasks(taskList.getTaskList());
        return "Task added: \n " + task;
    }

    private Task parseDeadline(String input) throws TomException {
        String[] deadlineParts = input.split(" /by ", 2);
        if (deadlineParts.length < 2) {
            throw new TomException("Invalid deadline format. Use: deadline <description> /by <yyyy-MM-dd>");
        }

        String deadlineStr = normalizeDateFormat(deadlineParts[1].trim());

        return new Deadlines(deadlineParts[0].trim(), false, deadlineStr);
    }

    private Task parseEvent(String input) throws TomException {
        String[] eventParts = input.split(" /from | /to ", 3);
        if (eventParts.length < 3) {
            throw new TomException("Invalid event format. Use: event <description> "
                    + "/from <yyyy-MM-dd> /to <yyyy-MM-dd>");
        }

        String fromStr = normalizeDateFormat(eventParts[1].trim());
        String toStr = normalizeDateFormat(eventParts[2].trim());

        return new Events(eventParts[0].trim(), false, fromStr, toStr);
    }

    private String normalizeDateFormat(String dateStr) {
        String[] parts = dateStr.split(" ");
        String[] dateParts = parts[0].split("-");

        String year = dateParts[0];
        String month = (dateParts[1].length() == 1) ? "0" + dateParts[1] : dateParts[1];
        String day = (dateParts[2].length() == 1) ? "0" + dateParts[2] : dateParts[2];

        String normalizedDate = year + "-" + month + "-" + day;

        return normalizedDate;
    }
}
