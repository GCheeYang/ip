package Tom.tasks;

import java.util.ArrayList;
import java.util.Stack;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.taskList = tasks;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public Task removeTask(int index) {
        if (index < 0 || index >= taskList.size()) {
            System.out.println("Invalid task number");
        }
        return taskList.remove(index);
    }

    public Task markTask(int index, boolean newStatus) {
        if (index < 0 || index >= taskList.size()) {
            System.out.println("Invalid task number");
        }
        Task task = taskList.get(index);
        task.toggle();
        return task;
    }

    public String printTaskList() {
        if (taskList.isEmpty()) {
            return "No tasks available";
        }

        StringBuilder sb = new StringBuilder("Here are your tasks:\n");
        for (int i = 0; i < taskList.size(); i++) {
            sb.append((i + 1) + ". " + taskList.get(i) + "\n");
        }
        return sb.toString();
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

}
