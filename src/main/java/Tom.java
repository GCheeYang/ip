import Tom.tasks.*;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tom{
    Path filePath = Paths.get("data", "tom.txt");
    private static List<Task> tasks;
    private static String line = "\n_________________________________________________\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(line + "Hello! I'm Tom\n" + "What Can I do for you?" + line);
        Data.ensureFileExists();
        tasks = Data.loadTasks();

        while(true) {
            String input = scanner.nextLine(); //takes in user input
            String[] parts = input.split(" ");

            //general commands
            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!\n" + line);
                Data.saveTasks(tasks);
                break;
            } else if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(i + 1 + ". " + tasks.get(i).toString());
                }
                // Mark/Unmark commands
            } else if (input.contains("unmark")) {
                String itemString = parts[1];
                int item = Integer.parseInt(itemString) - 1;
                tasks.get(item).toggle();
                System.out.println("OK, I've marked this task as not done yet:\n" + tasks.get(item).toString());
            } else if (input.contains("mark")) {
                String itemString = parts[1];
                int item = Integer.parseInt(itemString) - 1;
                tasks.get(item).toggle();
                System.out.println("Nice! I've marked this task as done:\n" + tasks.get(item).toString());
                //inputting new tasks
            } else if (input.startsWith("T")) {
                addToDo(input);
            } else if (input.startsWith("D")) {
                addDeadline(input);
            } else if (input.startsWith("E")) {
                addEvent(input);
            } else if (input.startsWith("delete")) {
                deleteTask(input);
            } else {
                System.out.println("Sorry, that command is not recognised");
            }
        }

        scanner.close();

    }

    private static void addToDo(String input) {
        try {
            Task task = Task.parseTask(input);
            tasks.add(task);
            printTask(task);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Please fill in a description of a todo task");
        }
    }

    private static void addDeadline(String input) {
        try {

            Task task = Task.parseTask(input);
            tasks.add(task);
            printTask(task);
        } catch (Exception e) {
            System.out.println("Sorry, the deadline format is invalid. Use D | <status> | <desc> | <time>");
        }
    }

    private static void addEvent(String input) {
        try {
            Task task = Task.parseTask(input);
            tasks.add(task);
            printTask(task);
        } catch (Exception e) {
            System.out.println("Sorry, the event format is invalid. Use E | <status> | <desc> | <From time> | <To time> ");
        }
    }

    private static void printTask(Task task) {
        System.out.println("Got it. I've added this task:");
        System.out.println(" " + task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list." + line);
    }

    private static void deleteTask(String input) {
        try {
            int taskIndex = Integer.parseInt(input.split(" ")[1]) -1;
            Task task = tasks.get(taskIndex);
            tasks.remove(taskIndex);
            System.out.println("Noted. I've removed this task:");
            System.out.println(" " + task);
            System.out.println("Now you have " + tasks.size() + " tasks in the list." + line);
        } catch (Exception e) {
            System.out.println("Invalid task number");
        }
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        return "Tom heard: " + input;
    }
}