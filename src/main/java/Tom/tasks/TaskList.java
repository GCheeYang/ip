package Tom.tasks;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task removeTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task number");
        }
        return tasks.remove(index);
    }

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
