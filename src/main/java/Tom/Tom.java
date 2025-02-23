package Tom;

import Tom.tasks.TaskList;
import Tom.commands.Command;
import Tom.commands.Parser;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tom {
    private TaskList tasks;
    private Storage storage;

    public Tom() {
        storage = new Storage();
        tasks = new TaskList(storage.loadTasks());
    }

    public static String welcomeMessage() {
        return "Hello! I'm Tom! \n" + "What Can I do for you?\n"
                + "Type help to get started!";
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