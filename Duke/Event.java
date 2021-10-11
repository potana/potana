package Duke.Duke;

import java.time.LocalDateTime;

public class Event extends Task {

    private LocalDateTime datetime;

    public Event(String taskName, LocalDateTime datetime) {
        super(taskName);
        this.datetime = datetime;
    }

    @Override
    public String getType() {
        return "E";
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return String.format("[%s][%s] %s (at: %s)",
                this.getType() ,isDone ? "X": " ",
                this.taskName, this.datetime);
    }
}