package Tom.tasks;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Handles all tasks in the tasklist
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * creates a new tasklist
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Initializes tasklist
     * @param tasks The list of tasks to initialize
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * add a task to the tasklist
     * @param task the task to be added to the tasklist
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * remove a task from the tasklist
     * @param index the index of the task to be removed
     * @return return the task that is removed
     */
    public Task removeTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task number");
        }
        return tasks.remove(index);
    }

    /**
     * Prints the tasklist with all tasks
     * @param ui The UI used to print messages
     */
    public void printTaskList(Ui ui) {
        if (tasks.isEmpty()) {
            ui.printMessage("No tasks added yet.");
            return;
        }

        StringBuilder sb = new StringBuilder("These are your tasks:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(" ").append(i + 1).append(". ").append(tasks.get(i)).append("\n");
        }
        ui.printMessage(sb.toString());
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

}
