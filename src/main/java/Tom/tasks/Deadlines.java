package Tom.tasks;

public class Deadlines extends Task{
    private String deadline;

    public Deadlines (String description, boolean status, String deadline){
        super(description, status);
        this.deadline = deadline;
    }

    public String toString() {
        return "[D][" + getStatus() + "] " + super.toString() + "(by:" + deadline + ")";
    }
}
