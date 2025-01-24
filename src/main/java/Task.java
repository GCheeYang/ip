public class Task {
    private String description;
    private boolean status;

    public Task(String description) {
        this.description = description;
        this.status = false;
    }

    public String getStatus() {
        return (status ? "X" : " ");
    }

    public void toggle() {
        this.status = !status;
    }

    public String toString() {
        String str = "[" + this.getStatus() + "] " + this.description;
        return str;
    }
}

