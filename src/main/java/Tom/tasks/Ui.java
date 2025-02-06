package Tom.tasks;

import java.util.Scanner;

public class Ui {
    private final Scanner sc;
    private static final String SPACING = "_________________________________________________";

    public Ui() {
        sc = new Scanner(System.in);
    }

    public static void welcome() {
        System.out.println(SPACING);
        System.out.println("Hello I am Tom, task manager 10.0");
        System.out.println("What can I do for you?");
        System.out.println(SPACING);
    }

    public static void printMessage(String message){
        System.out.println(SPACING);
        System.out.println(message);
        System.out.println(SPACING);
    }

}
