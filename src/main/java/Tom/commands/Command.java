package Tom.commands;

import Tom.TomException;
import Tom.tasks.TaskList;

public abstract class Command {

    public abstract String execute(TaskList tasks) throws TomException;

}
