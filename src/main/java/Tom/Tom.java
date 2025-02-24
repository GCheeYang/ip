package Tom;

import Tom.commands.Command;
import Tom.commands.Parser;
import Tom.tasks.TaskList;

public class Tom {
    private TaskList tasks;
    private Storage storage;

    public Tom() {
        storage = new Storage();
        tasks = new TaskList(storage.loadTasks());
    }

    public String getWelcomeMessage() {
        return "Hello! I am Tom!\n"
                + "Type \"help\" for a list of commands.";
    }

    public String getResponse(String input) {
        try {
            Command command = Parser.parse(input);
            return command.execute(tasks);
        } catch (TomException e) {
            return e.getMessage();
        }
    }
}