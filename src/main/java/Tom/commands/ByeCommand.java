package Tom.commands;

import Tom.tasks.TaskList;
import javafx.application.Application;
//git standard
public class ByeCommand extends Command {

    @Override
    public String execute(TaskList tasks) {
        System.exit(0);
        return "Bye! See you again soon!";
    }

}
