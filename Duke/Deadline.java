package Duke.Duke;

import java.time.LocalDateTime;

public class Deadline extends Task {

    private LocalDateTime datetime;

    public Deadline(String taskName, LocalDateTime datetime) {
        super(taskName);
        this.datetime = datetime;
    }

    @Override
    public String getType() {
        return "D";
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return String.format("[%s][%s] %s (by: %d)",
                this.getType() ,isDone ? "X": " ",
                this.taskName, this.datetime);
    }
}