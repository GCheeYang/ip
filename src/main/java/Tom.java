import java.util.Scanner;

public class Tom {
    public static void main(String[] args) {
        String line = "________________________________________________\n";
        Scanner scanner = new Scanner(System.in);

        System.out.println(line + "Hello! I'm Tom\n" + "What Can I do for you?\n" + line);

        while(true) {
            String input = scanner.nextLine(); //takes in user input
            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!\n" + line);
                break;
            } else {
                System.out.println(input);
            }
        }

        scanner.close();

    }



}