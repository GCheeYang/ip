public class Events extends Task{
    private String from;
    private String to;

    public Events(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public String toString() {
        return "[E][" + getStatus() + "] " + super.toString() + "(from:" + from + "to:" + to + ")";
    }
}
