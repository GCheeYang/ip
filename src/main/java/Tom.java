import java.util.*;

public class Tom {
    private static List<Task> tasks = new ArrayList<>();
    private static String line = "\n_________________________________________________\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(line + "Hello! I'm Tom\n" + "What Can I do for you?" + line);

        while(true) {
            String input = scanner.nextLine(); //takes in user input
            String[] parts = input.split(" ");

            //general commands
            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!\n" + line);
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
            } else if (input.startsWith("todo")) {
                addToDo(input);
            } else if (input.startsWith("deadline")) {
                addDeadline(input);
            } else if (input.startsWith("event")) {
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
            String description = input.substring(5);
            Task task = new ToDo(description);
            tasks.add(task);
            printTask(task);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Please fill in a description of a todo task");
        }
    }

    private static void addDeadline(String input) {
        try {
            String[] parts = input.substring(9).split("/by");
            String description = parts[0];
            String deadline = parts[1];
            Task task = new Deadlines(description, deadline);
            tasks.add(task);
            printTask(task);
        } catch (Exception e) {
            System.out.println("Sorry, the deadline format is invalid. Use deadline <desc> /by <time>");
        }
    }

    private static void addEvent(String input) {
        try {
            String[] parts = input.substring(6).split("/from|/to");
            String description = parts[0];
            String from = parts[1];
            String to = parts[2];
            Task task = new Events(description, from, to);
            tasks.add(task);
            printTask(task);
        } catch (Exception e) {
            System.out.println("Sorry, the event format is invalid. Use event <desc> /from <start> /to <end>");
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


}