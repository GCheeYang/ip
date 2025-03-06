package Tom;

import Tom.commands.Command;
import Tom.commands.Parser;
import Tom.tasks.TaskList;
//commit 1


public class Tom {
    private TaskList tasks;
    private Storage storage;
    private String test;

    public Tom() {
        storage = new Storage();
        tasks = new TaskList(storage.loadTasks());
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