package Tom.commands;

import Tom.tasks.TaskList;
import javafx.application.Application;

public class ByeCommand extends Command {

    @Override
    public String execute(TaskList tasks) {
        System.exit(0);
        return "Bye! See you again soon!";
    }

}
