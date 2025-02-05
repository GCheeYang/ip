package Tom.tasks;

public class ToDo extends Task{

    public ToDo(String description, boolean status){
        super(description, status);
    }

    @Override
    public String toString() {
        return "[T][" + getStatus() + "] " + super.toString();
    }


}
