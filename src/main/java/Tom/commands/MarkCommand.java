package Tom.commands;

import Tom.TomException;
import Tom.Storage;
import Tom.tasks.Task;
import Tom.tasks.TaskList;

public class MarkCommand extends Command {
    private int taskIndex;
    private boolean isMarkingDone;

    public MarkCommand(String[] inputParts, boolean isMarkingDone) throws TomException {
        if (inputParts.length < 2) {
            throw new TomException("Invalid command! Use 'mark <task number>' or 'unmark <task number>'.");
        }
        try {
            this.taskIndex = Integer.parseInt(inputParts[1]) - 1;
        } catch (NumberFormatException e) {
            throw new TomException("Invalid task number! Use a valid number.");
        }
        this.isMarkingDone = isMarkingDone;
    }

    @Override
    public String execute(TaskList tasks) throws TomException {
        Task task = tasks.markTask(taskIndex, isMarkingDone);
        Storage.saveTasks(tasks.getTaskList());

        return isMarkingDone
                ? "Well done, this task is completed!\n   " + task
                : "Lets's work on this task! It is not done yet:\n   " + task;
    }
}