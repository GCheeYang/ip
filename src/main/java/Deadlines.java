public class Deadlines extends Task{
    private String deadline;

    public Deadlines (String description, String deadline){
        super(description);
        this.deadline = deadline;
    }

    public String toString() {
        return "[D][" + getStatus() + "] " + super.toString() + "(by:" + deadline + ")";
    }
}
