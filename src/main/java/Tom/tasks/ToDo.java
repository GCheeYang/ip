package Tom.tasks;

public class ToDo extends Task{

    public ToDo(String description){
        super(description, TaskType.TODO);
    }

    public ToDo(String description, boolean status){
        super(description, TaskType.TODO, status);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }


}
