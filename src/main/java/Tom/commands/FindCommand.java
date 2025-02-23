package Tom.commands;

import java.util.ArrayList;
import Tom.TomException;
import Tom.tasks.Task;
import Tom.tasks.TaskList;

public class FindCommand extends Command {
    private String searchString;

    public FindCommand(String[] input) throws TomException {
        validateInput(input);
        this.searchString = extractKeyword(input);
    }

    private void validateInput(String[] inputParts) throws TomException {
        if (inputParts.length < 2 || inputParts[1].trim().isEmpty()) {
            throw new TomException("Please search in this format. Usage: find <keyword>");
        }
    }

    private String extractKeyword(String[] inputParts) {
        return inputParts[1].trim().toLowerCase();
    }

    @Override
    public String execute(TaskList tasks) {
        ArrayList<Task> matchingTasks = findMatchingTasks(tasks);

        return formatResult(matchingTasks);
    }

    private ArrayList<Task> findMatchingTasks(TaskList tasks) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks.getTaskList()) {
            if (task.toString().toLowerCase().contains(searchString)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }

    private String formatResult(ArrayList<Task> matchingTasks) {
        if (matchingTasks.isEmpty()) {
            return "No matching tasks found.";
        }

        StringBuilder sb = new StringBuilder("Here are the matching tasks found in your list:\n");
        for (int i = 0; i < matchingTasks.size(); i++) {
            sb.append((i + 1) + ". " + matchingTasks.get(i) + "\n");

        }
        return sb.toString();
    }
}