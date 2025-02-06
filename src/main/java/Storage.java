import Tom.tasks.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;

public class Storage {
    private static final String DIRECTORY = "data";
    private static final String FILE_NAME = "tom.txt";
    private static final Path FILE_PATH = Paths.get(DIRECTORY, FILE_NAME);

    public static void ensureFileExists() {
        try {
            Files.createDirectories(FILE_PATH.getParent());
            File file = FILE_PATH.toFile();
            if (!file.exists()) {
                file.createNewFile();
                Ui.printMessage("Created new file: " + FILE_PATH);
            }
        } catch (IOException e) {
            System.out.println("Error creating save file: " + e.getMessage());
        }
    }

    public static List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Scanner scanner = new Scanner(FILE_PATH.toFile())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = Parser.parseTask(line);
                if (task!= null) {
                    tasks.add(task);
                }
            }
            Ui.printMessage("Tasks loaded from file");
        } catch (IOException e) {
            System.out.println("No previous tasks found." + e.getMessage());
        }
        return tasks;
    }

    public static void saveTasks(List<Task> tasks) {
        try (FileWriter writer = new FileWriter(FILE_PATH.toFile())) {
            for (Task task : tasks) {
                writer.write(task + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}
