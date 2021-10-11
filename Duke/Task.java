package Duke.Duke;

public class Task {
    protected String taskName;
    protected boolean isDone;
    public Task(String name) {
        this.isDone = false;
        this.taskName = name;
    }
    @Override
    public String toString() {
        return String.format("[%s][%s] %s", this.getType() ,isDone ? "X": " ", taskName );
    }

    public boolean hasDone() {
        return this.isDone = true;
    }

    public String getTaskName() {
        return this.taskName;
    }
    public String getType() {
        return " ";
    }
}