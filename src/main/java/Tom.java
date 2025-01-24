import java.util.*;

public class Tom {
    public static void main(String[] args) {
        String line = "\n________________________________________________\n";
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();

        System.out.println(line + "Hello! I'm Tom\n" + "What Can I do for you?" + line);

        while(true) {
            String input = scanner.nextLine(); //takes in user input
            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!\n" + line);
                break;
            } else if(input.equals("list")) {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(i+1 + ". " + tasks.get(i));
                }
            } else {
                tasks.add(input);
                System.out.println("added: " + input + line);
            }
        }

        scanner.close();

    }



}