package Duke.Duke;

public class Todo extends Task {

    public Todo(String taskName) {
        super(taskName);
    }

    @Override
    public String getType() {
        return "T";
    }

}