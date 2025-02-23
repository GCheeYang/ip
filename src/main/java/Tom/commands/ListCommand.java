package Tom.commands;

import Tom.tasks.TaskList;


public class ListCommand extends Command {

    @Override
    public String execute(TaskList taskList) {
        return taskList.printTaskList();
    }
}