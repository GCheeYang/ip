package Tom.tasks;

public class Task {
    private String description;
    private boolean status;

    public Task(String description, boolean status) {
        this.description = description;
        this.status = false;
    }

    public String getStatus() {
        return (status ? "X" : " ");
    }

    public void toggle() {
        this.status = !status;
    }

    public static Task parseTask(String line) {
        String[] parts = line.split("\\| ");

        if (parts.length < 3) { // Ensuring that at least type, status, and description exist
            System.out.println("Invalid task format: " + line);
            return null;
        }

        String type = parts[0];
        boolean isDone = parts[1].equals("1 ");
        String description = parts[2];

        try {
            if (type.equals("T ")) {
                return new ToDo(description, isDone);
            } else if (type.equals("D ")) {
                if (parts.length < 4) {
                    System.out.println("Invalid deadline format: " + line);
                    return null;
                }
                return new Deadlines(description, isDone, parts[3]);
            } else if (type.equals("E ")) {
                if (parts.length < 4) {
                    System.out.println("Invalid event format: " + line);
                    return null;
                }
                return new Events(description, isDone, parts[3], parts[4]);
            } else {
                System.out.println("Unknown task type: " + line);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error parsing task: " + line);
            return null;
        }
    }


    @Override
    public String toString() {
        return this.description;
    }

}

