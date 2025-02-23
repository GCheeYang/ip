package Tom.commands;

import Tom.TomException;
import Tom.Storage;
import Tom.tasks.TaskList;
import Tom.tasks.Task;

public class DeleteCommand extends Command {
    private int taskIndex;

    public DeleteCommand(String[] input) throws TomException {
        if (input.length < 2) {
            throw new TomException("Invalid command! Use 'delete <task number>'.");
        }
        this.taskIndex = Integer.parseInt(input[1]) - 1;
    }

    @Override
    public String execute(TaskList tasks) throws TomException {
        Task removedTask = tasks.removeTask(taskIndex);
        Storage.saveTasks(tasks.getTaskList());

        return "This task has been removed:  " + removedTask
                + "\nThere are " + tasks.getTaskList().size() + " remaining tasks in the list.";
    }
}