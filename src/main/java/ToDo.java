public class ToDo extends Task{

    public ToDo(String description){
        super(description);
    }

    @Override
    public String toString() {
        return "[T][" + getStatus() + "] " + super.toString();
    }


}
