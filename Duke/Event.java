package Duke.Duke;

import java.time.LocalDateTime;

public class Event extends Task {

    private LocalDateTime dateTime;

    public Event(String taskName, LocalDateTime datetime) {
        super(taskName);
        this.dateTime = datetime;
    }

    @Override
    public String getType() {
        return "E";
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return String.format("[%s][%s] %s (by: %d/%d/%d)",
                this.getType() ,isDone ? "X": " ",
                this.taskName, this.dateTime.getYear(), this.dateTime.getMonthValue(), this.dateTime.getDayOfMonth());
    }
}